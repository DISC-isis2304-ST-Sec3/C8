package uniandes.edu.co.proyecto.repositorio;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    @Query("{'_id': ?0}")
    Cliente findByObjectId(ObjectId oId);


    @Query("{nombre: ?0}")
    List<Cliente> findByNombre(String nombre);

    @Query("{documento: ?0}")
    Cliente findByDocumento(int documento);

    @Query("{}")
    List<Cliente> findAll();

    @Query(value = "{'numDocumento': ?0}", delete = true)
    void deleteByNumDocumento(int numDocumento);

    @Query("{'correo': ?0 }")
    Cliente updateCliente(String correo);
}