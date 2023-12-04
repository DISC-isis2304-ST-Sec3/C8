package uniandes.edu.co.proyecto.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, String> {
    TipoHabitacion save(TipoHabitacion tipoHabitacion);
    
    @Query("{}")
    List<TipoHabitacion> findAll();

    @Query("{'tipo': ?0 }")
    TipoHabitacion findByTipo(String tipo);

}