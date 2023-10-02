package uniandes.edu.co.proyecto.controller;


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

    @GetMapping("/reservasServicio/spa/new")
    public String reservasSpaForm(Model model) {
        model.addAttribute("reservasServicio", new ReservasServicio());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        model.addAttribute("spas", reservasServicioRepository.darServiciosSpa());
        return "reservasServicioNuevoSpa";
    }

    @PostMapping("/reservasServicio/new/save") 
    public String reservasServicioGuardar(@ModelAttribute("duracion_hora") int duracion_hora,
        @ModelAttribute("dia") String dia, @ModelAttribute("hora") String hora,
        @ModelAttribute("habitacion") int id){
        reservasServicioRepository.insertarReservaServicio(duracion_hora, dia, hora, id);
        return "redirect:/reservasServicio";
    }
    
    @PostMapping("/reservasServicio/new/spa/save") 
    public String reservasServicioGuardarSpa(@ModelAttribute("spaId") int servicioId,
        @ModelAttribute("dia") String dia, @ModelAttribute("hora") String hora,
        @ModelAttribute("habitacion") Habitaciones habitaciones_id){
        Integer habitacionesId =  habitaciones_id.getId();
        int duracion = (int) reservasServicioRepository.duracionServicioSpa(servicioId);
        int spaId = reservasServicioRepository.daridSpaServicio(servicioId);
        reservasServicioRepository.insertarReservaServicio(duracion, dia, hora, habitacionesId);
        //reservasServicioRepository.insertarReservaSpa(servicioId, spaId);
        return "redirect:/reservasServicio";
    }

    @GetMapping("/reservasServicio/{id}/delete")
    public String reservasServicioEliminar(@PathVariable("id") int id) {
        reservasServicioRepository.eliminarReservaServicio(id);
        return "redirect:/reservasServicio";
    }

    @GetMapping("/reservasServicio/{id}/edit")
    public String reservasServicioEditar(@PathVariable("id") int id, Model model) {
        reservasServicioRepository.eliminarReservaServicio(id);
        model.addAttribute("reservasServicio", new ReservasServicio());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        return "reservasServicioNuevo";
    }
}
