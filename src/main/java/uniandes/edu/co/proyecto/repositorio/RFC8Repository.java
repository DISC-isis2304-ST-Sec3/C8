package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumos;

public interface RFC8Repository extends JpaRepository<Consumos, Integer>{

    @Query(value = "WITH ConsumosPorSemana AS ( "+
                    "SELECT t.tipo, TO_CHAR(c.fecha_consumo, 'IYYY-IW') AS semana, COUNT(*) AS veces_consumido "+
                    "FROM consumos c INNER JOIN tiposservicio t ON c.tiposservicio_tipo = t.tipo "+
                    "WHERE c.fecha_consumo BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD') "+
                    "GROUP BY t.tipo, TO_CHAR(c.fecha_consumo, 'IYYY-IW') ) "+
                    "SELECT s.tipo, s.semana, s.veces_consumido "+
                    "FROM ConsumosPorSemana s "+
                    "WHERE s.veces_consumido < 3" , nativeQuery = true)
                    Collection<Object[]> rfc8();

}