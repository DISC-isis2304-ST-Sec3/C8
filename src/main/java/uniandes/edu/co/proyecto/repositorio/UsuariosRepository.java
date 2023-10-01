package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
    
    @Query(value = "SELECT * FROM Usuarios ", nativeQuery = true )
    Collection<Usuarios> darUsuarios();
    
    @Query(value = "SELECT * FROM Usuarios WHERE tipo_documento = :tipoDoc AND num_documento = :numDoc AND nombre = :nombre AND correo = :correo ", nativeQuery = true )
    Usuarios darUsuario(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Long numDoc, @Param("nombre") String nombre, @Param("correo") String correo);
    
    @Query(value = "SELECT * FROM Usuarios WHERE tipo_documento = :tipoDoc AND num_documento = :numDoc ", nativeQuery = true )
    Usuarios darUsuarioPorNumDocumento(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Long numDoc);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo) VALUES (:tipo_documento , :num_documento , :nombre , :correo , :tipo_user) ", nativeQuery = true )
    void insertarUsuario(@Param("tipo_documento") String tipo_documento, @Param("num_documento") Long num_documento,@Param("nombre") String nombre, @Param("correo") String correo, @Param("tipo_user") String tipoUsuario);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuarios SET TiposUsuario_tipo = :tipoUser WHERE tipo_documento = :tipoDocumento AND num_documento = :numDocumento", nativeQuery = true)
    void actualizarUsuario(@Param("tipoDocumento") String tipo_documento, @Param("numDocumento") Long num_documento, @Param("tipoUser") String tipoUsuario);
    
    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuarios WHERE tipo_documento = :tipo_documento AND num_documento = :num_documento ", nativeQuery = true )
    void eliminarUsuario(@Param("tipo_documento") String tipo_documento, @Param("num_documento") Long num_documento);


}
