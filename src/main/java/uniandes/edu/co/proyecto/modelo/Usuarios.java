package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @EmbeddedId
    private UsuariosPK pk;

    @ManyToOne
    @JoinColumn(name = "TiposUsuario_tipo", referencedColumnName = "tipo")
    private TiposUsuario TiposUsuario_tipo;

    public Usuarios(String tipo_documento, Long num_documento, String nombre, String correo,
            TiposUsuario TiposUsuario_tipo) {
        this.pk = new UsuariosPK(tipo_documento, num_documento, nombre, correo);
        this.TiposUsuario_tipo = TiposUsuario_tipo;
    }

    public Usuarios() {
        ;
    }

}
