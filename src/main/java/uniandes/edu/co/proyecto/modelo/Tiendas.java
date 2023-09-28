package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiendas")
public class Tiendas {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "TiposServicio_tipo", referencedColumnName = "tipo")
    private TiposServicio TiposServicio_tipo;

    private String tipo_tienda;

    public Tiendas() {
        ;
    }

    public Tiendas(int id, TiposServicio tiposServicio_tipo, String tipo_tienda) {
        this.id = id;
        TiposServicio_tipo = tiposServicio_tipo;
        this.tipo_tienda = tipo_tienda;
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

    public String getTipo_tienda() {
        return tipo_tienda;
    }

    public void setTipo_tienda(String tipo_tienda) {
        this.tipo_tienda = tipo_tienda;
    }



    

}
