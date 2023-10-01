package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TiposUsuario;
import uniandes.edu.co.proyecto.modelo.Usuarios;
import uniandes.edu.co.proyecto.modelo.UsuariosPK;
import uniandes.edu.co.proyecto.repositorio.TiposUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.UsuariosRepository;

@Controller
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private TiposUsuarioRepository tiposUsuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuariosRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
        public String usuariosForm(Model model) {
        model.addAttribute("usuarios", new Usuarios());
        model.addAttribute("tiposUsuario", tiposUsuarioRepository.darTiposUsuario());
        return "usuariosNuevo";
    }

    
    @PostMapping("/usuarios/new/save")
    public String usuariosGuardar(@ModelAttribute("tipo_documento") String tipo,
    @ModelAttribute("num_documento") Long num, @ModelAttribute("nombre") String nombre,
    @ModelAttribute("correo") String correo, @ModelAttribute("tipoUsuario") String tipoUsuario) {
        TiposUsuario tiposUsuario = tiposUsuarioRepository.darTipoUsuario(tipoUsuario);
        UsuariosPK pk = new UsuariosPK(tipo, num, nombre, correo);
        Usuarios usuario = new Usuarios();
        usuario.setPk(pk);
        usuario.setTiposUsuario_tipo(tiposUsuario);
        usuariosRepository.insertarUsuario(pk.getTipo_documento(), pk.getNum_documento(), pk.getNombre(), pk.getCorreo(), tiposUsuario.getTipo());
        return "redirect:/usuarios";
    }
    
    @GetMapping("/usuarios/{tipo_documento}/{num_documento}/edit")
    public String usuariosEditarForm(@PathVariable("tipo_documento") String tipoDocumento, @PathVariable("num_documento") Long numDocumento, Model model) {
        usuariosRepository.eliminarUsuario(tipoDocumento, numDocumento);
         model.addAttribute("usuarios", new Usuarios());
        model.addAttribute("tiposUsuario", tiposUsuarioRepository.darTiposUsuario());
        return "usuariosNuevo";
        
    }
  
    @GetMapping("/usuarios/{tipo_documento}/{num_documento}/delete")
    public String usuariosEliminar(@PathVariable("tipo_documento") String tipoDocumento, @PathVariable("num_documento") Long numDocumento) {
        usuariosRepository.eliminarUsuario(tipoDocumento, numDocumento);
        return "redirect:/usuarios";
    }
    
    
}
