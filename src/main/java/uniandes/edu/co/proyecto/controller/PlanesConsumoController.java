package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.PlanesConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanesConsumorepository;

@Controller
public class PlanesConsumoController {
    
    @Autowired
    private PlanesConsumorepository planesConsumoRepository;

    @GetMapping("/planesConsumo")
    public String planesConsumo(Model model) {
        model.addAttribute("planesConsumo", planesConsumoRepository.darPlanesConsumo());
        return "planesConsumo";
    }

    @GetMapping("/planesConsumo/new")
    public String planesConsumoForm(Model model) {
        model.addAttribute("planesConsumo", new PlanesConsumo());
        return "planesConsumoNuevo";
    }
    
    @PostMapping("/planesConsumo/new/save") 
    public String planesConsumoGuardar(@ModelAttribute("nombre") String nombre,
                                       @RequestParam(value = "estadiaMin", required = true) int estadiaMin,
                                       @RequestParam(value = "costo", required = true) double costo,
                                       @RequestParam(value = "descReserva", required = true) double descReserva,
                                       @RequestParam(value = "descBar", required = true) double descBar,
                                       @RequestParam(value = "descRestaurante", required = true) double descRestaurante,
                                       @RequestParam(value = "descServicio", required = true) double descServicio) {
        
        planesConsumoRepository.insertarPlanConsumo(nombre, estadiaMin, costo, descReserva, descBar, descRestaurante, descServicio);
        return "redirect:/planesConsumo";
    }
    
    @GetMapping("/planesConsumo/{id}/delete")
    public String planesConsumoEliminar(@PathVariable("id") int id) {
        planesConsumoRepository.eliminarPlanConsumo(id);
        return "redirect:/planesConsumo";
    }
    
    @GetMapping("/planesConsumo/{id}/edit")
    public String planesConsumoEditar(@PathVariable("id") int id, Model model) {
        planesConsumoRepository.eliminarPlanConsumo(id);
        model.addAttribute("planesConsumo", new PlanesConsumo());
        return "planesConsumoNuevo";
    }
    
}
