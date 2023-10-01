package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.ReservasServicio;

public interface ReservasServicioRepository extends JpaRepository<ReservasServicio, Integer>{
    
    @Query(value = "SELECT * FROM reservasServicio", nativeQuery = true )
    Collection<ReservasServicio> darReservasServicio();

    @Query(value = "SELECT * FROM reservasServicio WHERE id = :id;", nativeQuery = true )
    ReservasServicio darReservaServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasServicio (duracion_hora, dia, hora, habitaciones_id) VALUES (:duracion_hora, :dia, :hora, :habitaciones_id)", nativeQuery = true)
    void insertarReservaServicio(@Param("duracion_hora") int duracion_hora, @Param("dia") Date dia, @Param("hora") String hora, @Param("habitaciones_id") int habitaciones_id);

    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM ReservasServicio WHERE id = :id ", nativeQuery = true )
    void eliminarReservaServicio(@Param("id") int id);
}
