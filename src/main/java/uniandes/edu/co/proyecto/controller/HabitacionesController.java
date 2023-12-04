package uniandes.edu.co.proyecto.controller;
import java.util.Collections;
import java.util.List;

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

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class HabitacionesController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    private HabitacionRepository habitacionRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/habitaciones")
    public String getHabitaciones(Model model){
        model.addAttribute("habitaciones", habitacionRepo.findAll());
        return "habitaciones";
    }
    

    @GetMapping("/habitacionForm")
    public String mostrarFormulario(Model model) {
        // Creamos una instancia vacía para el nuevo BebidaTipos
        model.addAttribute("nuevaHabitacion", new Habitacion());
        model.addAttribute("tiposHabitacionDisponibles", tipoHabitacionRepository.findAll());
        return "habitacionForm";
    }

    @PostMapping("/crearHabitacion")
    public String crearHabitacion(@ModelAttribute("nuevaHabitacion") Habitacion habitacion) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion(habitacion.getTipoHabitacion().getTipo(), habitacion.getTipoHabitacion().getJacuzzi(), habitacion.getTipoHabitacion().getComedor(), habitacion.getTipoHabitacion().getCocina());
        tipoHabitacionRepository.save(tipoHabitacion);
        habitacion.setTipoHabitacion(tipoHabitacion);

        habitacionRepo.save(habitacion);
        return "redirect:/habitaciones";   
    }

    @PostMapping("/deleteHabitacion")
    public String eliminarHabitacion(@RequestParam(name = "id", required = false) String id) {
        habitacionRepo.deleteById(id);
        return "redirect:/habitaciones";
    }
}