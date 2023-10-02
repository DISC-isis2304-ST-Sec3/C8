package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Consumos;

public interface ConsumosRepository extends JpaRepository<Consumos, Integer> {
    
    @Query(value = "SELECT * FROM Consumos", nativeQuery = true )
    Collection<Consumos> darConsumos();
    
    @Query(value = "SELECT precio FROM productossuper WHERE nombre = :nombre ", nativeQuery = true )
    Double darPrecioSuper(@Param("nombre") String nombre);
    
    @Query(value = "SELECT precio FROM productostienda WHERE nombre = :nombre ", nativeQuery = true )
    Double darPrecioTienda(@Param("nombre") String nombre);
    
    @Query(value = "SELECT precio FROM productosrestaurante WHERE nombre = :nombre ", nativeQuery = true )
    Double darPrecioRestaurante(@Param("nombre") String nombre);
    
    @Query(value = "SELECT precio FROM productosbar WHERE nombre = :nombre ", nativeQuery = true )
    Double darPrecioBar(@Param("nombre") String nombre);
    
    @Query(value = "SELECT nombre FROM productossuper ", nativeQuery = true )
    Collection<String> darproductoSuper();
    
    @Query(value = "SELECT nombre FROM productostienda ", nativeQuery = true )
    Collection<String> darproductoTienda();
    
    @Query(value = "SELECT nombre FROM productosrestaurante ", nativeQuery = true )
    Collection<String> darproductoRestaurante();
    
    @Query(value = "SELECT nombre FROM productosbar ", nativeQuery = true )
    Collection<String> darproductoBar();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Consumos (Habitaciones_id, TiposServicio_tipo, descripcion, costo) " +
                   "VALUES ( :idHab , :tipoServ , :descrip , :costo)", nativeQuery = true)
    void insertarConsumo(@Param("idHab") int idHab, @Param("tipoServ") String tipoServ, @Param("descrip") String descrip, @Param("costo") Double costo);
                        
    @Modifying
    @Transactional 
    @Query(value = "DELETE FROM Consumos WHERE id = :id ", nativeQuery = true )
    void eliminarConsumo(@Param("id") int idHab);

    
}