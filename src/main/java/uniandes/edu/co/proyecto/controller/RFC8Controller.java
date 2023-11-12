package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC8Repository;

@Controller
public class RFC8Controller {

    @Autowired
    private RFC8Repository rfc8Repository;

    @GetMapping("/rfc8")
    public String rfc8(Model model) {
        long inicio = System.nanoTime();
        Collection<Object[]> semanas = rfc8Repository.rfc8();
        long fin = System.nanoTime();
        double tiempo = (fin - inicio)/1000000000.0;
        model.addAttribute("Tiempo", tiempo);
        model.addAttribute("semanas", semanas); 
        return "rfc8";
    }
}
