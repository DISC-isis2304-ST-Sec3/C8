package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservan")
public class Reservan {
    
    @EmbeddedId
    private ReservanPK pk;

    private Date fecha_salida;

    public Reservan(Habitaciones Habitaciones_id, Reservas Reservas_id, Date fecha_salida) {
        this.pk = new ReservanPK(Reservas_id, Habitaciones_id);
        this.fecha_salida = fecha_salida;
    }

    public Reservan() {
        ;
    }

    public ReservanPK getPk() {
        return pk;
    }

    public void setPk(ReservanPK pk) {
        this.pk = pk;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    
    
}