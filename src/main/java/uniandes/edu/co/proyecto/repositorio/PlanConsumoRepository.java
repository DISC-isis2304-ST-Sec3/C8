package uniandes.edu.co.proyecto.repositorio;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends MongoRepository<PlanConsumo, String> {

    @Query("{}")
    List<PlanConsumo> findAll();
}