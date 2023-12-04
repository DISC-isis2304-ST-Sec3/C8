package uniandes.edu.co.proyecto.modelo;

import org.bson.types.ObjectId;

public class ConsumoResult {
    private ObjectId habitacion;
    private Double totalDinero;

    // Getters and setters
    public ObjectId getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ObjectId habitacion) {
        this.habitacion = habitacion;
    }

    public Double getTotalDinero() {
        return totalDinero;
    }

    public void setTotalDinero(Double totalDinero) {
        this.totalDinero = totalDinero;
    }
}