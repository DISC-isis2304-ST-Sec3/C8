package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.TiposServicio;

public interface DescripcionServiciosRepository extends JpaRepository<TiposServicio, Integer> {
    
    @Query(value = "SELECT * FROM tiposServicio", nativeQuery = true )
    Collection<TiposServicio> darTiposServicio();
    
    @Query(value = "SELECT * FROM tiposServicio WHERE id = :id ", nativeQuery = true )
    TiposServicio darTiposServicio(@Param("id") int id);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposServicio SET descripcion = :descripcion WHERE tipo = :tipo ", nativeQuery = true)
    void insertarTiposServicio(@Param("tipo") String tipo, @Param("descripcion") String descripcion);
    
    
    @Modifying
    @Transactional 
    @Query(value = "UPDATE tiposServicio SET descripcion = ' ' WHERE tipo = :tipo", nativeQuery = true )
    void eliminarTiposServicio(@Param("tipo") String tipo);

    
}