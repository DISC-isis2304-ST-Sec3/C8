package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.BebidaTipos;

public interface BebidaTiposRepository extends MongoRepository<BebidaTipos, String>{

    List<BebidaTipos> findByNombre(String nombre);
    
}
