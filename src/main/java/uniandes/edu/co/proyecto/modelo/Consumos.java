package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumos")
public class Consumos {
    
    @EmbeddedId
    private ConsumosPK pk;

    private String descripcion;
    private double costo;



    
    public Consumos(Habitaciones Habitaciones_id, TiposServicio TiposServicio_tipo, String descripcion, double costo) {
        this.pk = new ConsumosPK(Habitaciones_id, TiposServicio_tipo);
        this.descripcion = descripcion;
        this.costo = costo;
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
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }

    
    
}
