
package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "reservas")
public class Reserva {

    @Id
    private String id;

    @Field("fechaEntrada")
    private Date fechaEntrada; 

    @Field("fechaSalida")
    private Date fechaSalida; 

    @Field("numeroPersonas")
    private int numeroPersonas; 

    @Field("habitacion")
    private ObjectId habitacion;

    @DBRef
    private Cliente cliente;

    public Reserva(){
    }

    public Reserva( Date fechaEntrada, Date fechaSalida, int numeroPersonas, ObjectId habitacion){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroPersonas = numeroPersonas;
        this.habitacion = habitacion;

    }
    // Constructor con el nombre del tipo de bebida y una lista de bebidas
    public Reserva( Date fechaEntrada, Date fechaSalida, int numeroPersonas, ObjectId habitacion, Cliente cliente){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numeroPersonas = numeroPersonas;
        this.habitacion = habitacion;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida){
        this.fechaSalida = fechaSalida;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas){
        this.numeroPersonas = numeroPersonas;
    }

    public ObjectId getHabitacion(){
        return this.habitacion;
    }

    public void setHabitacion(ObjectId habitacion){
        this.habitacion = habitacion;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
}
