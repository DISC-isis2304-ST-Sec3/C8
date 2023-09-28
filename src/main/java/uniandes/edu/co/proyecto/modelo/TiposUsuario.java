package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposusuario")
public class TiposUsuario {

    @Id
    private String tipo;

    public TiposUsuario(String tipo) {
        this.tipo = tipo;
    }

    public TiposUsuario() {
        ;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
