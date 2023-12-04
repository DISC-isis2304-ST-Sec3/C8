
package uniandes.edu.co.proyecto.modelo;



import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "consumos")
public class Consumo {
    @Id
    private String id;

    @Field("habitacion")
    private ObjectId habitacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaConsumo;
    
    @DBRef
    private TipoServicio tipoServicio;

    @DBRef
    private Servicio servicio;

    public Consumo(){
    }

    public Consumo(ObjectId habitacion, Date fechaConsumo){
        this.habitacion = habitacion;
        this.fechaConsumo = fechaConsumo;
    }

    public Consumo(ObjectId habitacion, Date fechaConsumo, TipoServicio tipoServicio, Servicio servicio){
        this.habitacion = habitacion;
        this.fechaConsumo = fechaConsumo;
        this.tipoServicio = tipoServicio;
        this.servicio = servicio;
    }

    public String getId() {
        return id;
    }

    public ObjectId getHabitacion() {
        return habitacion;
    }

    public Date getFechaConsumo() {
        return fechaConsumo;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHabitacion(ObjectId habitacion) {
        this.habitacion = habitacion;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }


}
