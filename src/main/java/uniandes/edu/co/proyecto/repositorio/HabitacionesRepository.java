package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Habitaciones;

public interface HabitacionesRepository extends JpaRepository<Habitaciones, Integer> {
    
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true )
    Collection<Habitaciones> darHabitaciones();
    
    @Query(value = "SELECT * FROM habitaciones WHERE id = :id ", nativeQuery = true )
    Habitaciones darHabitacion(@Param("id") int id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (id, capacidad, costo, tiposHabitacion_tipo) VALUES ( :id , :capacidad , :costo , :tiposHabitacion )", nativeQuery = true )
    void insertarHabitacion(@Param("id") int id, @Param("capacidad") int capacidad, @Param("costo") double costo, @Param("tiposHabitacion") String tiposHabitacion);
    
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (capacidad, costo, tiposHabitacion_tipo) VALUES ( :capacidad , :costo , :tiposHabitacion )", nativeQuery = true )
    void insertarHabitacion2(@Param("capacidad") int capacidad, @Param("costo") double costo, @Param("tiposHabitacion") String tiposHabitacion);
    
    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM Habitaciones WHERE id = :id ", nativeQuery = true )
    void eliminarHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Habitaciones SET capacidad = :capacidad , costo = :costo , tiposHabitacion_tipo = :tiposHabitacion_tipo WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") int id, @Param("capacidad") int capacidad, @Param("costo") double costo, @Param("tiposHabitacion_tipo") String tiposHabitacion_tipo);
    
    
}