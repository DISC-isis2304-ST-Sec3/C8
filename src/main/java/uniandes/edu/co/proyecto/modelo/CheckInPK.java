package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CheckInPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Reservas_id", referencedColumnName = "id")
    private Reservas Reservas_id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Usuarios_tipo_documento", referencedColumnName = "tipo_documento"),
            @JoinColumn(name = "Usuarios_num_documento", referencedColumnName = "num_documento"),
    })
    private InformacionClientes informacionClientesPK;

    public CheckInPK() { 
        super();
    }

    public CheckInPK(Reservas reservas_id, InformacionClientes informacionClientesPK) {
        super();
        this.Reservas_id = reservas_id;
        this.informacionClientesPK = informacionClientesPK;
    }

    public Reservas getReservas_id() {
        return Reservas_id;
    }

    public void setReservas_id(Reservas reservas_id) {
        Reservas_id = reservas_id;
    }

    public InformacionClientes getInformacionClientesPK() {
        return informacionClientesPK;
    }

    public void setInformacionClientesPK(InformacionClientes informacionClientesPK) {
        this.informacionClientesPK = informacionClientesPK;
    } 

}
