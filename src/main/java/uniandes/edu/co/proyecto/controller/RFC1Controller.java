package uniandes.edu.co.proyecto.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.RFC1Repository;

@Controller
public class RFC1Controller {

    @Autowired
    private RFC1Repository rfc1Repository;

    @GetMapping("/rfc1")
    public String rfc1(Model model) {
        long inicio = System.nanoTime();
        Collection<Object[]> consumos = rfc1Repository.rfc1();
        long fin = System.nanoTime();
        double tiempo = (fin - inicio)/1000000000.0;
        model.addAttribute("Costos", consumos);
        model.addAttribute("Tiempo", tiempo);
        return "rfc1";
    }

    /*long fin = System.nanoTime();
        double tiempo = (fin - inicio)/1000000000.0;
        model.addAttribute("Tiempo", tiempo);*/
}
