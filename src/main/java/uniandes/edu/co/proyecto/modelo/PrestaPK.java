package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PrestaPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "ServiciosPrestamo_id", referencedColumnName = "id")
    private ServiciosPrestamo ServiciosPrestamo_id;
    
    @ManyToOne
    @JoinColumn(name = "Utensilios_id", referencedColumnName = "id")
    private Utensilios Utensilios_id;

    public PrestaPK() {
        super();
    }

    public PrestaPK(ServiciosPrestamo serviciosPrestamo_id, Utensilios utensilios_id) {
        ServiciosPrestamo_id = serviciosPrestamo_id;
        Utensilios_id = utensilios_id;
    }

    public ServiciosPrestamo getServiciosPrestamo_id() {
        return ServiciosPrestamo_id;
    }

    public void setServiciosPrestamo_id(ServiciosPrestamo serviciosPrestamo_id) {
        ServiciosPrestamo_id = serviciosPrestamo_id;
    }

    public Utensilios getUtensilios_id() {
        return Utensilios_id;
    }

    public void setUtensilios_id(Utensilios utensilios_id) {
        Utensilios_id = utensilios_id;
    }

    

    

}
