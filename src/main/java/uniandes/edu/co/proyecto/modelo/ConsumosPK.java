package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumosPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Habitaciones_id", referencedColumnName = "id")
    private Habitaciones Habitaciones_id;
    
    @ManyToOne
    @JoinColumn(name = "tiposservicio_tipo", referencedColumnName = "tipo")
    private TiposServicio tiposservicio_tipo;

    private Date fecha_consumo;
    public ConsumosPK() {
        super();
    }

    public ConsumosPK(Habitaciones habitaciones_id, TiposServicio tiposServicio_tipo, Date fecha_Consumo) {
        super();
        Habitaciones_id = habitaciones_id;
        tiposservicio_tipo = tiposServicio_tipo;
        fecha_consumo = fecha_Consumo;
    }

    public Habitaciones getHabitaciones_id() {
        return Habitaciones_id;
    }

    public void setHabitaciones_id(Habitaciones habitaciones_id) {
        Habitaciones_id = habitaciones_id;
    }

    public TiposServicio getTiposservicio_tipo() {
        return tiposservicio_tipo;
    }

    public void setTiposservicio_tipo(TiposServicio tiposServicio_tipo) {
        tiposservicio_tipo = tiposServicio_tipo;
    }

    public Date getFecha_consumo() {
        return fecha_consumo;
    }

    public void setFecha_consumo(Date fecha_Consumo) {
        fecha_consumo = fecha_Consumo; 
    }

}
