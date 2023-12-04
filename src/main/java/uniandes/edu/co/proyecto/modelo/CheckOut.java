
package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document (collection = "checkOut")
public class CheckOut {
 
    @Id
    private String id;

    @Field("reserva")
    private ObjectId reserva;

    @Field("cliente")
    private ObjectId cliente; 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso; 

    public CheckOut(){
    }

    public CheckOut( ObjectId reserva, ObjectId cliente, Date fechaIngreso){
        this.reserva = reserva;
        this.cliente = cliente;
        this.fechaIngreso = fechaIngreso;

    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectId getCliente() {
        return cliente;
    }

    public void setCliente(ObjectId cliente) {
        this.cliente = cliente;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }

    public ObjectId getReserva() {
        return reserva;
    }

    public void setReserva(ObjectId reserva) {
        this.reserva = reserva;
    }
    
}
