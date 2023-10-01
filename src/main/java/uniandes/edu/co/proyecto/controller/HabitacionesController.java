package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Habitaciones;
import uniandes.edu.co.proyecto.repositorio.TiposHabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionesRepository;

@Controller
public class HabitacionesController {
    
    @Autowired
    private HabitacionesRepository habitacionesRepository;
    
    @Autowired
    private TiposHabitacionRepository tiposHabitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
        public String habitacionesForm(Model model) {
        model.addAttribute("habitaciones", new Habitaciones());
        model.addAttribute("tiposHabitacion", tiposHabitacionRepository.darTiposHabitacion());
        return "habitacionesNuevo";
    }

    
    @PostMapping("/habitaciones/new/save")
    public String habitacionesGuardar(@RequestParam(value = "id") int id,
    @ModelAttribute("capacidad") int capacidad, @ModelAttribute("costo") double costo,
    @ModelAttribute("tipoHabitacion") String tipoHabitacion) {
        if (id == 0) {
            habitacionesRepository.insertarHabitacion2(capacidad, costo, tipoHabitacion);
        } else {
            habitacionesRepository.insertarHabitacion(id, capacidad, costo, tipoHabitacion);
        }
        return "redirect:/habitaciones";
    }
    
    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionesEditarForm(@PathVariable("id") int id, Model model) {
        habitacionesRepository.eliminarHabitacion(id);
        model.addAttribute("habitaciones", new Habitaciones());
        model.addAttribute("tiposHabitacion", tiposHabitacionRepository.darTiposHabitacion());
        return "habitacionesNuevo";
    }
  
    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionesEliminar(@PathVariable("id") int id) {
        habitacionesRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }
    
    
}