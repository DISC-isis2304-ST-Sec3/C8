
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

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;



@Controller
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/crearCliente")
    public String crearCliente(Model model) {
        model.addAttribute("clienteNuevo", new Cliente());
        return "clienteForm";
    }

    @PostMapping("/crearClienteNuevo")
    public String crearClienteNuevo(@ModelAttribute("clienteNuevo") Cliente cliente) {
        Cliente nuevo = new Cliente(
            cliente.getTipoDocumento(), cliente.getNumDocumento(), cliente.getNombre(), cliente.getCorreo()
        );
        clienteRepository.save(nuevo);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes")
    public String obtenerTodosLosClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes";
    } 

    @PostMapping("/deleteCliente")
    public String eliminarCliente(@RequestParam(name = "id", required = false) String id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }

}