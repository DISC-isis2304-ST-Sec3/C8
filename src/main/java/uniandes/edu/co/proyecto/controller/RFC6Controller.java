package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC6Repository;

@Controller
public class RFC6Controller {

    @Autowired
    private RFC6Repository rfc6Repository;

    @GetMapping("/rfc6")
    public String rfc6(Model model) {
        Collection<Object[]> fechasA = rfc6Repository.rfc6A();
        Collection<Object[]> fechasB = rfc6Repository.rfc6B();
        Collection<Object[]> fechasC = rfc6Repository.rfc6C();
        model.addAttribute("fechasA", fechasA);
        model.addAttribute("fechasB", fechasB);
        model.addAttribute("fechasC", fechasC);
        return "rfc6";
    }

    
}
