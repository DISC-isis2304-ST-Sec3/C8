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
    @JoinColumn(name = "TIPOSSERVICIO_TIPO", referencedColumnName = "tipo")
    private TiposServicio tiposservicio_tipo;

    public ConsumosPK() {
        super();
    }

    public ConsumosPK(Habitaciones habitaciones_id, TiposServicio tiposServicio_tipo) {
        super();
        Habitaciones_id = habitaciones_id;
        tiposservicio_tipo = tiposServicio_tipo;
    }

    public Habitaciones getHabitaciones_id() {
        return Habitaciones_id;
    }

    public void setHabitaciones_id(Habitaciones habitaciones_id) {
        Habitaciones_id = habitaciones_id;
    }

    public TiposServicio gettiposservicio_tipo() {
        return tiposservicio_tipo;
    }

    public void settiposservicio_tipo(TiposServicio tiposServicio_tipo) {
        tiposservicio_tipo = tiposServicio_tipo;
    }

    

    

}
