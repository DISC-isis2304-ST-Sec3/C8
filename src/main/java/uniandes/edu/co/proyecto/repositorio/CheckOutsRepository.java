package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CheckOuts;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface CheckOutsRepository extends JpaRepository<CheckOuts, Integer> {
    
    @Query(value = "SELECT * FROM CheckOuts", nativeQuery = true )
    Collection<CheckOuts> darCheckOuts();
    
    @Query(value = "SELECT fecha_salida FROM CheckOuts WHERE reservas_id = :id AND habitaciones_id = :id2 ", nativeQuery = true )
    String darFechaSalida(@Param("id") int idRes, @Param("id2") int idHab);

    @Query(value = "SELECT SUM(costo) FROM Consumos WHERE habitaciones_id = :idHab ", nativeQuery = true )
    double consumosHabitacion(@Param("idHab") int idhab);

    @Query(value = "SELECT costo FROM Consumos WHERE habitaciones_id = :idHab ", nativeQuery = true )
    Collection<Double> consumos2Habitacion(@Param("idHab") int idhab);

    @Query(value = "SELECT tiposservicio_tipo FROM Consumos WHERE habitaciones_id = :idHab ", nativeQuery = true )
    Collection<String> consumos3Habitacion(@Param("idHab") int idhab);
    
    @Modifying
    @Transactional 
    @Query(value = "INSERT INTO CheckOuts (reservas_id, Habitaciones_id, fecha_salida) VALUES ( :idRes , :idHab , TO_DATE( :fechaI ,'YYYY-MM-DD'))", nativeQuery = true)
        void insertarCheckOut(@Param("idRes") int idRes, @Param("idHab") int idHab, @Param("fechaI") String fechaI);
    
    @Query(value = "SELECT fecha_salida FROM Reservas WHERE id = :id ", nativeQuery = true )
    String fechaValidacion(@Param("id") int idReserva );

    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM CheckOuts WHERE reservas_id = :id ", nativeQuery = true )
    void eliminarCheckOut(@Param("id") int id);

    @Query(value = "DELETE FROM Consumos WHERE habitaciones_id = :idHab ", nativeQuery = true )
    double eliminarConsumos(@Param("idHab") int idhab);


    
}