package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Consumos;
import uniandes.edu.co.proyecto.repositorio.ConsumosRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionesRepository;

@Controller
public class ConsumosController {
    
    @Autowired
    private ConsumosRepository consumosRepository;
    
    @Autowired
    private HabitacionesRepository habitacionesRepository;

    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumosRepository.darConsumos());
        return "consumos";
    }

    @GetMapping("/consumos/bar/new")
    public String consumosFormBar(Model model) {
        model.addAttribute("consumos", new Consumos());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        model.addAttribute("tipoServ", "bar");
        model.addAttribute("productos", consumosRepository.darproductoBar());
        return "consumosNuevo";
    }

    @GetMapping("/consumos/supermercado/new")
    public String consumosFormSuper(Model model) {
        model.addAttribute("consumos", new Consumos());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        model.addAttribute("tipoServ", "supermercado");
        model.addAttribute("productos", consumosRepository.darproductoSuper());
        return "consumosNuevo";
    }

    @GetMapping("/consumos/restaurante/new")
    public String consumosFormRest(Model model) {
        model.addAttribute("consumos", new Consumos());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        model.addAttribute("tipoServ", "restaurante");
        model.addAttribute("productos", consumosRepository.darproductoRestaurante());
        return "consumosNuevo";
    }

    @GetMapping("/consumos/tienda/new")
    public String consumosFormTienda(Model model) {
        model.addAttribute("consumos", new Consumos());
        model.addAttribute("habitaciones", habitacionesRepository.darHabitaciones());
        model.addAttribute("tipoServ", "tienda");
        model.addAttribute("productos", consumosRepository.darproductoTienda());
        return "consumosNuevo";
    }
    
    @PostMapping("/consumos/bar/new/save") 
    public String consumosbarGuardar(@RequestParam(value = "idHab") int idHab,
    @ModelAttribute("tipoServ") String tipoServ, @RequestParam( value = "descripcion") String descripcion, @RequestParam(value = "nombreProd") String nombreProd ){ 
        Double costo = consumosRepository.darPrecioBar(nombreProd);
        consumosRepository.insertarConsumo(idHab, tipoServ, descripcion, costo);
        return "redirect:/consumos";
    }
    
    @PostMapping("/consumos/restaurante/new/save") 
    public String consumosresGuardar(@RequestParam(value = "idHab") int idHab,
    @ModelAttribute("tipoServ") String tipoServ, @RequestParam( value = "descripcion") String descripcion, @RequestParam(value = "nombreProd") String nombreProd ){ 
        Double costo = consumosRepository.darPrecioRestaurante(nombreProd);
        consumosRepository.insertarConsumo(idHab, tipoServ, descripcion, costo);
        return "redirect:/consumos";
    }
    
    @PostMapping("/consumos/tienda/new/save") 
    public String consumostiendaGuardar(@RequestParam(value = "idHab") int idHab,
    @ModelAttribute("tipoServ") String tipoServ, @RequestParam( value = "descripcion") String descripcion, @RequestParam(value = "nombreProd") String nombreProd ){ 
        Double costo = consumosRepository.darPrecioTienda(nombreProd);
        consumosRepository.insertarConsumo(idHab, tipoServ, descripcion, costo);
        return "redirect:/consumos";
    }
    
    @PostMapping("/consumos/supermercado/new/save") 
    public String consumossuperGuardar(@RequestParam(value = "idHab") int idHab,
    @ModelAttribute("tipoServ") String tipoServ, @RequestParam( value = "descripcion") String descripcion, @RequestParam(value = "nombreProd") String nombreProd ){ 
        Double costo = consumosRepository.darPrecioSuper(nombreProd);
        consumosRepository.insertarConsumo(idHab, tipoServ, descripcion, costo);
        return "redirect:/consumos";
    }
    
    
    @GetMapping("/consumos/{idHab}/delete")
    public String consumosEliminar(@PathVariable("idHab") int idHab) {
        consumosRepository.eliminarConsumo(idHab);
        return "redirect:/consumos";
    }
    
    
}