package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasspa")
public class ReservasSpa {

    @EmbeddedId
    private ReservasSpaPK pk;

    public ReservasSpa() {
        ;
    }

    public ReservasSpa(Spas spas_id, ReservasServicio reservasServicio_id) {
        this.pk = new ReservasSpaPK(spas_id, reservasServicio_id);
    }

    public ReservasSpaPK getPk() {
        return pk;
    }

    public void setPk(ReservasSpaPK pk) {
        this.pk = pk;
    }
    
}
