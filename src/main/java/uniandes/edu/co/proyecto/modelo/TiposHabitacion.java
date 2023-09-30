package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposhabitacion")
public class TiposHabitacion {

    @Id
    private String tipo;

    private int jacuzzi;
    private int comedor;
    private int cocina;
    
    public TiposHabitacion(String tipo, int jacuzzi, int comedor, int cocina) {
        this.tipo = tipo;
        this.jacuzzi = jacuzzi;
        this.comedor = comedor;
        this.cocina = cocina;
    }

    public TiposHabitacion() {
        ;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(int jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public int getComedor() {
        return comedor;
    }

    public void setComedor(int comedor) {
        this.comedor = comedor;
    }

    public int getCocina() {
        return cocina;
    }

    public void setCocina(int cocina) {
        this.cocina = cocina;
    }

    
    
}
