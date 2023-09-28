package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicioslavanderia")
public class ServiciosLavanderia {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "TiposServicio_tipo", referencedColumnName = "tipo")
    private TiposServicio TiposServicio_tipo;

    private String tipo_prenda;
    private int cantidad_prendas;
    private double costo;

    public ServiciosLavanderia() {
        ;
    }

    public ServiciosLavanderia(int id, TiposServicio tiposServicio_tipo, String tipo_prenda, int cantidad_prendas,
            double costo) {
        this.id = id;
        TiposServicio_tipo = tiposServicio_tipo;
        this.tipo_prenda = tipo_prenda;
        this.cantidad_prendas = cantidad_prendas;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TiposServicio getTiposServicio_tipo() {
        return TiposServicio_tipo;
    }

    public void setTiposServicio_tipo(TiposServicio tiposServicio_tipo) {
        TiposServicio_tipo = tiposServicio_tipo;
    }

    public String getTipo_prenda() {
        return tipo_prenda;
    }

    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    public int getCantidad_prendas() {
        return cantidad_prendas;
    }

    public void setCantidad_prendas(int cantidad_prendas) {
        this.cantidad_prendas = cantidad_prendas;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }



    

}