package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UsuariosPK implements Serializable {

    private String tipo_documento;
    private Long num_documento;
    private String nombre;
    private String correo;

    public UsuariosPK() {
        super();
    }

    public UsuariosPK(String tipo_documento, Long num_documento, String nombre, String correo) {
        super();
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Long getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(Long num_documento) {
        this.num_documento = num_documento;
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
