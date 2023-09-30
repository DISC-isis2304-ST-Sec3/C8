package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitaciones {
    
    @Id
    private int id;

    private int capacidad;
    private double costo;

    @ManyToOne
    @JoinColumn(name = "TIPOSHABITACION_TIPO", referencedColumnName = "tipo")
    private TiposHabitacion TiposHabitacion_tipo;

    public Habitaciones() {
        ;
    }

    public Habitaciones(int id, int capacidad, double costo, TiposHabitacion tiposHabitacion_tipo) {
        this.id = id;
        this.capacidad = capacidad;
        this.costo = costo;
        TiposHabitacion_tipo = tiposHabitacion_tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public TiposHabitacion getTiposHabitacion_tipo() {
        return TiposHabitacion_tipo;
    }

    public void setTiposHabitacion_tipo(TiposHabitacion tiposHabitacion_tipo) {
        TiposHabitacion_tipo = tiposHabitacion_tipo;
    }

    

}
