package uniandes.edu.co.proyecto.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.CheckOut;

public interface CheckOutRepository extends MongoRepository<CheckOut, String> {

    @Query("{}")
    List<CheckOut> findAll();

}