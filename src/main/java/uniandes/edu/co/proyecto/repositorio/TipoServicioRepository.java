package uniandes.edu.co.proyecto.repositorio;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.TipoServicio;

public interface TipoServicioRepository extends MongoRepository<TipoServicio, String> {

    @Query("{ 'tipo' : ?0 }")
    List<TipoServicio> findByTipo(String tipo);

    @Query("{}")
    List<TipoServicio> findAll();

}