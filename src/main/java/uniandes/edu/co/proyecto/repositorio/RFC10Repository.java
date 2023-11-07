package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC10Repository extends JpaRepository<Consumos, Integer> {
    @Query(value = "SELECT tipo FROM tiposservicio ", nativeQuery = true)
    Collection<String> darTipoServicio();

    @Query(value = 
            "SELECT u.num_documento AS num_documento_cliente, u.nombre AS nombre_cliente "+
            "FROM usuarios u "+
            "WHERE u.num_documento NOT IN ( "+
            "SELECT " +
            "r.usuarios_num_documento " +
            "FROM consumos c " +
            "LEFT JOIN reservan rv ON c.habitaciones_id = rv.habitaciones_id " +
            "LEFT JOIN reservas r ON rv.reservas_id = r.id " +
            "WHERE c.tiposservicio_tipo = :tipoServicio AND c.fecha_consumo BETWEEN :fechaInicio AND :fechaFin)", nativeQuery = true)
    Collection<Object[]> rfc10(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("tipoServicio") String tipoServicio);
}
