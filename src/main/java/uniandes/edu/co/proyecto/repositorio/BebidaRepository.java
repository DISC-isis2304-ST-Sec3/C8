package uniandes.edu.co.proyecto.repositorio;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.Bebida;

public interface BebidaRepository extends MongoRepository<Bebida, String> {
    
    List<Bebida> findByNombre(String nombre);
}
