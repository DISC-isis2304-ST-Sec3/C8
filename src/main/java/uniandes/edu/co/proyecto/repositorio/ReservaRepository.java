package uniandes.edu.co.proyecto.repositorio;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    @Query("{'cliente.numDocumento': ?0}")
    List<Reserva> findByNumDocumento(int numDocumento);

    @Query("{fechaEntrada: ?0}")
    List<Reserva> findByFechaEntrada(Date fechaEntrada);

    @Query("{fechaSalida: ?0}")
    List<Reserva> findByFechaSalida(Date fechaSalida);

    @Query("{}")
    List<Reserva> findAll();

}