package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumosPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitaciones Habitaciones_id;
    
    @ManyToOne
    @JoinColumn(name = "TiposServicio_tipo", referencedColumnName = "tipo")
    private TiposServicio TiposServicio_tipo;

    public ConsumosPK() {
        super();
    }

    public ConsumosPK(Habitaciones habitaciones_id, TiposServicio tiposServicio_tipo) {
        super();
        Habitaciones_id = habitaciones_id;
        TiposServicio_tipo = tiposServicio_tipo;
    }

    public Habitaciones getHabitaciones_id() {
        return Habitaciones_id;
    }

    public void setHabitaciones_id(Habitaciones habitaciones_id) {
        Habitaciones_id = habitaciones_id;
    }

    public TiposServicio getTiposServicio_tipo() {
        return TiposServicio_tipo;
    }

    public void setTiposServicio_tipo(TiposServicio tiposServicio_tipo) {
        TiposServicio_tipo = tiposServicio_tipo;
    }

    

    

}