package uniandes.edu.co.proyecto.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {
    Habitacion save(Habitacion habitacion);

    @Query("{numero: ?0}")
    List<Habitacion> findByNumero(int numero);

    @Query("{}")
    List<Habitacion> findAll();

    // DELETE
    @Query(value = "{'numero': ?0 }", delete = true)
    void deleteByNumero(int numero);

    // UPDATE
    @Query("{'tipo': ?0 }")
    Habitacion updateHabitacion(String tipo);
}