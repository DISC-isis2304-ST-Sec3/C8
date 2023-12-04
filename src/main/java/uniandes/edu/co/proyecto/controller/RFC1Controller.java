
package uniandes.edu.co.proyecto.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.CheckIn;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.ConsumoResult;
import uniandes.edu.co.proyecto.repositorio.CheckInRepository;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;


@Controller
public class RFC1Controller {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/rfc1")
    public String getConsumos(Model model){
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    Date date = null;
    try {
        date = formatter.parse("2022-04-12T02:16:18Z");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    Aggregation aggregation = Aggregation.newAggregation(
        Aggregation.match(Criteria.where("fechaConsumo").gte(date)),
        Aggregation.unwind("servicio"),
        Aggregation.group("habitacion").sum("servicio.precio").as("totalDinero"),
        Aggregation.project("totalDinero").andExclude("_id").andInclude("habitacion")
    );
    AggregationResults<ConsumoResult> results = mongoTemplate.aggregate(aggregation, "consumos", ConsumoResult.class);
    model.addAttribute("rfc1", results.getMappedResults());
    return "rfc1";
}

    
}
