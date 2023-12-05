package uniandes.edu.co.proyecto.controller;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class RFC3Controller {

    private final MongoTemplate mongoTemplate;

    public RFC3Controller(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/rfc3Form")
        public String showForm() {
    return "rfc3Form";
}

    @GetMapping("/rfc3")
    public List<RFC3Controller> getReservasWithConsumos(@RequestParam int numDocumento, 
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, 
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("cliente.numDocumento").is(numDocumento)
                        .andOperator(Criteria.where("fechaEntrada").gte(startDate).lte(endDate))),
                Aggregation.lookup("consumos", "habitacion", "habitacion", "consumos"),
                Aggregation.unwind("consumos"),
                Aggregation.match(Criteria.where("consumos.fechaConsumo").gte(startDate).lte(endDate)),
                Aggregation.project("cliente.numDocumento", "consumos.fechaConsumo", "consumos.tipoServicio", "consumos.servicio")
                        .andExclude("_id")
        );

        AggregationResults<RFC3Controller> results = mongoTemplate.aggregate(aggregation, "reservas", RFC3Controller.class);
        return results.getMappedResults();
    }
}