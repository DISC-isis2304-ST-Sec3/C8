package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TiposUsuario;

public interface TiposUsuarioRepository extends JpaRepository<TiposUsuario, Integer> {
    
    @Query(value = "SELECT * FROM TiposUsuario", nativeQuery = true )
    Collection<TiposUsuario> darTiposUsuario();
    
    @Query(value = "SELECT * FROM TiposUsuario WHERE tipo = :tipo ", nativeQuery = true )
    TiposUsuario darTipoUsuario(@Param("tipo") String tipo);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TiposUsuario (tipo) VALUES (:tipo)", nativeQuery = true )
    void insertarTipoUsuario(@Param("tipo") String tipo);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TiposUsuario WHERE tipo = :tipo ", nativeQuery = true )
    void eliminarTipoUsuario(@Param("tipo") String tipo);
    
}
