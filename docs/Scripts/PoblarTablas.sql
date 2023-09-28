-- Poblar para RF 1

INSERT INTO TiposUsuario (tipo)
VALUES ('cliente');

INSERT INTO TiposUsuario (tipo)
VALUES ('recepcionista');

INSERT INTO TiposUsuario (tipo)
VALUES ('empleado');

INSERT INTO TiposUsuario (tipo)
VALUES ('administrador');

INSERT INTO TiposUsuario (tipo)
VALUES ('gerente');

-- Poblar para RF 2

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',12345678, 'Juan Perez', 'j.perez@gmail.com','gerente');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',87654321, 'Tatiana Lopez', 't.lopez@gmail.com','administrador');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',11111111, 'Jose Rodriguez', 'j.rodriguez@gmail.com','recepcionista');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',22222222, 'Jhon Doe', 'j.doe@gmail.com','recepcionista');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',333333333, 'Ricardo Ardila', 'r.ardila@gmail.com','empleado');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',111111112, 'Susana Cardona', 's.cardona@gmail.com','empleado');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',1928376, 'Adriana Macera', 'a.macera@gmail.com','empleado');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CC',1653745, 'Armando Paredes', 'a.paredes@gmail.com','empleado');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CE',1765432, 'Eduardo benitez', 'e.benitez@gmail.com','cliente');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('pasaporte',1786523, 'Leonardo Villegas', 'l.villegas@gmail.com','cliente');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('CIF',12333333, 'Gloria Trevi', 'g.trevi@gmail.com','cliente');

INSERT INTO Usuarios (tipo_documento, num_documento, nombre, correo, TiposUsuario_tipo)
VALUES ('TI',204812, 'Doris Rodriguez', 'd.rodriguez@gmail.com','cliente');

-- Poblar para RF 3

INSERT INTO TiposHabitacion (tipo, jacuzzi, comedor, cocina)
VALUES ('suite', 1, 0, 0);

INSERT INTO TiposHabitacion (tipo, jacuzzi, comedor, cocina)
VALUES ('familiar', 0, 1, 1);

INSERT INTO TiposHabitacion (tipo, jacuzzi, comedor, cocina)
VALUES ('doble', 1, 0, 0);

-- Poblar RF 4

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (4, 700000, 'suite');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (4, 700000, 'suite');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (4, 700000, 'suite');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (8, 480000, 'familiar');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (7, 470000, 'familiar');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (6, 460000, 'familiar');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (4, 480000, 'doble');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (4, 470000, 'doble');

INSERT INTO Habitaciones (capacidad, costo, TiposHabitacion_tipo)
VALUES (4, 460000, 'doble');

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

-- Poblar la BD de cada servicio

INSERT INTO Utensilios (nombre, costo)
VALUES ('toalla', 70000);

INSERT INTO Utensilios (nombre, costo)
VALUES ('toalla', 70000);

INSERT INTO Utensilios (nombre, costo)
VALUES ('toalla', 70000);

INSERT INTO ServiciosPrestamo (cantidad, devuelto, TiposServicio_tipo)
VALUES (1, 0, 'prestamo');

INSERT INTO ServiciosPrestamo (cantidad, devuelto, TiposServicio_tipo)
VALUES (1, 0, 'prestamo');

INSERT INTO Presta (ServiciosPrestamo_id, Utensilios_id)
VALUES (1,1);

INSERT INTO ServiciosLavanderia (tipo_prenda, cantidad_prendas, costo, TiposServicio_tipo)
VALUES ('camisa_lavar', 1, 15000, 'lavadoSecadoEmbolado');

INSERT INTO ServiciosLavanderia (tipo_prenda, cantidad_prendas, costo, TiposServicio_tipo)
VALUES ('camisa_lavar', 2, 25000, 'lavadoSecadoEmbolado');

INSERT INTO ServiciosLavanderia (tipo_prenda, cantidad_prendas, costo, TiposServicio_tipo)
VALUES ('zapato_embolar', 2, 5000, 'lavadoSecadoEmbolado');

INSERT INTO ServiciosLavanderia (tipo_prenda, cantidad_prendas, costo, TiposServicio_tipo)
VALUES ('camisa_secar', 2, 25000, 'lavadoSecadoEmbolado');

INSERT INTO Internets (capacidad, costo_dia, TiposServicio_tipo)
VALUES (6000, 25000, 'internet');

INSERT INTO ProductosSuper (nombre, precio)
VALUES ('CocaCola', 2500);

INSERT INTO ProductosSuper (nombre, precio)
VALUES ('Papas margarita', 2800);

INSERT INTO ProductosSuper (nombre, precio)
VALUES ('Chicles trident', 2000);

INSERT INTO Supermercados (nombre, TiposServicio_tipo)
VALUES ('surtimax premium', 'supermercado');

INSERT INTO Supermercados (nombre, TiposServicio_tipo)
VALUES ('carulla premium', 'supermercado');

