package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.CheckOuts;
import uniandes.edu.co.proyecto.repositorio.CheckOutsRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionesRepository;
import uniandes.edu.co.proyecto.repositorio.ReservasRepository;

@Controller
public class CheckOutsController {
    
    public static int idHab;

    @Autowired
    private CheckOutsRepository checkOutsRepository;
    
    @Autowired
    private ReservasRepository reservasRepository;
    
    @Autowired
    private HabitacionesRepository habitacionesRepository;

    @GetMapping("/checkOuts")
    public String checkOuts(Model model) {
        model.addAttribute("checkOuts", checkOutsRepository.darCheckOuts());
        model.addAttribute("reservas", reservasRepository.darReservas());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        return "checkOuts";
    }
    
    @GetMapping("/checkOuts/new")
    public String checkOutsForm(Model model) {
        model.addAttribute("checkOuts", new CheckOuts());
        model.addAttribute("reservas", reservasRepository.darReservas());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        return "checkOutsNuevo";
    }
    
    @PostMapping("/checkOuts/new/save") 
    public String checkOutsGuardar(@RequestParam(value = "reservasId", required = true) Integer idRes,
    @RequestParam(value = "habitacionesId", required = true) Integer idHab,
    @ModelAttribute("fechaSalida") String fechaI) {
        
        String fs = fechaI;
        String fs2 = checkOutsRepository.fechaValidacion(idRes);
        
        String a = fs.substring(0, Math.min(fs.length(), 10));
        String b = fs2.substring(0, Math.min(fs2.length(), 10));
        
        if (a.equals(b)) {
            checkOutsRepository.insertarCheckOut(idRes, idHab, fechaI); 
        } else {
            return "error";
        }
        return "redirect:/checkOuts";
    }
    
    @GetMapping("/checkOuts/{idRes}/delete")
    public String checkOutsEliminar(@PathVariable("idRes") int idRes) {
        checkOutsRepository.eliminarCheckOut(idRes);
        return "redirect:/checkOuts";
    }
    
    @GetMapping("/checkOuts/{idHab}/consumos/paz")
    public String checkOutsEliminarConsumos(Model model) {
        checkOutsRepository.eliminarConsumos(CheckOutsController.idHab);
        return "redirect:/checkOuts";
    }
    
    @GetMapping("/checkOuts/{idRes}/edit")
    public String checkOutsEditarForm(@PathVariable("idRes") int idRes, Model model) {
        checkOutsRepository.eliminarCheckOut(idRes);
        model.addAttribute("checkOuts", checkOutsRepository.darCheckOuts());
        model.addAttribute("reservas", reservasRepository.darReservas());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        model.addAttribute("checkOuts", new CheckOuts());
        return "checkOutsNuevo";
        
    }
    

    @GetMapping("/checkOuts/{idHab}/consumos")
    public String consumos(Model model, @PathVariable("idHab") int idHab) {
        model.addAttribute("consumos", checkOutsRepository.consumosHabitacion(idHab));
        model.addAttribute("consumos2", checkOutsRepository.consumos2Habitacion(idHab));
        model.addAttribute("consumos3", checkOutsRepository.consumos3Habitacion(idHab));
        model.addAttribute("habitac", idHab);
        CheckOutsController.idHab = idHab;
        return "checkOutsConsumos";
    }
}

