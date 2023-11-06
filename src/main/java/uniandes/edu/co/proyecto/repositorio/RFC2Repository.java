package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC2Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT s.tipo AS servicio, COUNT(c.tiposservicio_tipo) AS cantidad_consumos "+
            "FROM consumos c "+
            "INNER JOIN tiposservicio s ON c.tiposservicio_tipo = s.tipo "+
            "WHERE c.fecha_consumo BETWEEN :fechaInicio AND :fechaFin "  +
            "GROUP BY s.tipo "+
            "ORDER BY cantidad_consumos DESC FETCH FIRST 20 ROWS ONLY" , nativeQuery = true)
                    Collection<Object[]> rfc2(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

}
