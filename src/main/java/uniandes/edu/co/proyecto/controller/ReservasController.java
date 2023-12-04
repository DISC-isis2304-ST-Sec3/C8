
package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

@Controller
public class ReservasController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/reservas")
    public String getReservas(Model model){

        model.addAttribute("reservas", reservaRepository.findAll());
        return "reservas";

    }
    

    @GetMapping("/crearReserva")
    public String mostrarFormulario(Model model) {
        // Creamos una instancia vacía para el nuevo BebidaTipos
        model.addAttribute("nuevaReserva", new Reserva());
        model.addAttribute("habitacionesDisponibles", habitacionRepository.findAll());
        model.addAttribute("clientesDisponibles", clienteRepository.findAll());
        return "reservaForm";
    }

    @PostMapping("/crearReservaNueva")
    public String crearReserva(@ModelAttribute("nuevaReserva") Reserva reserva) {

        Cliente cliente = new Cliente(
            reserva.getCliente().getTipoDocumento(), reserva.getCliente().getNumDocumento(),reserva.getCliente().getNombre(), reserva.getCliente().getCorreo()
        );

        clienteRepository.save(cliente);

        // Agregamos la bebida a la lista de bebidas en el nuevo tipo de bebida
        reserva.setCliente(cliente);


        // Guardamos el nuevo tipo de bebida
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    @PostMapping("/deleteReserva")
    public String eliminarTipoHabitacion(@RequestParam(name = "id", required = false) String id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas";
    }
    
    
}
