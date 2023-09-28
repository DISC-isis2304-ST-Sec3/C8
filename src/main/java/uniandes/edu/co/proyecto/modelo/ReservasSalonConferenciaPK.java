package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservasSalonConferenciaPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "ReservasServicio_id", referencedColumnName = "id")
    private ReservasServicio ReservasServicio_id;
    
    @ManyToOne
    @JoinColumn(name = "SalonesConferencia_id", referencedColumnName = "id")
    private SalonesConferencia SalonesConferencia_id;

    public ReservasSalonConferenciaPK() {
        super();
    }

    public ReservasSalonConferenciaPK(ReservasServicio ReservasServico_id, SalonesConferencia SalonesConferencia_id) {
        super();
        this.ReservasServicio_id = ReservasServico_id;
        this.SalonesConferencia_id = SalonesConferencia_id;
    }

    public ReservasServicio getReservasServicio_id() {
        return ReservasServicio_id;
    }

    public void setReservasServicio_id(ReservasServicio reservasServicio_id) {
        ReservasServicio_id = reservasServicio_id;
    }

    public SalonesConferencia getSalonesConferencia_id() {
        return SalonesConferencia_id;
    }

    public void setSalonesConferencia_id(SalonesConferencia salonesConferencia_id) {
        SalonesConferencia_id = salonesConferencia_id;
    }



}
