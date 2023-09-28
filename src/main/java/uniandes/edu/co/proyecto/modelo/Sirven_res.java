package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sirven_res")
public class Sirven_res {

    @EmbeddedId
    private Sirven_resPK pk;

    public Sirven_res() {
        ;
    }

    public Sirven_res(Restaurantes restaurantes_id, ProductosRestaurante productosRestaurante_id) {
        this.pk = new Sirven_resPK(restaurantes_id, productosRestaurante_id);
    }

    public Sirven_resPK getPk() {
        return pk;
    }

    public void setPk(Sirven_resPK pk) {
        this.pk = pk;
    }
    
}
