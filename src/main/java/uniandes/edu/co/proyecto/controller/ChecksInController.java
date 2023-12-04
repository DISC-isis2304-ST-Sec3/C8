
package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.CheckIn;
import uniandes.edu.co.proyecto.repositorio.CheckInRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;


@Controller
public class ChecksInController {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/checksIn")
    public String getChecksIn(Model model){

        model.addAttribute("checksIn", checkInRepository.findAll());
        return "checksIn";

    }
    

    @GetMapping("/crearCheckIn")
    public String mostrarFormulario(Model model) {
        // Creamos una instancia vacía para el nuevo BebidaTipos
        model.addAttribute("nuevoCheckIn", new CheckIn());
        model.addAttribute("reservasDisponibles", reservaRepository.findAll());
        model.addAttribute("clientesDisponibles", clienteRepository.findAll());
        return "checkInForm";
    }

    @PostMapping("/crearCheckInNuevo")
    public String crearCheckIn(@ModelAttribute("nuevoCheckIn") CheckIn checkIn) {
        checkInRepository.save(checkIn);
            return "redirect:/checksIn";
    }

    @PostMapping("/deleteCheckIn")
    public String eliminarCheckIn(@RequestParam(name = "id", required = false) String id) {
        checkInRepository.deleteById(id);
        return "redirect:/checksIn";
    }
    
    
}
