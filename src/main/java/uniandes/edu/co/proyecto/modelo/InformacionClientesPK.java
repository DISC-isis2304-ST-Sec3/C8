package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class InformacionClientesPK implements Serializable {

    private String tipo_documento;
    private int num_documento;

    public InformacionClientesPK(String tipo_documento, int num_documento) {
        super();
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
    }

    public InformacionClientesPK() {
        super();
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(int num_documento) {
        this.num_documento = num_documento;
    }

}
