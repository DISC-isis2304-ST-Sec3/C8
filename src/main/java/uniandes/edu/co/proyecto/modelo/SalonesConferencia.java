package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salonesconferencia")
public class SalonesConferencia {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "TiposServicio_tipo", referencedColumnName = "tipo")
    private TiposServicio TiposServicio_tipo;

    private int capacidad;
    private double costo_hora;

    public SalonesConferencia() {
        ;
    }

    public SalonesConferencia(int id, TiposServicio tiposServicio_tipo, int capacidad, double costo_hora) {
        this.id = id;
        TiposServicio_tipo = tiposServicio_tipo;
        this.capacidad = capacidad;
        this.costo_hora = costo_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TiposServicio getTiposServicio_tipo() {
        return TiposServicio_tipo;
    }

    public void setTiposServicio_tipo(TiposServicio tiposServicio_tipo) {
        TiposServicio_tipo = tiposServicio_tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCosto_hora() {
        return costo_hora;
    }

    public void setCosto_hora(double costo_hora) {
        this.costo_hora = costo_hora;
    }



    

}
