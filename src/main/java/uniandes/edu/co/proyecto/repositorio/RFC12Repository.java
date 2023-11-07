package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC12Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "SELECT usuarios_nombre AS nombre_cliente, usuarios_num_documento AS num_documento_cliente,  usuarios_correo AS num_documento_cliente "+
                    "FROM reservas "+
                    "WHERE fecha_inicio BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-03-31', 'YYYY-MM-DD') "+
                    "AND usuarios_num_documento IN ( "+
                    "SELECT usuarios_num_documento "+
                    "FROM reservas "+
                    "WHERE fecha_inicio BETWEEN TO_DATE('2023-05-01', 'YYYY-MM-DD') AND TO_DATE('2023-08-30', 'YYYY-MM-DD') "+
                    ") AND usuarios_num_documento IN ( "+
                    "SELECT usuarios_num_documento "+
                    "FROM reservas "+
                    "WHERE fecha_inicio BETWEEN TO_DATE('2023-09-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-30', 'YYYY-MM-DD'))" , nativeQuery = true) 
                    Collection<Object[]> rfc12A();

    @Query(value = "SELECT r.usuarios_nombre AS nombre_cliente, r.usuarios_num_documento AS num_documento_cliente, r.usuarios_correo AS correo "+
                    "FROM reservas r "+
                    "WHERE r.usuarios_num_documento IN ( "+
                    "SELECT r2.usuarios_num_documento "+
                    "FROM reservas r2 "+
                    "WHERE EXISTS ( "+
                    "SELECT 1 "+
                    "FROM consumos c "+
                    "WHERE c.fecha_consumo BETWEEN r2.fecha_inicio AND r2.fecha_salida AND c.costo >= 300000)) "+
                    "GROUP BY r.usuarios_num_documento, r.usuarios_nombre, r.usuarios_correo" , nativeQuery = true)
                    Collection<Object[]> rfc12B();

    @Query(value = "SELECT r.usuarios_nombre AS nombre, r.usuarios_num_documento AS num_doc, r.usuarios_correo AS correo "+
                    "FROM "+
                    "RESERVAS r "+
                    "WHERE r.usuarios_num_documento NOT IN ( "+
                    "SELECT DISTINCT re.usuarios_num_documento "+
                    "FROM RESERVASSERVICIO rs "+
                    "INNER JOIN RESERVAN ON rs.habitaciones_id = reservan.habitaciones_id "+
                    "INNER JOIN RESERVAS re ON rs.dia BETWEEN re.fecha_inicio AND re.fecha_salida "+
                    "WHERE rs.duracion_hora < 4) "+
                    "GROUP BY r.usuarios_nombre, r.usuarios_num_documento, r.usuarios_correo" , nativeQuery = true)
                    Collection<Object[]> rfc12C();
    

}
