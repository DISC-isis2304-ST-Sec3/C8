package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC1Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT h.id AS habitacion_id, COALESCE(SUM(c.costo), 0) AS dinero_recolectado "+
                    "FROM habitaciones h "+
                    "LEFT JOIN consumos c ON h.id = c.habitaciones_id "+
                    "WHERE c.fecha_consumo >= ADD_MONTHS(CURRENT_DATE, -12) "+
                    "GROUP BY h.id" , nativeQuery = true)
                    Collection<Object[]> rfc1();

}