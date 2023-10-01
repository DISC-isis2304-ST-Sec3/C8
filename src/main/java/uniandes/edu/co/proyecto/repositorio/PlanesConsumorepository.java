package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanesConsumo;

public interface PlanesConsumorepository extends JpaRepository<PlanesConsumo, Integer> {
    
    @Query(value = "SELECT * FROM PlanesConsumo", nativeQuery = true )
    Collection<PlanesConsumo> darPlanesConsumo();
    
    @Query(value = "SELECT * FROM PlanesConsumo WHERE id = :id ", nativeQuery = true )
    PlanesConsumo darPlanConsumo(@Param("id") int id);
    
    @Query(value = "SELECT id FROM PlanesConsumo WHERE nombre = :name AND ROWNUM <= 1 ", nativeQuery = true )
    PlanesConsumo darIdPlanConsumo(@Param("name") String name);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PlanesConsumo (nombre, estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio) " +
                   "VALUES (:nombre, :estadiaMin, :costo, :descReserva, :descBar, :descRestaurante, :descServicio)", nativeQuery = true)
    void insertarPlanConsumo(@Param("nombre") String nombre, @Param("estadiaMin") int estadiaMin, @Param("costo") double costo,
                            @Param("descReserva") double descReserva, @Param("descBar") double descBar,
                            @Param("descRestaurante") double descRestaurante, @Param("descServicio") double descServicio);
                        
    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM PlanesConsumo WHERE id = :id ", nativeQuery = true )
    void eliminarPlanConsumo(@Param("id") int id);

    
}