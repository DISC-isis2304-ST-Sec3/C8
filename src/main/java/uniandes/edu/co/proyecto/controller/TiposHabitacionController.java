
package uniandes.edu.co.proyecto.controller;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;



@Controller
public class TiposHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/crearTipoHabitacion")
    public String crearTipoHabitacion(Model model) {
        model.addAttribute("tipoHabitacionNuevo", new TipoHabitacion());
        return "tipoHabitacionForm";
    }

    @PostMapping("/crearTipoHabitacionNuevo")
    public String crearTipoHabitacionNuevo(@ModelAttribute("tipoHabitacionNuevo") TipoHabitacion tipoHabitacion) {
        TipoHabitacion nuevo = new TipoHabitacion(
            tipoHabitacion.getTipo(), tipoHabitacion.getJacuzzi(), tipoHabitacion.getComedor(), tipoHabitacion.getCocina()
        );
        tipoHabitacionRepository.save(nuevo);
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion")
    public String obtenerTodosLosTiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "tiposHabitacion";
    } 

    @PostMapping("/deleteTipoHabitacion")
    public String eliminarTipoHabitacion(@RequestParam(name = "id", required = false) String id) {
        tipoHabitacionRepository.deleteById(id);
        return "redirect:/tiposHabitacion";
    }

}