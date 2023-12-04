
package uniandes.edu.co.proyecto.controller;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.TipoServicio;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.TipoServicioRepository;




@Controller
public class ConsumosController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/consumoForm")
    public String crearConsumo(Model model) {
        model.addAttribute("habitacionesDisponibles", habitacionRepository.findAll());
        model.addAttribute("tiposServicioDisponibles", tipoServicioRepository.findAll());
        model.addAttribute("serviciosDisponibles", servicioRepository.findAll());
        model.addAttribute("consumoNuevo", new Consumo());
        return "consumoForm";
    }

    @PostMapping("/crearConsumo")
    public String crearConsumo(@ModelAttribute("consumoNuevo") Consumo consumo) {
    TipoServicio tipoServicio = new TipoServicio(consumo.getTipoServicio().getTipo(), consumo.getTipoServicio().getDescripcion());
    tipoServicioRepository.save(tipoServicio);
    Servicio servicio = new Servicio(consumo.getServicio().getNombre(), consumo.getServicio().getPrecio());
    servicioRepository.save(servicio);
    consumo.setTipoServicio(consumo.getTipoServicio());
    consumo.setServicio(consumo.getServicio());
    consumoRepository.save(consumo);
    return "redirect:/consumos";
}

    @GetMapping("/consumos")
    public String obtenerTodosLosConsumos(Model model) {
        model.addAttribute("consumos", consumoRepository.findAll());
        return "consumos";
    } 

    @PostMapping("/deleteConsumo")
    public String eliminarConsumo(@RequestParam(name = "id", required = false) String id) {
        consumoRepository.deleteById(id);
        return "redirect:/consumos";
    }

}