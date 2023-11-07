package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC11Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH Semanas AS ( "+
                    "SELECT "+
                    "TO_CHAR(fecha_inicio, 'IYYY-IW') AS semana, "+
                    "reservan.reservas_id AS reserva_id, "+
                    "consumos.tiposservicio_tipo AS tipoServicio, "+
                    "reservan.habitaciones_id AS habitacion_id "+
                    "FROM reservas "+
                    "JOIN reservan ON reservan.reservas_id = reservas.id "+
                    "JOIN consumos ON reservan.habitaciones_id = consumos.habitaciones_id), "+
                    "ServiciosConsumidos AS ( "+
                    "SELECT "+
                    "semana, "+
                    "tipoServicio, "+
                    "COUNT(*) AS total_consumos "+
                    "FROM Semanas "+
                    "GROUP BY semana, tipoServicio), "+
                    "HabitacionesSolicitadas AS ( "+
                    "SELECT "+
                    "semana, "+
                    "habitacion_id, "+
                    "COUNT(*) AS total_solicitudes "+
                    "FROM Semanas "+
                    "GROUP BY semana, habitacion_id), "+
                    "MaxMinServicios AS ( "+
                    "SELECT "+
                    "semana, "+
                    "MAX(total_consumos) AS max_consumos, "+
                    "MIN(total_consumos) AS min_consumos "+
                    "FROM ServiciosConsumidos "+
                    "GROUP BY semana "+
                    "), MaxMinHabitaciones AS ( "+
                    "SELECT "+
                    "semana, "+
                    "MAX(total_solicitudes) AS max_solicitudes, "+
                    "MIN(total_solicitudes) AS min_consumos "+
                    "FROM HabitacionesSolicitadas "+
                    "GROUP BY semana) "+
                    "SELECT "+
                    "s.semana, "+
                    "MAX(CASE WHEN sc.total_consumos = mms.max_consumos THEN tipoServicio END) AS servicio_mas_consumido, "+
                    "MIN(CASE WHEN sc.total_consumos = mms.min_consumos THEN tipoServicio END) AS servicio_menos_consumido, "+
                    "MAX(CASE WHEN hs.total_solicitudes = mmh.max_solicitudes THEN habitacion_id END) AS habitacion_mas_solicitada, "+
                    "MIN(CASE WHEN hs.total_solicitudes = mmh.min_consumos THEN habitacion_id END) AS habitacion_menos_solicitada "+
                    "FROM (SELECT DISTINCT semana FROM Semanas) s "+
                    "JOIN MaxMinServicios mms ON s.semana = mms.semana "+
                    "JOIN MaxMinHabitaciones mmh ON s.semana = mmh.semana "+
                    "LEFT JOIN ServiciosConsumidos sc ON s.semana = sc.semana  "+
                    "LEFT JOIN HabitacionesSolicitadas hs ON s.semana = hs.semana "+
                    "GROUP BY s.semana "+
                    "ORDER BY s.semana" , nativeQuery = true) 
                    Collection<Object[]> rfc11();
}