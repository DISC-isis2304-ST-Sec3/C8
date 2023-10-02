-- PRUEBAS DE UNICIDAD DE TUPLAS

-- Poblar para RF 1

INSERT INTO TiposUsuario (tipo)
VALUES ('cliente');

INSERT INTO TiposUsuario (tipo)
VALUES ('cliente');

-- Poblar para RF 2

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',12345678, 'Juan Perez', 'j.perez@gmail.com','gerente');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',12345678, 'Juan Perez', 'j.perez@gmail.com','gerente');

-- Poblar para RF 3

INSERT INTO TiposHabitacion (tipo, jacuzzi, comedor, cocina)
VALUES ('suite', 1, 0, 0);

INSERT INTO TiposHabitacion (tipo, jacuzzi, comedor, cocina)
VALUES ('suite', 1, 0, 0);


-- Poblar RF 5


INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('spa','Esto es un spa');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('bar','Esto es un bar');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('gimnasio','Esto es un gym');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('internet','Esto es el internet');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('lavadoSecadoEmbolado','Lave, seque o embole aca');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('piscina','Esto es una piscina');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('prestamo','Se prestan utensilios');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('restaurante','Esto es un restaurante');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('salon','Esto es un salon de reunion o conferencia');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('supermercado','Esto es un supermercado');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('tienda','Esto es una tienda');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('spa','Esto es un spa');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('bar','Esto es un bar');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('gimnasio','Esto es un gym');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('internet','Esto es el internet');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('lavadoSecadoEmbolado','Lave, seque o embole aca');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('piscina','Esto es una piscina');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('prestamo','Se prestan utensilios');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('restaurante','Esto es un restaurante');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('salon','Esto es un salon de reunion o conferencia');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('supermercado','Esto es un supermercado');

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('tienda','Esto es una tienda');


-- Poblar RF 6

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Estandar', 1, 350000, 0, 0, 0, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Larga estadia', 7, 3500000, 0.2, 0, 0, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Tiempo compartido', 7, 3500000, 0.2, 0.2, 0.2, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Todo incluido', 1, 4000000, 0, 1, 1, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Hiperahorro siempre', 20, 100000, 1, 1, 1, 1);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Estandar', 1, 350000, 0, 0, 0, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Larga estadia', 7, 3500000, 0.2, 0, 0, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Tiempo compartido', 7, 3500000, 0.2, 0.2, 0.2, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Todo incluido', 1, 4000000, 0, 1, 1, 0);

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('Hiperahorro siempre', 20, 100000, 1, 1, 1, 1);

-- Probar RF 7

INSERT INTO Reservas (fecha_inicio, fecha_salida, num_personas, Usuarios_tipo_documento, Usuarios_num_documento, Usuarios_correo, Usuarios_nombre, PlanesConsumo_id)
VALUES (TO_DATE('2023-12-01','YYYY-MM-DD'),TO_DATE('2023-12-11','YYYY-MM-DD'), 2, 'CE', 1765432, 'e.benitez@gmail.com', 'Eduardo benitez', 1);

INSERT INTO Reservan (Habitaciones_id, Reservas_id)
VALUES (1,1);

INSERT INTO Reservas (fecha_inicio, fecha_salida, num_personas, Usuarios_tipo_documento, Usuarios_num_documento, Usuarios_correo, Usuarios_nombre, PlanesConsumo_id)
VALUES (TO_DATE('2023-12-01','YYYY-MM-DD'),TO_DATE('2023-12-11','YYYY-MM-DD'), 2, 'CE', 1765432, 'e.benitez@gmail.com', 'Eduardo benitez', 1);

INSERT INTO Reservan (Habitaciones_id, Reservas_id)
VALUES (1,1);

-- Probar RF 8

INSERT INTO ReservasServicio (duracion_hora, dia, hora, Habitaciones_id)
VALUES ((SELECT duracion_min/60 FROM ServiciosSpa WHERE id = 1), TO_DATE('2023-12-04','YYYY-MM-DD'),'13:00:00',1);

INSERT INTO ReservasSpa (ReservasServicio_id, Spas_id)
VALUES (1,1);

INSERT INTO ReservasServicio (duracion_hora, dia, hora, Habitaciones_id)
VALUES ((SELECT duracion_min/60 FROM ServiciosSpa WHERE id = 1), TO_DATE('2023-12-04','YYYY-MM-DD'),'13:00:00',1);

INSERT INTO ReservasSpa (ReservasServicio_id, Spas_id)
VALUES (1,1);

-- Probar RF 9

INSERT INTO InformacionClientes (tipo_documento, num_documento, nombre, correo)
VALUES ('CE',1765432,'Eduardo benitez','e.benitez@gmail.com');

INSERT INTO CheckIn (Reservas_id, informacionclientes_num_documento, informacionclientes_tipo_documento, fecha_ingreso)
VALUES (1,1765432, 'CE',TO_DATE('2023-12-01','YYYY-MM-DD'));

INSERT INTO InformacionClientes (tipo_documento, num_documento, nombre, correo)
VALUES ('CE',1765432,'Eduardo benitez','e.benitez@gmail.com');

INSERT INTO CheckIn (Reservas_id, informacionclientes_num_documento, informacionclientes_tipo_documento, fecha_ingreso)
VALUES (1,1765432, 'CE',TO_DATE('2023-12-01','YYYY-MM-DD'));


-- Prueba RF 10 

INSERT INTO Consumos (Habitaciones_id, TiposServicio_tipo, descripcion, costo)
VALUES (1, 'spa', 'Eduardo Benitez se hizo un masaje', (SELECT costo FROM ServiciosSpa WHERE id = 1));

-- Prueba RF 11

INSERT INTO CheckOuts (reservas_id, Habitaciones_id, fecha_salida)
VALUES (1, 1, TO_DATE('2023-12-11','YYYY-MM-DD'));


-- PRUEBAS DE INTEGRIDAD

DELETE FROM TIPOSUSUARIO;
DELETE FROM USUARIOS;
DELETE FROM TIPOSHABITACION;
DELETE FROM HABITACIONES;
DELETE FROM PLANESCONSUMO;
DELETE FROM CHECKOUT;

INSERT INTO ReservasSpa (ReservasServicio_id, Spas_id)
VALUES (0,0);

INSERT INTO Reservan (Habitaciones_id, Reservas_id)
VALUES (0,0);

INSERT INTO CheckOuts (reservas_id, Habitaciones_id, fecha_salida)
VALUES (0, 1, TO_DATE('2023-12-11','YYYY-MM-DD'));

INSERT INTO Consumos (Habitaciones_id, TiposServicio_tipo, descripcion, costo)
VALUES (0, 'spa', 'Eduardo Benitez se hizo un masaje', (SELECT costo FROM ServiciosSpa WHERE id = 1));

INSERT INTO TiposServicio (tipo, descripcion)
VALUES ('algoraro','Esto es un spa');

-- PRUEBAS DE INTEGRGIDAD EN CHECK

INSERT INTO TiposUsuario (tipo)
VALUES (NULL);

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES (NULL,12345678, 'Juan Perez', 'j.perez@gmail.com','gerente');

INSERT INTO PlanesConsumo (nombre,estadia_min, costo, desc_reserva, desc_bar, desc_restaurante, desc_servicio)
VALUES ('siempre', 20, 100000, 11, 11, 11, 11);

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('NUMERO DOC',12345678, 'Juan Perez', 'j.perez@gmail.com','gerente');


