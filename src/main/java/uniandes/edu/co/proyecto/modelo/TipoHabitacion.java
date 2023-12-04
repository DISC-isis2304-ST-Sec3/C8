
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tiposHabitacion")
public class TipoHabitacion {
    @Id
    private String id;

    @Field("tipo")
    private String tipo;

    @Field("jacuzzi")
    private boolean jacuzzi;

    @Field("comedor")
    private boolean comedor;

    @Field("cocina")
    private boolean cocina;

    public TipoHabitacion(){
    }

    public TipoHabitacion(String tipo, boolean jacuzzi, boolean comedor, boolean cocina){
        this.tipo = tipo;
        this.jacuzzi = jacuzzi;
        this.comedor = comedor;
        this.cocina = cocina;
    }
    

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean getJacuzzi() {
        return jacuzzi;
    }
    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }
    public boolean getComedor() {
        return comedor;
    }
    public void setComedor(boolean comedor) {
        this.comedor = comedor;
    }
    public boolean getCocina() {
        return cocina;
    }
    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }
    public String getId(){
        return id;
    }
}