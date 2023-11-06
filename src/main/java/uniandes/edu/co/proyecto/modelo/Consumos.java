package uniandes.edu.co.proyecto.modelo;


import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumos")
public class Consumos {
    
    @EmbeddedId
    private ConsumosPK pk;

    private String descripcion;
    private Double costo;
    private Date fecha_consumo;


    
    public Consumos() {
        ;
    }

    public Consumos(Habitaciones Habitaciones_id, TiposServicio TiposServicio_tipo, String descripcion, Double costo, Date fecha_consumo) {
        this.pk = new ConsumosPK(Habitaciones_id, TiposServicio_tipo);
        this.descripcion = descripcion;
        this.costo = costo;
        this.fecha_consumo = fecha_consumo;
    }

    public ConsumosPK getPk() {
        return pk;
    }
    public void setPk(ConsumosPK pk) {
        this.pk = pk;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getCosto() {
        return costo;
    }
    public void setCosto(Double costo) {
        this.costo = costo;
    }
    public Date getFecha_consumo() {
        return fecha_consumo;
    }
    public void setFecha_consumo(Date fecha_consumo) {
        this.fecha_consumo = fecha_consumo;
    }

    
    
}
