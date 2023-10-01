package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas, Integer> {
    
    @Query(value = "SELECT * FROM Reservas", nativeQuery = true )
    Collection<Reservas> darReservas();
    
    @Query(value = "SELECT * FROM Reservas WHERE id = :id ", nativeQuery = true )
    Reservas darReserva(@Param("id") int id);
    
    @Modifying
    @Transactional 
    @Query(value = "INSERT INTO Reservas (fecha_inicio, fecha_salida, num_personas, Usuarios_tipo_documento, Usuarios_num_documento, Usuarios_correo, Usuarios_nombre, PlanesConsumo_id) " +
            "VALUES (TO_DATE(:fechaInicio, 'YYYY-MM-DD HH24:MI:SS'), TO_DATE(:fechaFin, 'YYYY-MM-DD HH24:MI:SS'), :numPersonas, :tipoDoc, :numDoc, :correo, :nombre, :idPlanConsumo)", nativeQuery = true)
        void insertarReserva(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("numPersonas") int numPersonas,
                         @Param("tipoDoc") String tipoDoc, @Param("numDoc") Long numDoc, @Param("correo") String correo,
                         @Param("nombre") String nombre, @Param("idPlanConsumo") int idPlanConsumo);
    


    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM Reservas WHERE id = :id ", nativeQuery = true )
    void eliminarReserva(@Param("id") int id);

    
}