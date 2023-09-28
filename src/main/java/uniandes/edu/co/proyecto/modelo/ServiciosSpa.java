package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosspa")
public class ServiciosSpa {
    
    @Id
    private int id;

    private String nombre;
    private double costo;
    private int duracion_min;

    public ServiciosSpa() {
        ;
    }

    public ServiciosSpa(int id, String nombre, double costo, int duracion_min) {
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getDuracion_min() {
        return duracion_min;
    }

    public void setDuracion_min(int duracion_min) {
        this.duracion_min = duracion_min;
    }

    
    
}
