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
        Collection<Object[]> clientes = rfc7Repository.rfc7();
        model.addAttribute("clientes", clientes);
        return "rfc7";
    }

    
}
