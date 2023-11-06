package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import uniandes.edu.co.proyecto.repositorio.RFC3Repository;

@Controller
public class RFC3Controller {

    @Autowired
    private RFC3Repository rfc3Repository;

    @GetMapping("/rfc3")
    public String rfc3(Model model) {
        Collection<Object[]> habitaciones = rfc3Repository.rfc3();
        model.addAttribute("Habitaciones", habitaciones);
        return "rfc3";
    }


    
}