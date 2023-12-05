package uniandes.edu.co.proyecto.modelo;

import org.bson.types.ObjectId;

public class ConsumoResult {
    private String habitacion;
    private Double totalDinero;

    // Getters and setters
    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public Double getTotalDinero() {
        return totalDinero;
    }

    public void setTotalDinero(Double totalDinero) {
        this.totalDinero = totalDinero;
    }
}