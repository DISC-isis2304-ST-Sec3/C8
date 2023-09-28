package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "spas")
public class Spas {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "TiposServicio_tipo", referencedColumnName = "tipo")
    private TiposServicio TiposServicio_tipo;

    private int capacidad;

    public Spas() {
        ;
    }

    public Spas(int id, TiposServicio tiposServicio_tipo, int capacidad) {
        this.id = id;
        TiposServicio_tipo = tiposServicio_tipo;
        this.capacidad = capacidad;
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


}
