package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sirven_bar")
public class Sirven_bar {

    @EmbeddedId
    private Sirven_barPK pk;

    public Sirven_bar() {
        ;
    }

    public Sirven_bar(Bares bares_id, ProductosBar productosBar_id) {
        this.pk = new Sirven_barPK(bares_id, productosBar_id);
    }


    public Sirven_barPK getPk() {
        return pk;
    }

    public void setPk(Sirven_barPK pk) {
        this.pk = pk;
    }
    
}