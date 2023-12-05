package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class ReservaConsumo {
    @Field("numDocumento")
    private String numDocumento;
    
    @Field("fechaConsumo")
    private Date fechaConsumo;

    @Field("tipoServicio")
    private String tipoServicio;

    @Field("servicio")
    private String servicio;

    
    public ReservaConsumo(String numDocumento, Date fechaConsumo, String tipoServicio, String servicio) {
        this.numDocumento = numDocumento;
        this.fechaConsumo = fechaConsumo;
        this.tipoServicio = tipoServicio;
        this.servicio = servicio;
    }

    public ReservaConsumo() {
    }

    // Getters and setters

    public String getNumDocumento() {
        return this.numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Date getFechaConsumo() {
        return this.fechaConsumo;
    }

    public void setFechaConsumo(Date fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public String getTipoServicio() {
        return this.tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getServicio() {
        return this.servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
