package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "informacionclientes")
public class InformacionClientes {

    @EmbeddedId
    private InformacionClientesPK pk;

    private String nombre;
    private String correo;

    public InformacionClientes(String tipo_documento, int num_documento, String nombre, String correo) {
        this.pk = new InformacionClientesPK(tipo_documento, num_documento);
        this.nombre = nombre;
        this.correo = correo;
    }

    public InformacionClientes() {
        ;
    }

    public InformacionClientesPK getPk() {
        return pk;
    }

    public void setPk(InformacionClientesPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
