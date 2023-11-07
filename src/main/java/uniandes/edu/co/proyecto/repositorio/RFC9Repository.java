package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC9Repository extends JpaRepository<Consumos, Integer> {
    @Query(value = "SELECT tipo FROM tiposservicio ", nativeQuery = true)
    Collection<String> darTipoServicio();

    @Query(value = "SELECT " +
            "r.usuarios_num_documento AS num_documento_cliente, " +
            "r.usuarios_nombre AS nombre_cliente, " +
            "c.tiposservicio_tipo AS tipo_servicio, " +
            "COUNT(c.tiposservicio_tipo) AS veces_utilizado " +
            "FROM consumos c " +
            "LEFT JOIN reservan rv ON c.habitaciones_id = rv.habitaciones_id " +
            "LEFT JOIN reservas r ON rv.reservas_id = r.id " +
            "WHERE c.tiposservicio_tipo = :tipoServicio AND c.fecha_consumo BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY r.usuarios_num_documento, r.usuarios_nombre, c.tiposservicio_tipo " +
            "ORDER BY r.usuarios_nombre ASC", nativeQuery = true)
    Collection<Object[]> rfc9(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("tipoServicio") String tipoServicio);
}

