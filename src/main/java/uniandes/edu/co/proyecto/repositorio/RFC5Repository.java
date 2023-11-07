package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC5Repository extends JpaRepository<Consumos, Integer>{
        @Query(value = "SELECT num_documento FROM usuarios ", nativeQuery = true )
        Collection<String> darNumerosDocumento();


        @Query(value = "SELECT u.num_documento AS numero_documento, u.nombre, SUM(c.costo) AS suma_consumos "+
                "FROM reservas r "+
                "INNER JOIN habitaciones h ON r.id = h.id "+
                "INNER JOIN consumos c ON h.id = c.habitaciones_id "+
                "INNER JOIN usuarios u ON r.usuarios_num_documento = u.num_documento AND r.usuarios_tipo_documento = u.tipo_documento "+
                "WHERE u.num_documento = :num_documento "+
                "AND c.fecha_consumo BETWEEN :fechaInicio AND :fechaFin "+
                "GROUP BY u.num_documento, u.nombre" , nativeQuery = true)
                    Collection<Object[]> rfc5(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("num_documento") int num_documento);


}