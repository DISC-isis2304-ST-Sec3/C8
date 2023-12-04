package uniandes.edu.co.proyecto.modelo;

    public class ReservaResult {
    private String habitacion;
    private Double diasOcupacion;

    @Override
public String toString() {
    return "ReservaResult{" +
            "habitacion='" + habitacion + '\'' +
            ", diasOcupacion=" + diasOcupacion +
            '}';
}
    // Getters and setters
    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public Double getDiasOcupacion() {
        return diasOcupacion;
    }

    public void setDiasOcupacion(Double diasOcupacion) {
        this.diasOcupacion = diasOcupacion;
    }
}