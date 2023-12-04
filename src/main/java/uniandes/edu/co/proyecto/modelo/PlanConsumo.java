
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "planesConsumo")
public class PlanConsumo {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("estadiaMinima")
    private int estadiaMinima;

    @Field("costo")
    private int costo;

    @Field("descuentoReserva")
    private int descuentoReserva;

    @Field("descuentoBar")
    private int descuentoBar;

    @Field("descuentoRestaurante")
    private int descuentoRestaurante;

    @Field("descuentoServicio")
    private int descuentoServicio;

    public PlanConsumo(){
    }

    public PlanConsumo(String nombre, int estadiaMinima, int costo, int descuentoReserva, int descuentoBar, int descuentoRestaurante, int descuentoServicio){
        this.nombre = nombre;
        this.estadiaMinima = estadiaMinima;
        this.costo = costo;
        this.descuentoReserva = descuentoReserva;
        this.descuentoBar = descuentoBar;
        this.descuentoRestaurante = descuentoRestaurante;
        this.descuentoServicio = descuentoServicio;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public int getEstadiaMinima() {
        return estadiaMinima;
    }

    public void setEstadiaMinima(int estadiaMinima) {
        this.estadiaMinima = estadiaMinima;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int cost) {
        this.costo = cost;
    }

    public int getDescuentoReserva() {
        return descuentoReserva;
    }

    public void setDescuentoReserva(int descuentoReserva) {
        this.descuentoReserva = descuentoReserva;
    }

    public int getDescuentoBar() {
        return descuentoBar;
    }

    public void setDescuentoBar(int descuentoBar) {
        this.descuentoBar = descuentoBar;
    }

    public int getDescuentoRestaurante() {
        return descuentoRestaurante;
    }

    public void setDescuentoRestaurante(int descuentoRestaurante) {
        this.descuentoRestaurante = descuentoRestaurante;
    }

    public int getDescuentoServicio() {
        return descuentoServicio;
    }

    public void setDescuentoServicio(int descuentoServicio) {
        this.descuentoServicio = descuentoServicio;
    }

    public String getId(){
        return id;
    }
}

