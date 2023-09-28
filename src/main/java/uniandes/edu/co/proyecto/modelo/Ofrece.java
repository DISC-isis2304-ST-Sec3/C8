package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ofrece")
public class Ofrece {

    @EmbeddedId
    private OfrecePK pk;

    public Ofrece() {
        ;
    }

    public Ofrece(Spas spas_id, ServiciosSpa serviciosSpa_id) {
        this.pk = new OfrecePK(spas_id, serviciosSpa_id);
    }

    public OfrecePK getPk() {
        return pk;
    }

    public void setPk(OfrecePK pk) {
        this.pk = pk;
    }
    
}
