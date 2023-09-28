package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestangratis")
public class PrestanGratis {
    @EmbeddedId
    private PrestanGratisPK pk;

    public PrestanGratis() {
        ;
    }

    public PrestanGratis(SalonesConferencia salonesConferencia_id, Equipos equipos_id) {
        this.pk = new PrestanGratisPK(salonesConferencia_id, equipos_id);
    }

    public PrestanGratisPK getPk() {
        return pk;
    }

    public void setPk(PrestanGratisPK pk) {
        this.pk = pk;
    }
    
}
