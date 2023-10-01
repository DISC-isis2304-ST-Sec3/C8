package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.TiposHabitacion;
import uniandes.edu.co.proyecto.repositorio.TiposHabitacionRepository;

@Controller
public class TiposHabitacionController {
    
    @Autowired
    private TiposHabitacionRepository tiposHabitacionRepository;

    @GetMapping("/tiposHabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tiposHabitacionRepository.darTiposHabitacion());
        return "tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/new")
    public String tiposHabitacionForm(Model model) {
        model.addAttribute("tiposHabitacion", new TiposHabitacion());
        return "tiposhabitacionNuevo";
    }
    
    @PostMapping("/tiposHabitacion/new/save") 
    public String tiposHabitacionGuardar(@ModelAttribute("tipo") String tipo,
                                        @RequestParam(value = "jacuzzi", required = false) Integer jacuzzi,
                                        @RequestParam(value = "cocina", required = false) Integer cocina,
                                        @RequestParam(value = "comedor", required = false) Integer comedor) {

        jacuzzi = (jacuzzi != null) ? jacuzzi : 0;
        cocina = (cocina != null) ? cocina : 0;
        comedor = (comedor != null) ? comedor : 0;

        tiposHabitacionRepository.insertarTipoHabitacion(tipo, jacuzzi, comedor, cocina);
        return "redirect:/tiposHabitacion";
    }
    
    @GetMapping("/tiposHabitacion/{tipo}/delete")
    public String tiposHabitacionEliminar(@PathVariable("tipo") String tipo) {
        tiposHabitacionRepository.eliminarTipoHabitacion(tipo);
        return "redirect:/tiposHabitacion";
    }
    
    @GetMapping("/tiposHabitacion/{tipo}/edit")
    public String tiposHabitacionEditarForm(@PathVariable("tipo") String tipo, Model model) {
        tiposHabitacionRepository.eliminarTipoHabitacion(tipo);
        model.addAttribute("tiposHabitacion", new TiposHabitacion());
        return "tiposhabitacionNuevo";

    }
    
}