INSERT INTO VendenSuper (Supermercados_id, ProductosSuper_id)
VALUES (1,1);

INSERT INTO VendenSuper (Supermercados_id, ProductosSuper_id)
VALUES (1,2);

INSERT INTO VendenSuper (Supermercados_id, ProductosSuper_id)
VALUES (2,1);

INSERT INTO VendenSuper (Supermercados_id, ProductosSuper_id)
VALUES (2,2);

INSERT INTO VendenSuper (Supermercados_id, ProductosSuper_id)
VALUES (2,3);

INSERT INTO Productostienda (nombre, precio)
VALUES ('Camiseta', 2500);

INSERT INTO ProductosTienda (nombre, precio)
VALUES ('Gafas', 2800);

INSERT INTO ProductosTienda (nombre, precio)
VALUES ('Gorra', 2000);

INSERT INTO Tiendas (tipo_tienda, TiposServicio_tipo)
VALUES ('boutique 1', 'tienda');

INSERT INTO VendenTienda (Tiendas_id, ProductosTienda_id)
VALUES (1,1);

INSERT INTO VendenTienda (Tiendas_id, ProductosTienda_id)
VALUES (1,2);

INSERT INTO VendenTienda (Tiendas_id, ProductosTienda_id)
VALUES (1,3);

INSERT INTO ProductosRestaurante (nombre, precio)
VALUES ('Pollo', 20500);

INSERT INTO ProductosRestaurante (nombre, precio)
VALUES ('Hamburguesa', 20800);

INSERT INTO ProductosRestaurante (nombre, precio)
VALUES ('Sufle de papa', 20000);

INSERT INTO ProductosRestaurante (nombre, precio)
VALUES ('Pizza', 30000);

INSERT INTO Restaurantes (capacidad, estilo, TiposServicio_tipo)
VALUES (50, 'internacional', 'restaurante');

INSERT INTO Restaurantes (capacidad, estilo, TiposServicio_tipo)
VALUES (20, 'italiano', 'restaurante');

INSERT INTO Sirven_res (Restaurantes_id, ProductosRestaurante_id)
VALUES (1,1);

INSERT INTO Sirven_res (Restaurantes_id, ProductosRestaurante_id)
VALUES (1,2);

INSERT INTO Sirven_res (Restaurantes_id, ProductosRestaurante_id)
VALUES (2,3);

INSERT INTO Sirven_res (Restaurantes_id, ProductosRestaurante_id)
VALUES (2,4);

INSERT INTO ProductosBar (nombre, precio)
VALUES ('Margarita', 20500);

INSERT INTO ProductosBar (nombre, precio)
VALUES ('Aguardiente amarillo', 20800);

INSERT INTO ProductosBar (nombre, precio)
VALUES ('Tequila', 20000);

INSERT INTO ProductosBar (nombre, precio)
VALUES ('Vino', 30000);

INSERT INTO Bares (capacidad, estilo, TiposServicio_tipo)
VALUES (50, 'rancheras', 'bar');

INSERT INTO Bares (capacidad, estilo, TiposServicio_tipo)
VALUES (20, 'jazz', 'bar');

INSERT INTO Sirven_bar (Bares_id, ProductosBar_id)
VALUES (1,2);

INSERT INTO Sirven_bar (Bares_id, ProductosBar_id)
VALUES (1,3);

INSERT INTO Sirven_bar (Bares_id, ProductosBar_id)
VALUES (1,4);

INSERT INTO Sirven_bar (Bares_id, ProductosBar_id)
VALUES (2,1);

INSERT INTO Sirven_bar (Bares_id, ProductosBar_id)
VALUES (2,2);

INSERT INTO Sirven_bar (Bares_id, ProductosBar_id)
VALUES (2,4);

INSERT INTO Gimnasios (capacidad, hora_inicio, hora_fin, TiposServicio_tipo)
VALUES (50, '08:00:00', '19:00:00', 'gimnasio');

INSERT INTO Gimnasios (capacidad, hora_inicio, hora_fin, TiposServicio_tipo)
VALUES (20, '10:00:00', '15:00:00', 'gimnasio');

INSERT INTO Maquinas (nombre, Gimnasios_id)
VALUES ('Mancuerna',1);

INSERT INTO Maquinas (nombre, Gimnasios_id)
VALUES ('Mancuerna',2);

INSERT INTO Maquinas (nombre, Gimnasios_id)
VALUES ('Caminadora',1);

INSERT INTO Maquinas (nombre, Gimnasios_id)
VALUES ('Bicicleta estatica',2);

INSERT INTO Piscinas (profundidad_m, capacidad, hora_inicio, hora_fin, TiposServicio_tipo)
VALUES (1.58, 50, '08:00:00', '20:00:00', 'piscina');

INSERT INTO Piscinas (profundidad_m, capacidad, hora_inicio, hora_fin, TiposServicio_tipo)
VALUES (1.80, 30, '08:00:00', '18:00:00', 'piscina');

