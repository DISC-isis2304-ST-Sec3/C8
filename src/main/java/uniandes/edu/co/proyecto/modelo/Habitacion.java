
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "habitaciones")
public class Habitacion {
    @Id
    private String id;

    @Field("numero")
    private int numero;

    @Field("capacidad")
    private int capacidad;

    @Field("costo")
    private int costo;

    @DBRef
    private TipoHabitacion tipoHabitacion;

    public Habitacion(){
    }

    public Habitacion(int numero, int capacidad, int costo){
        this.numero = numero;
        this.capacidad = capacidad;
        this.costo = costo;
        
    }
    public Habitacion(int numero, int capacidad, int costo, TipoHabitacion tipoHabitacion){
        this.numero = numero;
        this.capacidad = capacidad;
        this.costo = costo;
        this.tipoHabitacion = tipoHabitacion;
        
    }
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public String getId(){
        return id;
    }
}
