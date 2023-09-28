package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservassalonreunion")
public class ReservasSalonReunion {

    @EmbeddedId
    private ReservasSalonReunionPK pk;

    public ReservasSalonReunion() {
        ;
    }

    public ReservasSalonReunion(ReservasServicio ReservasServico_id, SalonesReunion SalonesReunion_id) {
        this.pk = new ReservasSalonReunionPK(ReservasServico_id, SalonesReunion_id);
    }

    public ReservasSalonReunionPK getPk() {
        return pk;
    }

    public void setPk(ReservasSalonReunionPK pk) {
        this.pk = pk;
    }
    
}
