package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PrestanAdicionalPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "SalonesReunion_id", referencedColumnName = "id")
    private SalonesReunion SalonesReunion_id;
    
    @ManyToOne
    @JoinColumn(name = "Equipos_id", referencedColumnName = "id")
    private Equipos Equipos_id;


    public PrestanAdicionalPK() {
        super();
    }


    public PrestanAdicionalPK(SalonesReunion salonesReunion_id, Equipos equipos_id) {
        super();
        SalonesReunion_id = salonesReunion_id;
        Equipos_id = equipos_id;
    }


    public SalonesReunion getSalonesReunion_id() {
        return SalonesReunion_id;
    }


    public void setSalonesReunion_id(SalonesReunion salonesReunion_id) {
        SalonesReunion_id = salonesReunion_id;
    }


    public Equipos getEquipos_id() {
        return Equipos_id;
    }


    public void setEquipos_id(Equipos equipos_id) {
        Equipos_id = equipos_id;
    }

    

}
