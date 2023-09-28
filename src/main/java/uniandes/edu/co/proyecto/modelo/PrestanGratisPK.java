package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PrestanGratisPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "SalonesConferencia_id", referencedColumnName = "id")
    private SalonesConferencia SalonesConferencia_id;
    
    @ManyToOne
    @JoinColumn(name = "Equipos_id", referencedColumnName = "id")
    private Equipos Equipos_id;

    public PrestanGratisPK() {
        super();
    }

    public PrestanGratisPK(SalonesConferencia salonesConferencia_id, Equipos equipos_id) {
        super();
        SalonesConferencia_id = salonesConferencia_id;
        Equipos_id = equipos_id;
    }

    public SalonesConferencia getSalonesConferencia_id() {
        return SalonesConferencia_id;
    }

    public void setSalonesConferencia_id(SalonesConferencia salonesConferencia_id) {
        SalonesConferencia_id = salonesConferencia_id;
    }

    public Equipos getEquipos_id() {
        return Equipos_id;
    }

    public void setEquipos_id(Equipos equipos_id) {
        Equipos_id = equipos_id;
    }

    

}
