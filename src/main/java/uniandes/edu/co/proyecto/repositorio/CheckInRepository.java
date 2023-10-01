package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.CheckIn;
import uniandes.edu.co.proyecto.modelo.InformacionClientes;

public interface CheckInRepository extends JpaRepository<InformacionClientes, Integer> {
    
    @Query(value = "SELECT * FROM CheckIn ", nativeQuery = true)
    Collection<CheckIn> darCheckIn();

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO InformacionClientes (tipo_documento, NUM_DOCUMENTO, nombre, correo) " + //
    "VALUES ( :tipoDoc , :numDoc , :nombre , :correo ) ", nativeQuery = true )
    void insertarInfoCliente(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Long numDoc, @Param("nombre") String nombre, @Param("correo") String correo);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CheckIn (Reservas_id, informacionclientes_num_documento, informacionclientes_tipo_documento, fecha_ingreso) " +
    "VALUES ( :id , :numDoc , :tipoDoc ,TO_DATE( :fechaI ,'YYYY-MM-DD')) ", nativeQuery = true )
    void insertarCheckin(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Long numDoc, @Param("id") int idReserva , @Param("fechaI") String fechaInicial);
    
    @Query(value = "SELECT fecha_inicio FROM Reservas WHERE id = :id AND usuarios_num_documento = :numDoc AND Usuarios_tipo_documento = :tipoDoc ", nativeQuery = true )
    String fechaValidacion(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Long numDoc, @Param("id") int idReserva );
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM  CheckIn WHERE  Reservas_id = :id ", nativeQuery = true )
    void borrarCheckin(@Param("id") int id);


    
}