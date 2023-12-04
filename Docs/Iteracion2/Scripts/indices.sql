CREATE
INDEX idx_consumos_tiposservicio 
ON consumos(tiposservicio_tipo);

CREATE
INDEX idx_consumos_fecha
ON consumos(fecha_consumo);

CREATE
INDEX idx_reservas_num_doc
ON reservas(usuarios_num_documento);

CREATE
INDEX idx_consumos_habitaciones_fecha
ON consumos(habitaciones_id, fecha_consumo);

CREATE
INDEX idx_consumos_habitaciones_fecha
ON consumos(habitaciones_id, fecha_consumo);

select*from consumos;
CREATE
INDEX idx_reservan_habitaciones_id
ON reservan(habitaciones_id);