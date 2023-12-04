
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;

    @Field("tipoDocumento")
    private String tipoDocumento;

    @Field("numDocumento")
    private int numDocumento;

    @Field("nombre")
    private String nombre;

    @Field("correo")
    private String correo;

    public Cliente(){
    }

    public Cliente(String tipoDocumento, int numDocumento, String nombre, String correo){
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.correo = correo;
    }
    

    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public int getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String mail) {
        this.correo = mail;
    }
    public String getId(){
        return id;
    }
}

