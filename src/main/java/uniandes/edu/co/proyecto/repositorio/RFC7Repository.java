package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC7Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH BuenClienteTiempo AS ( "+
                    "SELECT DISTINCT r.usuarios_num_documento AS num_documento_cliente "+
                    "FROM reservas r "+
                    "WHERE (r.fecha_salida - r.fecha_inicio) >= 14), BuenClienteConsumo AS ( "+
                    "SELECT r.usuarios_num_documento AS num_documento_cliente, SUM(c.costo) AS suma_consumos "+
                    "FROM reservas r "+
                    "JOIN consumos c ON r.id = c.habitaciones_id "+
                    "WHERE c.fecha_consumo >= (SELECT MAX(fecha_consumo) FROM consumos) - INTERVAL '1' YEAR "+
                    "GROUP BY r.usuarios_num_documento "+
                    "HAVING SUM(c.costo) > 15000000) "+
                    "SELECT u.num_documento AS num_documento_cliente, u.nombre AS nombre_cliente, "+
                    "CASE "+
                    "WHEN u.num_documento IN (SELECT num_documento_cliente FROM BuenClienteConsumo) THEN TO_CHAR((SELECT suma_consumos FROM BuenClienteConsumo WHERE num_documento_cliente = u.num_documento), '$999,999,999.99') "+
                    "ELSE 'Buen usuario por tiempo' "+
                    "END AS Razon "+
                    "FROM usuarios u "+
                    "WHERE u.num_documento IN ( "+
                    "SELECT num_documento_cliente FROM BuenClienteConsumo "+
                    "UNION "+
                    "SELECT num_documento_cliente FROM BuenClienteTiempo)" , nativeQuery = true) 
                    Collection<Object[]> rfc7();

}
