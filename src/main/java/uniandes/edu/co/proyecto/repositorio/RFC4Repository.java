package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC4Repository extends JpaRepository<Consumos, Integer>{
    @Query( value= "SELECT * FROM servicios " +
                 "WHERE (:precioMin IS NULL OR precio >= :precioMin) " +
                 "AND (:precioMax IS NULL OR precio <= :precioMax) " +
                 "AND (:fechaInicio IS NULL OR fecha_consumo >= :fechaInicio) " +
                 "AND (:fechaFin IS NULL OR fecha_consumo <= :fechaFin) " +
                 "AND (:tipo IS NULL OR tipo = :tipo)", nativeQuery = true)
    Collection  <Object[]> rfc4(@Param("precioMin") Integer precioMin, @Param("precioMax") Integer precioMax, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("tipo") String tipo);


    
}
