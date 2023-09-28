package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservassalonconferencia")
public class ReservasSalonConferencia {

    @EmbeddedId
    private ReservasSalonConferenciaPK pk;

    public ReservasSalonConferencia() {
        ;
    }

    public ReservasSalonConferencia(ReservasServicio ReservasServico_id, SalonesConferencia SalonesConferencia_id) {
        this.pk = new ReservasSalonConferenciaPK(ReservasServico_id, SalonesConferencia_id);
    }

    public ReservasSalonConferenciaPK getPk() {
        return pk;
    }

    public void setPk(ReservasSalonConferenciaPK pk) {
        this.pk = pk;
    }
    
}
