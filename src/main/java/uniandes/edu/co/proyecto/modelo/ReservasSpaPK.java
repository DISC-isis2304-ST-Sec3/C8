package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservasSpaPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Spas_id", referencedColumnName = "id")
    private Spas Spas_id;
    
    @ManyToOne
    @JoinColumn(name = "ReservasServicio_id", referencedColumnName = "id")
    private ReservasServicio ReservasServicio_id;

    public ReservasSpaPK() {
        super();
    }

    public ReservasSpaPK(Spas spas_id, ReservasServicio reservasServicio_id) {
        super();
        Spas_id = spas_id;
        ReservasServicio_id = reservasServicio_id;
    }

    public Spas getSpas_id() {
        return Spas_id;
    }

    public void setSpas_id(Spas spas_id) {
        Spas_id = spas_id;
    }

    public ReservasServicio getReservasServicio_id() {
        return ReservasServicio_id;
    }

    public void setReservasServicio_id(ReservasServicio reservasServicio_id) {
        ReservasServicio_id = reservasServicio_id;
    }

    

}
