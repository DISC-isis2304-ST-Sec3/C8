package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendensuper")
public class VendenSuper {

    @EmbeddedId
    private VendenSuperPK pk;

    public VendenSuper() {
        ;
    }


    public VendenSuper(Supermercados supermercados_id, ProductosSuper productosSuper_id) {
        this.pk = new VendenSuperPK(supermercados_id, productosSuper_id);
    }


    public VendenSuperPK getPk() {
        return pk;
    }

    public void setPk(VendenSuperPK pk) {
        this.pk = pk;
    }
    
}
