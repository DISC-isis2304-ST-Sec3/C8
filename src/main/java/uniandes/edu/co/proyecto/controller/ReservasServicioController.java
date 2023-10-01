package uniandes.edu.co.proyecto.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Habitaciones;
import uniandes.edu.co.proyecto.modelo.ReservasServicio;
import uniandes.edu.co.proyecto.repositorio.HabitacionesRepository;
import uniandes.edu.co.proyecto.repositorio.ReservasServicioRepository;

@Controller
public class ReservasServicioController {

    @Autowired
    private ReservasServicioRepository reservasServicioRepository;

    @Autowired
    private HabitacionesRepository habitacionesRepository;

    @GetMapping("/reservasServicio")
    public String reservasServicio(Model model) {
        model.addAttribute("reservasServicio", reservasServicioRepository.darReservasServicio());
        return "reservasServicio";
    }

    @GetMapping("/reservasServicio/new")
    public String reservasServicioForm(Model model) {
        model.addAttribute("reservasServicio", new ReservasServicio());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        return "reservasServicioNuevo";
    }

    @PostMapping("/reservasServicio/new/save") 
    public String reservasServicioGuardar(@ModelAttribute("duracion_hora") int duracion_hora,
        @ModelAttribute("dia") Date dia, @ModelAttribute("hora") String hora,
        @ModelAttribute("habitaciones_id") Habitaciones habitaciones_id){
        Integer habitacionesId =  habitaciones_id.getId();
        reservasServicioRepository.insertarReservaServicio(duracion_hora, dia, hora, habitacionesId);
        return "redirect:/reservasServicio";
    }


    @GetMapping("/reservasServicio/{id}/delete")
    public String reservasServicioEliminar(@PathVariable("id") int id) {
        reservasServicioRepository.eliminarReservaServicio(id);
        return "redirect:/reservasServicio";
    }
}
