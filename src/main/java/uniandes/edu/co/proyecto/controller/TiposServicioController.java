
package uniandes.edu.co.proyecto.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.ServicioEmbedded;
import uniandes.edu.co.proyecto.modelo.TipoServicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.TipoServicioRepository;

@Controller
public class TiposServicioController {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/tiposServicio")
    public String getTiposServicio(Model model){

        model.addAttribute("tiposServicio", tipoServicioRepository.findAll());
        return "tiposServicio";

    }

    
    

    @GetMapping("/tipoServicioForm")
    public String mostrarFormulario(Model model) {
        // Creamos una instancia vacía para el nuevo BebidaTipos
        model.addAttribute("nuevoTipoServicio", new TipoServicio());
        return "tipoServicioForm";
    }

    @PostMapping("/crearTipoServicio")
    public String crearTipoServicio( @ModelAttribute("tipo") String tipo, @RequestParam(name = "descripcion", required = false) String descripcion) {
        TipoServicio tipoServicio = new TipoServicio(tipo, descripcion);
        return "redirect:/tiposServicio";
    }

    @PostMapping("/deleteTipoServicio")
    public String eliminarTipoServicio(@RequestParam(name = "tipo", required = false) String tipo){
        
        for (TipoServicio ser: tipoServicioRepository.findByTipo(tipo))
        {
            tipoServicioRepository.delete(ser);
        }
        return "redirect:/tiposServicio";
        
    }

}
