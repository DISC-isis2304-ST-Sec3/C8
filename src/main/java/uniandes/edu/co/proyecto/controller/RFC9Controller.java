package uniandes.edu.co.proyecto.controller;


import java.sql.Date;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.RFC9Repository;

@Controller
public class RFC9Controller {

    @Autowired
    private RFC9Repository rfc9Repository;

    @GetMapping("/rfc9")
    public String rfc9(Model model) {
        Collection<String> tiposServicio = rfc9Repository.darTipoServicio();
        model.addAttribute("tiposServicio", tiposServicio);
        return "formRFC9";
    }

    @GetMapping("/rfc9/form")
    public String rfc9Form(Model model, @RequestParam(value = "fechaInicio", required = true) Date fechaInicio,
                                    @RequestParam(value = "fechaFin", required = true) Date fechaFin,
                                    @RequestParam(value = "tipoServicio", required = true) String tipoServicio) {
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        Collection<String> tiposServicio = rfc9Repository.darTipoServicio();
        model.addAttribute("tiposServicio", tiposServicio);
        long inicio = System.nanoTime();
        Collection<Object[]> servicios = rfc9Repository.rfc9(fechaInicio, fechaFin, tipoServicio);
        long fin = System.nanoTime();
        double tiempo = (fin - inicio)/1000000000.0;
        model.addAttribute("Tiempo", tiempo);
        model.addAttribute("servicios", servicios);
        return "rfc9";
    }


    
}
