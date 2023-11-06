package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Habitaciones;

public interface RFC3Repository extends JpaRepository<Habitaciones, Integer>{

    @Query(value = "WITH ReservasEnUltimoAnio AS ( "+
                    "SELECT  r.habitaciones_id,  GREATEST(rs.fecha_inicio, (SYSDATE - INTERVAL '1' YEAR)) AS fecha_entrada, "+ 
                    "LEAST(rs.fecha_salida, SYSDATE) AS fecha_salida "+
                    "FROM reservan r "+
                    "INNER JOIN reservas rs ON r.reservas_id = rs.id "+
                    "WHERE rs.fecha_inicio <= SYSDATE AND rs.fecha_salida >= (SYSDATE - INTERVAL '1' YEAR) ) "+
                    "SELECT h.id AS habitacion_id, "+
                    "ROUND(COALESCE(SUM(TO_NUMBER(fecha_salida - fecha_entrada) + 1), 0)) AS dias_ocupados_en_ultimo_anio, "+
                    "ROUND(COALESCE((SUM(TO_NUMBER(fecha_salida - fecha_entrada) + 1) / 365) * 100, 0)) AS "+
                    "FROM habitaciones h "+
                    "LEFT JOIN ReservasEnUltimoAnio ro ON h.id = ro.habitaciones_id "+
                    "GROUP BY h.id" , nativeQuery = true)
                    Collection<Object[]> rfc3();

}