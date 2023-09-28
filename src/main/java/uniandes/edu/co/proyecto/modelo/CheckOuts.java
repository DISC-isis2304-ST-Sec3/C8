package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "checkouts")
public class CheckOuts {
    
    @EmbeddedId
    private CheckOutsPK pk;

    private Date fecha_salida;

    public CheckOuts(Reservas Reservas_id, Habitaciones Habitaciones_id, Date fecha_salida) {
        this.pk = new CheckOutsPK(Reservas_id, Habitaciones_id);
        this.fecha_salida = fecha_salida;
    }

    public CheckOuts() {
        ;
    }

    public CheckOutsPK getPk() {
        return pk;
    }

    public void setPk(CheckOutsPK pk) {
        this.pk = pk;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    
    
}
