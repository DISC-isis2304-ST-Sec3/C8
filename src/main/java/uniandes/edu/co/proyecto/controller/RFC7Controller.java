package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC7Repository;

@Controller
public class RFC7Controller {

    @Autowired
    private RFC7Repository rfc7Repository;

    @GetMapping("/rfc7")
    public String rfc7(Model model) {
        long inicio = System.nanoTime();
        Collection<Object[]> clientes = rfc7Repository.rfc7();
        long fin = System.nanoTime();
        double tiempo = (fin - inicio)/1000000000.0;
        model.addAttribute("Tiempo", tiempo);
        model.addAttribute("clientes", clientes);
        return "rfc7";
    }

    
}
