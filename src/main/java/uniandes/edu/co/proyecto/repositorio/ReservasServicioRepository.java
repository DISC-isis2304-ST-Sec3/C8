package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.ReservasServicio;
import uniandes.edu.co.proyecto.modelo.ServiciosSpa;

public interface ReservasServicioRepository extends JpaRepository<ReservasServicio, Integer>{
    
    @Query(value = "SELECT * FROM reservasServicio", nativeQuery = true )
    Collection<ReservasServicio> darReservasServicio();
    
    @Query(value = "SELECT id FROM ServiciosSpa", nativeQuery = true )
    Collection<Integer> darServiciosSpa();
    
    @Query(value = "SELECT duracion_min/60 FROM ServiciosSpa WHERE id = :id ", nativeQuery = true )
    double duracionServicioSpa(@Param("id") int idServicio);

    @Query(value = "SELECT * FROM reservasServicio WHERE id = :id;", nativeQuery = true )
    ReservasServicio darReservaServicio(@Param("id") int id);

    @Query(value = "SELECT Spas_id FROM Ofrece WHERE ServiciosSpa_id = :id FETCH FIRST 1 ROW ONLY ", nativeQuery = true )
    int daridSpaServicio(@Param("id") int idServicio);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ReservasSpa (ReservasServicio_id, Spas_id) VALUES ( :idServ , :idSpa )", nativeQuery = true)
    void insertarReservaSpa(@Param("idServ") int idServ, @Param("idSpa") int idSpa);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasServicio (duracion_hora, dia, hora, habitaciones_id) VALUES (:duracion_hora, TO_DATE( :dia ,'YYYY-MM-DD'), :hora, :habitaciones_id)", nativeQuery = true)
    void insertarReservaServicio(@Param("duracion_hora") int duracion_hora, @Param("dia") String dia, @Param("hora") String hora, @Param("habitaciones_id") int habitaciones_id);

    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM ReservasServicio WHERE id = :id ", nativeQuery = true )
    void eliminarReservaServicio(@Param("id") int id);
}
