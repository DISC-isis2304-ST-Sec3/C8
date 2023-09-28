package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestanadicional")
public class PrestanAdicional {

    @EmbeddedId
    private PrestanAdicionalPK pk;

    private double costo;

    public PrestanAdicional() {
        ;
    }

    public PrestanAdicional(SalonesReunion salonesReunion_id, Equipos equipos_id, double costo) {
        this.pk = new PrestanAdicionalPK(salonesReunion_id, equipos_id);
        this.costo = costo;
    }

    public PrestanAdicionalPK getPk() {
        return pk;
    }

    public void setPk(PrestanAdicionalPK pk) {
        this.pk = pk;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    
    
}
