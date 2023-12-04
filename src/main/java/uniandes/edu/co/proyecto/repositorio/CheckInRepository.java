package uniandes.edu.co.proyecto.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.CheckIn;

public interface CheckInRepository extends MongoRepository<CheckIn, String> {

    @Query("{}")
    List<CheckIn> findAll();

}