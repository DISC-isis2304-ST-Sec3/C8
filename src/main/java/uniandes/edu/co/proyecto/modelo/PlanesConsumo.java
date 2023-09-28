package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planesconsumo")
public class PlanesConsumo {

    @Id
    private int id;

    private String nombre;
    private int estadia_min;
    private double costo;
    private double desc_reserva;
    private double desc_bar;
    private double desc_restaurante;
    private double desc_servicio;

    public PlanesConsumo(int id, String nombre, int estadia_min, double costo, double desc_reserva, double desc_bar,
            double desc_restaurante, double desc_servicio) {
        this.id = id;
        this.nombre = nombre;
        this.estadia_min = estadia_min;
        this.costo = costo;
        this.desc_reserva = desc_reserva;
        this.desc_bar = desc_bar;
        this.desc_restaurante = desc_restaurante;
        this.desc_servicio = desc_servicio;
    }

    public PlanesConsumo() {
        ;
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

    public int getEstadia_min() {
        return estadia_min;
    }

    public void setEstadia_min(int estadia_min) {
        this.estadia_min = estadia_min;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getDesc_reserva() {
        return desc_reserva;
    }

    public void setDesc_reserva(double desc_reserva) {
        this.desc_reserva = desc_reserva;
    }

    public double getDesc_bar() {
        return desc_bar;
    }

    public void setDesc_bar(double desc_bar) {
        this.desc_bar = desc_bar;
    }

    public double getDesc_restaurante() {
        return desc_restaurante;
    }

    public void setDesc_restaurante(double desc_restaurante) {
        this.desc_restaurante = desc_restaurante;
    }

    public double getDesc_servicio() {
        return desc_servicio;
    }

    public void setDesc_servicio(double desc_servicio) {
        this.desc_servicio = desc_servicio;
    }

}
