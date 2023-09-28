package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Sirven_barPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Bares_id", referencedColumnName = "id")
    private Bares Bares_id;
    
    @ManyToOne
    @JoinColumn(name = "ProductosBar_id", referencedColumnName = "id")
    private ProductosBar ProductosBar_id;

    public Sirven_barPK() {
        super();
    }

    public Sirven_barPK(Bares bares_id, ProductosBar productosBar_id) {
        super();
        Bares_id = bares_id;
        ProductosBar_id = productosBar_id;
    }

    public Bares getBares_id() {
        return Bares_id;
    }

    public void setBares_id(Bares bares_id) {
        Bares_id = bares_id;
    }

    public ProductosBar getProductosBar_id() {
        return ProductosBar_id;
    }

    public void setProductosBar_id(ProductosBar productosBar_id) {
        ProductosBar_id = productosBar_id;
    }

    

}
