package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservasSalonReunionPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "ReservasServicio_id", referencedColumnName = "id")
    private ReservasServicio ReservasServicio_id;
    
    @ManyToOne
    @JoinColumn(name = "SalonesReunion_id", referencedColumnName = "id")
    private SalonesReunion SalonesReunion_id;

    public ReservasSalonReunionPK() {
        super();
    }

    public ReservasSalonReunionPK(ReservasServicio ReservasServico_id, SalonesReunion SalonesReunion_id) {
        super();
        this.ReservasServicio_id = ReservasServico_id;
        this.SalonesReunion_id = SalonesReunion_id;
    }

    public ReservasServicio getReservasServicio_id() {
        return ReservasServicio_id;
    }

    public void setReservasServicio_id(ReservasServicio reservasServicio_id) {
        ReservasServicio_id = reservasServicio_id;
    }

    public SalonesReunion getSalonesReunion_id() {
        return SalonesReunion_id;
    }

    public void setSalonesReunion_id(SalonesReunion salonesReunion_id) {
        SalonesReunion_id = salonesReunion_id;
    }



}