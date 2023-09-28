package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class VendenTiendaPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Tiendas_id", referencedColumnName = "id")
    private Tiendas Tiendas_id;
    
    @ManyToOne
    @JoinColumn(name = "ProductosTienda_id", referencedColumnName = "id")
    private ProductosTienda ProductosTienda_id;

    public VendenTiendaPK() {
        super();
    }

    public VendenTiendaPK(Tiendas tiendas_id, ProductosTienda productosTienda_id) {
        super();
        Tiendas_id = tiendas_id;
        ProductosTienda_id = productosTienda_id;
    }

    public Tiendas getTiendas_id() {
        return Tiendas_id;
    }

    public void setTiendas_id(Tiendas tiendas_id) {
        Tiendas_id = tiendas_id;
    }

    public ProductosTienda getProductosTienda_id() {
        return ProductosTienda_id;
    }

    public void setProductosTienda_id(ProductosTienda productosTienda_id) {
        ProductosTienda_id = productosTienda_id;
    }

    

}
