package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reservas {

    @Id
    private int id;

    private Date fecha_inicio;
    private Date fecha_salida;
    private int num_personas;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Usuarios_tipo_documento", referencedColumnName = "tipo_documento"),
            @JoinColumn(name = "Usuarios_num_documento", referencedColumnName = "num_documento"),
            @JoinColumn(name = "Usuarios_nombre", referencedColumnName = "nombre"),
            @JoinColumn(name = "Usuarios_correo", referencedColumnName = "correo")
    })
    private Usuarios usuariosPK;

    @ManyToOne
    @JoinColumn(name = "PLANESCONSUMO_ID", referencedColumnName = "id")
    private PlanesConsumo PlanesConsumo_id;

    public Reservas(int id, Date fecha_inicio, Date fecha_salida, int num_personas, Usuarios usuariosPK,
            PlanesConsumo planesConsumo_id) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_salida = fecha_salida;
        this.num_personas = num_personas;
        this.usuariosPK = usuariosPK;
        this.PlanesConsumo_id = planesConsumo_id;
    }

    public Reservas() {
        ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getNum_personas() {
        return num_personas;
    }

    public void setNum_personas(int num_personas) {
        this.num_personas = num_personas;
    }

    public Usuarios getUsuariosPK() {
        return usuariosPK;
    }

    public void setUsuariosPK(Usuarios usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public PlanesConsumo getPlanesConsumo_id() {
        return PlanesConsumo_id;
    }

    public void setPlanesConsumo_id(PlanesConsumo planesConsumo_id) {
        PlanesConsumo_id = planesConsumo_id;
    }

}
