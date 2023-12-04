package uniandes.edu.co.proyecto.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends MongoRepository<Consumo, String> {

    @Query("{}")
    List<Consumo> findAll();

}