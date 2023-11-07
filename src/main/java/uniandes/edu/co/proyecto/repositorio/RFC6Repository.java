package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC6Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH FechasReservas AS ( "+
                    "SELECT DISTINCT fecha AS fecha_reserva "+
                    "FROM ( "+
                    "SELECT fecha_inicio AS fecha FROM reservas "+
                    "UNION ALL "+
                    "SELECT fecha_salida AS fecha FROM reservas)) "+
                    "SELECT fr.fecha_reserva, COUNT(r.id) AS reservas_activas "+
                    "FROM FechasReservas fr "+
                    "JOIN reservas r ON fr.fecha_reserva BETWEEN r.fecha_inicio AND r.fecha_salida "+
                    "GROUP BY fr.fecha_reserva "+
                    "ORDER BY reservas_activas DESC "+
                    "FETCH FIRST 10 ROWS ONLY" , nativeQuery = true)
                    Collection<Object[]> rfc6A();

    @Query(value = "WITH FechasConsumos AS ( "+
                    "SELECT DISTINCT fecha_consumo AS fecha "+
                    "FROM consumos) "+
                    "SELECT fc.fecha, SUM(c.costo) AS costo_consumos, COUNT(c.costo) AS consumos_realizados "+
                    "FROM FechasConsumos fc "+
                    "JOIN consumos c ON fc.fecha = c.fecha_consumo "+
                    "GROUP BY fc.fecha "+
                    "ORDER BY costo_consumos DESC "+
                    "FETCH FIRST 10 ROWS ONLY" , nativeQuery = true)
                    Collection<Object[]> rfc6B();
    
    @Query(value = "WITH FechasReservas AS ( "+
                    "SELECT DISTINCT fecha AS fecha_reserva "+
                    "FROM ( "+
                    "SELECT fecha_inicio AS fecha FROM reservas "+
                    "UNION ALL "+
                    "SELECT fecha_salida AS fecha FROM reservas)) "+
                    "SELECT fr.fecha_reserva, COUNT(r.id) AS reservas_activas "+
                    "FROM FechasReservas fr "+
                    "JOIN reservas r ON fr.fecha_reserva BETWEEN r.fecha_inicio AND r.fecha_salida "+
                    "GROUP BY fr.fecha_reserva "+
                    "ORDER BY reservas_activas ASC "+
                    "FETCH FIRST 10 ROWS ONLY" , nativeQuery = true) 
                    Collection<Object[]> rfc6C();

}
