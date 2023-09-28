package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "presta")
public class Presta {

    @EmbeddedId
    private PrestaPK pk;

    public Presta() {
        ;
    }

    public Presta(ServiciosPrestamo serviciosPrestamo_id, Utensilios utensilios_id) {
        this.pk = new PrestaPK(serviciosPrestamo_id, utensilios_id);
    }

    public PrestaPK getPk() {
        return pk;
    }

    public void setPk(PrestaPK pk) {
        this.pk = pk;
    }
    
}
