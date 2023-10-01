package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "checkin")
public class CheckIn {

        @EmbeddedId
        private CheckInPK pk;

        private Date fecha_ingreso;

        public CheckIn(Reservas reservas_id, int informacionclientes_num_documento, String informacionclientes_tipo_documento, Date fecha_ingreso) {
            InformacionClientes informacionClientesPK = new InformacionClientes();
            informacionClientesPK.setPk(new InformacionClientesPK(informacionclientes_tipo_documento, informacionclientes_num_documento));
            this.pk = new CheckInPK(reservas_id, informacionClientesPK);
            this.fecha_ingreso = fecha_ingreso;
        }
        

        public CheckIn() {
            ;
        }

        public CheckInPK getPk() {
            return pk;
        }

        public void setPk(CheckInPK pk) {
            this.pk = pk;
        }

        public Date getFecha_ingreso() {
            return fecha_ingreso;
        }

        public void setFecha_ingreso(Date fecha_ingreso) {
            this.fecha_ingreso = fecha_ingreso;
        }

        

}
