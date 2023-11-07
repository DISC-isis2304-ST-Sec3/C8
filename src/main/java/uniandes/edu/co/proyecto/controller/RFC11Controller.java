package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC11Repository;

@Controller
public class RFC11Controller {

    @Autowired
    private RFC11Repository rfc11Repository;

    @GetMapping("/rfc11")
    public String rfc11(Model model) {
        Collection<Object[]> caract = rfc11Repository.rfc11();
        model.addAttribute("caract", caract);
        return "rfc11";
    }

    
}