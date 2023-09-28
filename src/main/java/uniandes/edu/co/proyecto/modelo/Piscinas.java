package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscinas")
public class Piscinas {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "TiposServicio_tipo", referencedColumnName = "tipo")
    private TiposServicio TiposServicio_tipo;

    private int profundidad_m;
    private int capacidad;
    private String hora_inicio;
    private String hora_fin;

    public Piscinas() {
        ;
    }

    public Piscinas(int id, TiposServicio tiposServicio_tipo, int profundidad_m, int capacidad, String hora_inicio,
            String hora_fin) {
        this.id = id;
        TiposServicio_tipo = tiposServicio_tipo;
        this.profundidad_m = profundidad_m;
        this.capacidad = capacidad;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
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

    public int getProfundidad_m() {
        return profundidad_m;
    }

    public void setProfundidad_m(int profundidad_m) {
        this.profundidad_m = profundidad_m;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }



    

}