package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "maquinas")
public class Maquinas {

    @Id
    private int id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "Gimnasios_id", referencedColumnName = "id")
    private Gimnasios Gimnasios_id;

    public Maquinas() {
        ;
    }

    public Maquinas(int id, String nombre, Gimnasios gimnasios_id) {
        this.id = id;
        this.nombre = nombre;
        Gimnasios_id = gimnasios_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Gimnasios getGimnasios_id() {
        return Gimnasios_id;
    }

    public void setGimnasios_id(Gimnasios gimnasios_id) {
        Gimnasios_id = gimnasios_id;
    }



    
}
