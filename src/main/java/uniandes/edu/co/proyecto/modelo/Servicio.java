
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "servicios")
public class Servicio {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("precio")
    private int precio;

    public Servicio(){
    }

    public Servicio(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int price) {
        this.precio = price;
    }
    public String getId(){
        return id;
    }
}


