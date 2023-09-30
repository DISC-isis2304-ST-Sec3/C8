package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TiposUsuario;
import uniandes.edu.co.proyecto.repositorio.TiposUsuarioRepository;

@Controller
public class TiposUsuarioController {
    
    @Autowired
    private TiposUsuarioRepository tiposUsuarioRepository;

    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposUsuario", tiposUsuarioRepository.darTiposUsuario());
        return "tiposUsuario";
    }

    @GetMapping("/tiposUsuario/new")
    public String tiposUsuarioForm(Model model) {
        model.addAttribute("tiposUsuario", new TiposUsuario());
        return "tiposusuarioNuevo";
    }
    
    @PostMapping("/tiposUsuario/new/save") 
    public String tiposUsuarioGuardar(@ModelAttribute TiposUsuario tiposUsuario){
        tiposUsuarioRepository.insertarTipoUsuario(tiposUsuario.getTipo());
        return "redirect:/tiposUsuario";
    }
    
    @GetMapping("/tiposUsuario/{tipo}/delete")
    public String tiposUsuarioEliminar(@PathVariable("tipo") String tipo) {
        tiposUsuarioRepository.eliminarTipoUsuario(tipo);
        return "redirect:/tiposUsuario";
    }
    
    
}
