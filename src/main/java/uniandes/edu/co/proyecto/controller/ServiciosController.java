
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

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.TipoServicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.TipoServicioRepository;




@Controller
public class ServiciosController {

    @Autowired
    private ServicioRepository servicioRepository;


    @GetMapping("/crearServicio")
    public String crearServicio(Model model) {
        model.addAttribute("servicioNuevo", new Servicio());
        return "servicioForm";
    }

    @PostMapping("/crearServicioNuevo")
    public String crearServicioNuevo(@ModelAttribute("servicioNuevo") Servicio servicio) {
        Servicio nuevo = new Servicio(
            servicio.getNombre(), servicio.getPrecio()
        );
        servicioRepository.save(nuevo);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios")
    public String obtenerTodosLosServicios(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicios";
    } 

}


