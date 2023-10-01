package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasServicio")
public class ReservasServicio {
    @Id
    private int id;

    private int duracion_hora;
    private Date dia;
    private String hora;
    @ManyToOne
    @JoinColumn(name = "habitaciones_id", referencedColumnName = "id")
    private Habitaciones Habitaciones_id;

    public ReservasServicio() {
        ;
    }

    public ReservasServicio(int id, int duracion_hora, Date dia, String hora, Habitaciones habitaciones_id) {
        this.id = id;
        this.duracion_hora = duracion_hora;
        this.dia = dia;
        this.hora = hora;
        Habitaciones_id = habitaciones_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion_hora() {
        return duracion_hora;
    }

    public void setDuracion_hora(int duracion_hora) {
        this.duracion_hora = duracion_hora;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Habitaciones getHabitaciones_id() {
        return Habitaciones_id;
    }

    public void setHabitaciones_id(Habitaciones habitaciones_id) {
        Habitaciones_id = habitaciones_id;
    }

    

    

}
