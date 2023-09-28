package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class TiposHabitacion {

    @Id
    private String tipo;

    private char jacuzzi;
    private char comedor;
    private char cocina;
    
    public TiposHabitacion(String tipo, char jacuzzi, char comedor, char cocina) {
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

    public char getJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(char jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public char getComedor() {
        return comedor;
    }

    public void setComedor(char comedor) {
        this.comedor = comedor;
    }

    public char getCocina() {
        return cocina;
    }

    public void setCocina(char cocina) {
        this.cocina = cocina;
    }

    
    
}