INSERT INTO Spas (capacidad, TiposServicio_tipo)
VALUES (10, 'spa');

INSERT INTO ServiciosSpa (nombre, costo, duracion_min)
VALUES ('masaje', 150000, 120);

INSERT INTO ServiciosSpa (nombre, costo, duracion_min)
VALUES ('chocolaterapia', 450000, 180);

INSERT INTO Ofrece (Spas_id, ServiciosSpa_id)
VALUES (1,1);

INSERT INTO Ofrece (Spas_id, ServiciosSpa_id)
VALUES (1,2);

INSERT INTO SalonesReunion (capacidad, costo_hora, TiposServicio_tipo )
VALUES (12,100000, 'salon');

INSERT INTO SalonesReunion (capacidad, costo_hora, TiposServicio_tipo )
VALUES (11,100000, 'salon');

INSERT INTO SalonesReunion (capacidad, costo_hora, TiposServicio_tipo )
VALUES (10,100000, 'salon');

INSERT INTO SalonesConferencia (capacidad, costo_hora, TiposServicio_tipo )
VALUES (112,100000, 'salon');

INSERT INTO SalonesConferencia (capacidad, costo_hora, TiposServicio_tipo )
VALUES (111,100000, 'salon');

INSERT INTO SalonesConferencia (capacidad, costo_hora, TiposServicio_tipo )
VALUES (110,100000, 'salon');

INSERT INTO SalonesReunion (capacidad, costo_hora, TiposServicio_tipo )
VALUES (12,100000, 'salon');

INSERT INTO SalonesReunion (capacidad, costo_hora, TiposServicio_tipo )
VALUES (11,100000, 'salon');

INSERT INTO Equipos (nombre)
VALUES ('proyector');

INSERT INTO Equipos (nombre)
VALUES ('televisor');

INSERT INTO Equipos (nombre)
VALUES ('modulo de computadores');

INSERT INTO PrestanGratis (SalonesConferencia_id, Equipos_id)
VALUES (1,1);

INSERT INTO PrestanGratis (SalonesConferencia_id, Equipos_id)
VALUES (2,1);

INSERT INTO PrestanGratis (SalonesConferencia_id, Equipos_id)
VALUES (3,1);

INSERT INTO PrestanAdicional (SalonesReunion_id, Equipos_id, costo)
VALUES (2,1,150000);

INSERT INTO PrestanAdicional (SalonesReunion_id, Equipos_id, costo)
VALUES (3,2,150000);

INSERT INTO PrestanAdicional (SalonesReunion_id, Equipos_id, costo)
VALUES (1,3,150000);

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

-- Probar RF 7

INSERT INTO Reservas (fecha_inicio, fecha_salida, num_personas, Usuarios_tipo_documento, Usuarios_num_documento, Usuarios_correo, Usuarios_nombre, PlanesConsumo_id)
VALUES (TO_DATE('2023-12-01','YYYY-MM-DD'),TO_DATE('2023-12-11','YYYY-MM-DD'), 2, 'CE', 1765432, 'e.benitez@gmail.com', 'Eduardo benitez', 1);

INSERT INTO Reservan (Habitaciones_id, Reservas_id)
VALUES (1,1);

-- Probar RF 8

INSERT INTO ReservasServicio (duracion_hora, dia, hora, Habitaciones_id)
VALUES ((SELECT duracion_min/60 FROM ServiciosSpa WHERE id = 1), TO_DATE('2023-12-04','YYYY-MM-DD'),'13:00:00',1);

INSERT INTO ReservasSpa (ReservasServicio_id, Spas_id)
VALUES (1,1);

-- Probar RF 9

INSERT INTO InformacionClientes (tipo_documento, num_documento, nombre, correo)
VALUES ('CE',1765432,'Eduardo benitez','e.benitez@gmail.com');

INSERT INTO InformacionClientes (tipo_documento, num_documento, nombre, correo)
VALUES ('CE',12245688,'Tatiana benitez','t.benitez@gmail.com');

INSERT INTO CheckIn (Reservas_id, informacionclientes_num_documento, informacionclientes_tipo_documento, fecha_ingreso)
VALUES (1,1765432, 'CE',TO_DATE('2023-12-01','YYYY-MM-DD'));

INSERT INTO CheckIn (Reservas_id, informacionclientes_num_documento, informacionclientes_tipo_documento, fecha_ingreso)
VALUES (1,12245688, 'CE',TO_DATE('2023-12-01','YYYY-MM-DD'));

-- Prueba RF 10 

INSERT INTO Consumos (Habitaciones_id, TiposServicio_tipo, descripcion, costo)
VALUES (1, 'spa', 'Eduardo Benitez se hizo un masaje', (SELECT costo FROM ServiciosSpa WHERE id = 1));

-- Prueba RF 11

INSERT INTO CheckOuts (reservas_id, Habitaciones_id, fecha_salida)
VALUES (1, 1, TO_DATE('2023-12-11','YYYY-MM-DD'));


















