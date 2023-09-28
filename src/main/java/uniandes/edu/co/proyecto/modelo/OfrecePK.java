package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OfrecePK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "Spas_id", referencedColumnName = "id")
    private Spas Spas_id;
    
    @ManyToOne
    @JoinColumn(name = "ServiciosSpa_id", referencedColumnName = "id")
    private ServiciosSpa ServiciosSpa_id;

    public OfrecePK() {
        super();
    }

    public OfrecePK(Spas spas_id, ServiciosSpa serviciosSpa_id) {
        super();
        Spas_id = spas_id;
        ServiciosSpa_id = serviciosSpa_id;
    }

    public Spas getSpas_id() {
        return Spas_id;
    }

    public void setSpas_id(Spas spas_id) {
        Spas_id = spas_id;
    }

    public ServiciosSpa getServiciosSpa_id() {
        return ServiciosSpa_id;
    }

    public void setServiciosSpa_id(ServiciosSpa serviciosSpa_id) {
        ServiciosSpa_id = serviciosSpa_id;
    }

    

}
