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
        long inicio = System.nanoTime();
        Collection<Object[]> fechasA = rfc6Repository.rfc6A();
        Collection<Object[]> fechasB = rfc6Repository.rfc6B();
        Collection<Object[]> fechasC = rfc6Repository.rfc6C();
        long fin = System.nanoTime();
        double tiempo = (fin - inicio)/1000000000.0;
        model.addAttribute("Tiempo", tiempo);
        model.addAttribute("fechasA", fechasA);
        model.addAttribute("fechasB", fechasB);
        model.addAttribute("fechasC", fechasC);
        return "rfc6";
    }

    
}
