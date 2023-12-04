
package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "tiposServicio")
public class TipoServicio {

    @Id
    private String id;

    @Field("tipo")
    private String tipo; 

    @Field("descripcion")
    private String descripcion; 


    // Constructor vacio para el uso de Spring
    public TipoServicio(){}

    // Constructor con solo el nombre del tipo de bebida
    public TipoServicio(String tipo, String descripcion){
        this.tipo = tipo;
        this.descripcion = descripcion;
    }


    //setter para agregar una referencia de bebida a las bebidas que se tienen


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String  getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String  getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
