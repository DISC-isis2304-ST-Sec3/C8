package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Reservas;
import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.repositorio.PlanesConsumorepository;
import uniandes.edu.co.proyecto.repositorio.ReservasRepository;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@Controller
public class ReservasController {
    
    @Autowired
    private ReservasRepository reservasRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private PlanesConsumorepository planConsumoRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservasRepository.darReservas());
        return "reservas";
    }
    
    @GetMapping("/reservas/new")
    public String reservasForm(Model model) {
        model.addAttribute("reservas", new Reservas());
        model.addAttribute("usuarios", usuariosRepository.darUsuarios());
        model.addAttribute("planesConsumo", planConsumoRepository.darPlanesConsumo());
        return "reservasNuevo";
    }
    
    @PostMapping("/reservas/new/save") 
    public String reservasGuardar(@ModelAttribute("fechaInicio") String fechaInicio,
                                       @ModelAttribute("fechaSalida") String fechaSalida,
                                       @RequestParam(value = "numPersonas", required = true) int numPersonas,
                                       @RequestParam(value = "tipoDoc", required = true) String tipoDoc,
                                       @RequestParam(value = "numDoc", required = true) Long numDoc,
                                       @RequestParam(value = "planConsumo", required = true) int planConsumoId) {
        
        Usuarios usuario = usuariosRepository.darUsuarioPorNumDocumento(tipoDoc, numDoc);
        reservasRepository.insertarReserva(fechaInicio, fechaSalida, numPersonas, tipoDoc, numDoc,  usuario.getPk().getCorreo(), usuario.getPk().getNombre(), planConsumoId);
        return "redirect:/reservas";
    }
    
    @GetMapping("/reservas/{id}/delete")
    public String reservasEliminar(@PathVariable("id") int id) {
        reservasRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }
    
    @GetMapping("/reservas/{id}/edit")
    public String reservasEditar(@PathVariable("id") int id, Model model) {
        reservasRepository.eliminarReserva(id);
        model.addAttribute("reservas", new Reservas());
        model.addAttribute("usuarios", usuariosRepository.darUsuarios());
        model.addAttribute("planesConsumo", planConsumoRepository.darPlanesConsumo());
        return "reservasNuevo";
    }
    
    
}