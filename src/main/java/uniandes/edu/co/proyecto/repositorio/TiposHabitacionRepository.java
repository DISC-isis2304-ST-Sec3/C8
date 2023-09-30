package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TiposHabitacion;

public interface TiposHabitacionRepository extends JpaRepository<TiposHabitacion, Integer> {
    
    @Query(value = "SELECT * FROM TiposHabitacion", nativeQuery = true )
    Collection<TiposHabitacion> darTiposHabitacion();
    
    @Query(value = "SELECT * FROM TiposHabitacion WHERE tipo = :tipo ", nativeQuery = true )
    TiposHabitacion darTipoHabitacion(@Param("tipo") String tipo);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TiposHabitacion (tipo, jacuzzi, comedor, cocina) VALUES (:tipo , :jacuzzi , :comedor , :cocina)", nativeQuery = true )
    void insertarTipoHabitacion(@Param("tipo") String tipo, @Param("jacuzzi") int jacuzzi, @Param("comedor") int comedor, @Param("cocina") int cocina);
    
    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM TiposHabitacion WHERE tipo = :tipo ", nativeQuery = true )
    void eliminarTipoHabitacion(@Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TiposHabitacion SET jacuzzi = :jacuzzi , comedor = :comedor , cocina = :cocina WHERE tipo = :tipo", nativeQuery = true)
    void actualizarHabitacion(@Param("tipo") String tipo, @Param("jacuzzi") int jacuzzi, @Param("comedor") int comedor, @Param("cocina") int cocina);
    
    
}