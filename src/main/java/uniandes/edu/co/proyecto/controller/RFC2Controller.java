package uniandes.edu.co.proyecto.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.ReservaResult;

import org.springframework.ui.Model;

import java.util.*;

@Controller
public class RFC2Controller {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/rfc2")
    public String getOcupacion(Model model){
        Date fechaActual = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(fechaActual);
        c.add(Calendar.YEAR, -1);
        Date fechaInicio = c.getTime();

        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("fechaEntrada").gte(fechaInicio).lte(fechaActual)),
            Aggregation.project("habitacion", "fechaEntrada", "fechaSalida")
                    .andExpression("(fechaSalida - fechaEntrada) / (1000 * 60 * 60 * 24)").as("diasOcupacion")
    ); 

    AggregationResults<ReservaResult> results = mongoTemplate.aggregate(aggregation, "reservas", ReservaResult.class);
    System.out.println(results.getMappedResults()); // Linea de impresion agregada
    Map<String, Double> ocupacionPorHabitacion = new HashMap<>();
    for (ReservaResult result : results) {
        String habitacion = result.getHabitacion();
        Double diasOcupacion = result.getDiasOcupacion();
        ocupacionPorHabitacion.merge(habitacion, diasOcupacion, Double::sum);
    }

    Map<String, Double> indiceOcupacionPorHabitacion = new HashMap<>();
for (Map.Entry<String, Double> entry : ocupacionPorHabitacion.entrySet()) {
    String habitacion = entry.getKey();
    double diasOcupacion = entry.getValue();
    double indiceOcupacion = (diasOcupacion / 365) * 100;
    indiceOcupacionPorHabitacion.put(habitacion, indiceOcupacion);
}

    model.addAttribute("rfc2", indiceOcupacionPorHabitacion);
    return "rfc2";
}
}