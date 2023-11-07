package uniandes.edu.co.proyecto.controller;


import java.sql.Date;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.RFC5Repository;

@Controller
public class RFC5Controller {

    @Autowired
    private RFC5Repository rfc5Repository;

    @GetMapping("/rfc5")
    public String rfc5(Model model) {
        Collection<String> numerosDocumento = rfc5Repository.darNumerosDocumento();
        model.addAttribute("numerosDocumento", numerosDocumento);
        return "formRFC5";
    }

    @GetMapping("/rfc5/form")
    public String rfc5Form(Model model, @RequestParam(value = "fechaInicio", required = true) Date fechaInicio,
                                    @RequestParam(value = "fechaFin", required = true) Date fechaFin,
                                    @RequestParam(value = "num_documento", required = true) int num_documento) {
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        Collection<String> numerosDocumento = rfc5Repository.darNumerosDocumento();
        model.addAttribute("numerosDocumento", numerosDocumento);
        Collection<Object[]> consumos = rfc5Repository.rfc5(fechaInicio, fechaFin, num_documento);
        model.addAttribute("Consumos", consumos);
        return "rfc5";
    }


    
}
