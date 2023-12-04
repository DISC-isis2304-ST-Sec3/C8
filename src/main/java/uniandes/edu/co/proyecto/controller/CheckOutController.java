
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
import uniandes.edu.co.proyecto.modelo.CheckOut;
import uniandes.edu.co.proyecto.repositorio.CheckInRepository;
import uniandes.edu.co.proyecto.repositorio.CheckOutRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;


@Controller
public class CheckOutController {

    @Autowired
    private CheckOutRepository checkOutRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/checkOut")
    public String getCheckOut(Model model){

        model.addAttribute("checkOut", checkOutRepository.findAll());
        return "checkOut";

    }
    

    @GetMapping("/crearCheckOut")
    public String mostrarFormulario(Model model) {
        // Creamos una instancia vacía para el nuevo BebidaTipos
        model.addAttribute("nuevoCheckOut", new CheckOut());
        model.addAttribute("reservasDisponibles", reservaRepository.findAll());
        model.addAttribute("clientesDisponibles", clienteRepository.findAll());
        return "checkOutForm";
    }

    @PostMapping("/crearCheckOutNuevo")
    public String crearCheckOut(@ModelAttribute("nuevoCheckOut") CheckOut checkOut) {
        checkOutRepository.save(checkOut);
            return "redirect:/checkOut";
    }

    @PostMapping("/deleteCheckOut")
    public String eliminarCheckOut(@RequestParam(name = "id", required = false) String id) {
        checkOutRepository.deleteById(id);
        return "redirect:/checkOut";
    }
    
    
}
