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
    @JoinColumn(name = "TIPOSUSUARIO_TIPO", referencedColumnName = "tipo")
    private TiposUsuario TiposUsuario_tipo;

    public Usuarios(String tipo_documento, Long num_documento, String nombre, String correo,
            TiposUsuario TiposUsuario_tipo) {
        this.pk = new UsuariosPK(tipo_documento, num_documento, nombre, correo);
        this.TiposUsuario_tipo = TiposUsuario_tipo;
    }

    public Usuarios() {
        ;
    }

    public UsuariosPK getPk() {
        return pk;
    }

    public void setPk(UsuariosPK pk) {
        this.pk = pk;
    }

    public TiposUsuario getTiposUsuario_tipo() {
        return TiposUsuario_tipo;
    }

    public void setTiposUsuario_tipo(TiposUsuario tiposUsuario_tipo) {
        TiposUsuario_tipo = tiposUsuario_tipo;
    }

    

}
