package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.TipoBebida;

public interface TipoBebidaRepository extends MongoRepository<TipoBebida, String> {
   
}
