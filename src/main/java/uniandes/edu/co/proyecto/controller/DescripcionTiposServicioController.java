package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.TiposServicio;
import uniandes.edu.co.proyecto.repositorio.DescripcionServiciosRepository;

@Controller
public class DescripcionTiposServicioController {
    
    public static String TYPE;

    @Autowired
    private DescripcionServiciosRepository tiposServicioRepository;

    @GetMapping("/tiposServicio")
    public String tiposServicio(Model model) {
        model.addAttribute("tiposServicio", tiposServicioRepository.darTiposServicio());
        return "tiposServicio";
    }

    @GetMapping("/tiposServicio/{tipo}/new")
        public String tiposServicioForm(Model model, @PathVariable("tipo") String tipo) {
        model.addAttribute("tiposServicio", new TiposServicio());
        TYPE = tipo;
        return "tiposServicioNuevo";
    }
    
    
    @PostMapping("/tiposServicio/{tipo}/new/save")
    public String tiposServicioGuardar(@PathVariable("tipo") String tipo, @RequestParam(value ="descripcion") String descripcion) {
        String type = DescripcionTiposServicioController.TYPE;
        tiposServicioRepository.insertarTiposServicio(type, descripcion);
        return "redirect:/tiposServicio";
    }
    
    
    @GetMapping("/tiposServicio/{tipo}/edit")
    public String tiposServicioEditarForm(@PathVariable("tipo") String tipo, Model model) {
        model.addAttribute("tiposServicio", new TiposServicio());
        TYPE = tipo;
        return "tiposServicioNuevo";
    }
  
    @GetMapping("/tiposServicio/{tipo}/delete")
    public String tiposServicioEliminar(@PathVariable("tipo") String tipo) {
        tiposServicioRepository.eliminarTiposServicio(tipo);
        return "redirect:/tiposServicio";
    }
    
    
}