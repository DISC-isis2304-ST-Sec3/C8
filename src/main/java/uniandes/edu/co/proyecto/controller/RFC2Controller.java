package uniandes.edu.co.proyecto.controller;


import java.sql.Date;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.RFC2Repository;

@Controller
public class RFC2Controller {

    @Autowired
    private RFC2Repository rfc2Repository;

    @GetMapping("/rfc2")
    public String rfc2(Model model) {
        return "formRFC2";
    }

    @GetMapping("/rfc2/rango")
    public String rfc2Rango(Model model, @RequestParam(value = "fechaInicio", required = true) Date fechaInicio,
                                    @RequestParam(value = "fechaFin", required = true) Date fechaFin) {
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);

        Collection<Object[]> servicios = rfc2Repository.rfc2(fechaInicio, fechaFin);
        model.addAttribute("Servicios", servicios);
        return "rfc2";
    }


    
}
