package uniandes.edu.co.proyecto.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosspa")
public class ServiciosSpa {
    
    @Id
    private int id;

    private String nombre;
    private BigDecimal costo;
    private int duracion_min;

    public ServiciosSpa() {
        ;
    }

    public ServiciosSpa(int id, String nombre, BigDecimal costo, int duracion_min) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.duracion_min = duracion_min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public int getDuracion_min() {
        return duracion_min;
    }

    public void setDuracion_min(int duracion_min) {
        this.duracion_min = duracion_min;
    }

    
    
}
