CREATE TABLE bares (
    id                 INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    estilo             VARCHAR2(255 BYTE) NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( id );

CREATE TABLE checkin (
    reservas_id                        INTEGER NOT NULL, 
    informacionclientes_num_documento  INTEGER NOT NULL,  
    informacionclientes_tipo_documento VARCHAR2(255 BYTE) NOT NULL,
    fecha_ingreso                      DATE NOT NULL
);

ALTER TABLE checkin
    ADD CONSTRAINT checkin_pk PRIMARY KEY ( reservas_id,
                                            informacionclientes_num_documento,
                                            informacionclientes_tipo_documento );

CREATE TABLE checkouts (
    reservas_id     INTEGER NOT NULL,
    habitaciones_id INTEGER NOT NULL,
    fecha_salida    DATE NOT NULL
);

ALTER TABLE checkouts ADD CONSTRAINT checkouts_pk PRIMARY KEY ( reservas_id,
                                                                habitaciones_id );

CREATE TABLE consumos (
    habitaciones_id    INTEGER NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL,
    descripcion        VARCHAR2(510) DEFAULT '""',
    costo              NUMBER DEFAULT 0 NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( habitaciones_id,
                                                              tiposservicio_tipo );

CREATE TABLE equipos (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE equipos ADD CONSTRAINT equipos_pk PRIMARY KEY ( id );

CREATE TABLE gimnasios (
    id                 INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    hora_inicio        VARCHAR2(255 BYTE) NOT NULL,
    hora_fin           VARCHAR2(255 BYTE) NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( id );

CREATE TABLE habitaciones (
    id                   INTEGER NOT NULL,
    capacidad            INTEGER NOT NULL,
    costo                NUMBER NOT NULL,
    tiposhabitacion_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id );

CREATE TABLE informacionclientes (
    tipo_documento VARCHAR2(255 BYTE) NOT NULL,
    num_documento  INTEGER NOT NULL,
    nombre         VARCHAR2(255 BYTE) NOT NULL,
    correo         VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE informacionclientes
    ADD CONSTRAINT ck_tipo CHECK ( tipo_documento IN ( 'CC', 'CE', 'CIF', 'TI', 'pasaporte' ) );

ALTER TABLE informacionclientes ADD CONSTRAINT informacionclientes_pk PRIMARY KEY ( num_documento,
                                                                                    tipo_documento );

CREATE TABLE internets (
    id                 INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    costo_dia          NUMBER,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE internets ADD CONSTRAINT internets_pk PRIMARY KEY ( id );

CREATE TABLE maquinas (
    id_maquina   INTEGER NOT NULL,
    nombre       VARCHAR2(255 BYTE) NOT NULL,
    gimnasios_id INTEGER NOT NULL
);

ALTER TABLE maquinas ADD CONSTRAINT maquinas_pk PRIMARY KEY ( id_maquina );

CREATE TABLE ofrece (
    spas_id         INTEGER NOT NULL,
    serviciosspa_id INTEGER NOT NULL
);

ALTER TABLE ofrece ADD CONSTRAINT ofrece_pk PRIMARY KEY ( spas_id,
                                                          serviciosspa_id );

CREATE TABLE piscinas (
    id                 INTEGER NOT NULL,
    profundidad_m      INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    hora_inicio        VARCHAR2(255 BYTE) NOT NULL,
    hora_fin           VARCHAR2(255 BYTE) NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( id );

CREATE TABLE planesconsumo (
    id               INTEGER NOT NULL,
    nombre           VARCHAR2(255 BYTE) NOT NULL,
    estadia_min      INTEGER DEFAULT 0 NOT NULL,
    costo            NUMBER NOT NULL,
    desc_reserva     NUMBER DEFAULT 0 NOT NULL,
    desc_bar         NUMBER DEFAULT 0 NOT NULL,
    desc_restaurante NUMBER DEFAULT 0 NOT NULL,
    desc_servicio    NUMBER DEFAULT 0 NOT NULL
);

ALTER TABLE planesconsumo ADD CHECK ( desc_reserva BETWEEN 0 AND 1 );

ALTER TABLE planesconsumo ADD CHECK ( desc_bar BETWEEN 0 AND 1 );

ALTER TABLE planesconsumo ADD CHECK ( desc_restaurante BETWEEN 0 AND 1 );

ALTER TABLE planesconsumo ADD CHECK ( desc_servicio BETWEEN 0 AND 1 );

ALTER TABLE planesconsumo ADD CONSTRAINT planesconsumo_pk PRIMARY KEY ( id );

CREATE TABLE presta (
    serviciosprestamo_id INTEGER NOT NULL,
    utensilios_id        INTEGER NOT NULL
);

ALTER TABLE presta ADD CONSTRAINT presta_pk PRIMARY KEY ( serviciosprestamo_id,
                                                          utensilios_id );

CREATE TABLE prestanadicional (
    salonesreunion_id INTEGER NOT NULL,
    equipos_id        INTEGER NOT NULL,
    costo             NUMBER NOT NULL
);

ALTER TABLE prestanadicional ADD CONSTRAINT prestanadicional_pk PRIMARY KEY ( salonesreunion_id,
                                                                              equipos_id );

CREATE TABLE prestangratis (
    salonesconferencia_id INTEGER NOT NULL,
    equipos_id            INTEGER NOT NULL
);

ALTER TABLE prestangratis ADD CONSTRAINT prestangratis_pk PRIMARY KEY ( salonesconferencia_id,
                                                                        equipos_id );

CREATE TABLE productosbar (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productosbar ADD CONSTRAINT productosbar_pk PRIMARY KEY ( id );

CREATE TABLE productosrestaurante (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productosrestaurante ADD CONSTRAINT productosrestaurante_pk PRIMARY KEY ( id );

CREATE TABLE productossuper (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productossuper ADD CONSTRAINT productossuper_pk PRIMARY KEY ( id );

CREATE TABLE productostienda (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    precio NUMBER NOT NULL
);

ALTER TABLE productostienda ADD CONSTRAINT productostienda_pk PRIMARY KEY ( id );

CREATE TABLE reservan (
    habitaciones_id INTEGER NOT NULL,
    reservas_id     INTEGER NOT NULL
);

ALTER TABLE reservan ADD CONSTRAINT reservan_pk PRIMARY KEY ( habitaciones_id,
                                                              reservas_id );

CREATE TABLE reservas (
    id                      INTEGER NOT NULL,
    fecha_inicio            DATE NOT NULL,
    fecha_salida            DATE NOT NULL,
    num_personas            INTEGER NOT NULL,
    usuarios_num_documento  NUMBER NOT NULL,
    usuarios_correo         VARCHAR2(255 BYTE) NOT NULL,
    usuarios_nombre         VARCHAR2(255 BYTE) NOT NULL,
    planesconsumo_id        INTEGER NOT NULL,
    usuarios_tipo_documento VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE reservas ADD CHECK ( num_personas BETWEEN 1 AND 100 );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE reservassalonconferencia (
    reservasservicio_id   INTEGER NOT NULL,
    salonesconferencia_id INTEGER NOT NULL
);

ALTER TABLE reservassalonconferencia ADD CONSTRAINT reservassalonconferencia_pk PRIMARY KEY ( reservasservicio_id,
                                                                                              salonesconferencia_id );

CREATE TABLE reservassalonreunion (
    reservasservicio_id INTEGER NOT NULL,
    salonesreunion_id   INTEGER NOT NULL
);

ALTER TABLE reservassalonreunion ADD CONSTRAINT reservassalonreunion_pk PRIMARY KEY ( reservasservicio_id,
                                                                                      salonesreunion_id );

CREATE TABLE reservasservicio (
    id              INTEGER NOT NULL,
    duracion_hora   INTEGER NOT NULL,
    dia             DATE NOT NULL,
    hora            VARCHAR2(255 BYTE) NOT NULL,
    habitaciones_id INTEGER NOT NULL
);

ALTER TABLE reservasservicio ADD CONSTRAINT reservasservicio_pk PRIMARY KEY ( id );

CREATE TABLE reservasspa (
    reservasservicio_id INTEGER NOT NULL,
    spas_id             INTEGER NOT NULL
);

ALTER TABLE reservasspa ADD CONSTRAINT reservasspa_pk PRIMARY KEY ( reservasservicio_id,
                                                                    spas_id );

CREATE TABLE restaurantes (
    id                 INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    estilo             VARCHAR2(255 BYTE) NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( id );

CREATE TABLE salonesconferencia (
    id                 INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    costo_hora         NUMBER NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE salonesconferencia ADD CONSTRAINT salonesconferencia_pk PRIMARY KEY ( id );

CREATE TABLE salonesreunion (
    id                 INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    costo_hora         NUMBER NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE salonesreunion
    ADD CONSTRAINT ck_capacidad CHECK ( capacidad BETWEEN 0 AND 12 );

ALTER TABLE salonesreunion ADD CONSTRAINT salonesreunion_pk PRIMARY KEY ( id );

CREATE TABLE servicioslavanderia (
    id                 INTEGER NOT NULL,
    tipo_prenda        VARCHAR2(255 BYTE) NOT NULL,
    cantidad_prendas   INTEGER NOT NULL,
    costo              NUMBER NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE servicioslavanderia ADD CONSTRAINT servicioslavanderia_pk PRIMARY KEY ( id );

CREATE TABLE serviciosprestamo (
    id                 INTEGER NOT NULL,
    cantidad           INTEGER NOT NULL,
    devuelto           NUMBER,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE serviciosprestamo ADD CONSTRAINT serviciosprestamo_pk PRIMARY KEY ( id );

CREATE TABLE serviciosspa (
    id           INTEGER NOT NULL,
    nombre       VARCHAR2(255 BYTE) NOT NULL,
    costo        NUMBER NOT NULL,
    duracion_min INTEGER NOT NULL
);

ALTER TABLE serviciosspa ADD CONSTRAINT serviciosspa_pk PRIMARY KEY ( id );

CREATE TABLE sirven_bar (
    bares_id        INTEGER NOT NULL,
    productosbar_id INTEGER NOT NULL
);

ALTER TABLE sirven_bar ADD CONSTRAINT sirven_bar_pk PRIMARY KEY ( bares_id,
                                                                  productosbar_id );

CREATE TABLE sirven_res (
    restaurantes_id         INTEGER NOT NULL,
    productosrestaurante_id INTEGER NOT NULL
);

ALTER TABLE sirven_res ADD CONSTRAINT sirven_res_pk PRIMARY KEY ( restaurantes_id,
                                                                  productosrestaurante_id );

CREATE TABLE spas (
    id                 INTEGER NOT NULL,
    capacidad          INTEGER NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

CREATE TABLE supermercados (
    id                 INTEGER NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL,
    nombre             VARCHAR2(255 BYTE)
);

ALTER TABLE supermercados ADD CONSTRAINT supermercados_pk PRIMARY KEY ( id );

CREATE TABLE tiendas (
    id                 INTEGER NOT NULL,
    tipo_tienda        VARCHAR2(255 BYTE) NOT NULL,
    tiposservicio_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( id );

CREATE TABLE tiposhabitacion (
    tipo    VARCHAR2(255 BYTE) NOT NULL,
    jacuzzi NUMBER,
    comedor NUMBER,
    cocina  NUMBER
);

ALTER TABLE tiposhabitacion ADD CONSTRAINT tiposhabitacion_pk PRIMARY KEY ( tipo );

CREATE TABLE tiposservicio (
    tipo        VARCHAR2(255 BYTE) NOT NULL,
    descripcion VARCHAR2(510) NOT NULL
);

ALTER TABLE tiposservicio
    ADD CONSTRAINT ck_tipo_servicio CHECK ( tipo IN ( 'bar', 'gimnasio', 'internet', 'lavadoSecadoEmbolado', 'piscina',
                                                      'prestamo', 'restaurante', 'salon', 'spa', 'supermercado',
                                                      'tienda' ) );

ALTER TABLE tiposservicio ADD CONSTRAINT tiposservicio_pk PRIMARY KEY ( tipo );

CREATE TABLE tiposusuario (
    tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE tiposusuario ADD CONSTRAINT tiposusuario_pk PRIMARY KEY ( tipo );

CREATE TABLE usuarios (
    tipo_documento    VARCHAR2(255 BYTE) DEFAULT 'CC' NOT NULL,
    num_documento     NUMBER NOT NULL,
    nombre            VARCHAR2(255 BYTE) NOT NULL,
    correo            VARCHAR2(255 BYTE) NOT NULL,
    tiposusuario_tipo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE usuarios
    ADD CONSTRAINT ck_tipo_documento CHECK ( tipo_documento IN ( 'CC', 'CE', 'CIF', 'TI', 'pasaporte' ) );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_pk PRIMARY KEY ( num_documento,
                                             correo,
                                             nombre,
                                             tipo_documento );

CREATE TABLE utensilios (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL,
    costo  NUMBER NOT NULL
);

ALTER TABLE utensilios ADD CONSTRAINT utensilios_pk PRIMARY KEY ( id );

CREATE TABLE vendensuper (
    supermercados_id  INTEGER NOT NULL,
    productossuper_id INTEGER NOT NULL
);

ALTER TABLE vendensuper ADD CONSTRAINT vendensuper_pk PRIMARY KEY ( supermercados_id,
                                                                    productossuper_id );

CREATE TABLE vendentienda (
    tiendas_id         INTEGER NOT NULL,
    productostienda_id INTEGER NOT NULL
);

ALTER TABLE vendentienda ADD CONSTRAINT vendentienda_pk PRIMARY KEY ( tiendas_id,
                                                                      productostienda_id );

ALTER TABLE bares
    ADD CONSTRAINT bares_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE checkin
    ADD CONSTRAINT checkin_informacionclientes_fk FOREIGN KEY ( informacionclientes_num_documento,
                                                                informacionclientes_tipo_documento )
        REFERENCES informacionclientes ( num_documento,
                                         tipo_documento );

ALTER TABLE checkin
    ADD CONSTRAINT checkin_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE checkouts
    ADD CONSTRAINT checkouts_habitaciones_fk FOREIGN KEY ( habitaciones_id )
        REFERENCES habitaciones ( id );

ALTER TABLE checkouts
    ADD CONSTRAINT checkouts_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_habitaciones_fk FOREIGN KEY ( habitaciones_id )
        REFERENCES habitaciones ( id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tiposhabitacion_fk FOREIGN KEY ( tiposhabitacion_tipo )
        REFERENCES tiposhabitacion ( tipo );

ALTER TABLE internets
    ADD CONSTRAINT internets_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE maquinas
    ADD CONSTRAINT maquinas_gimnasios_fk FOREIGN KEY ( gimnasios_id )
        REFERENCES gimnasios ( id );

ALTER TABLE ofrece
    ADD CONSTRAINT ofrece_serviciosspa_fk FOREIGN KEY ( serviciosspa_id )
        REFERENCES serviciosspa ( id );

ALTER TABLE ofrece
    ADD CONSTRAINT ofrece_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE presta
    ADD CONSTRAINT presta_serviciosprestamo_fk FOREIGN KEY ( serviciosprestamo_id )
        REFERENCES serviciosprestamo ( id );

ALTER TABLE presta
    ADD CONSTRAINT presta_utensilios_fk FOREIGN KEY ( utensilios_id )
        REFERENCES utensilios ( id );

ALTER TABLE prestanadicional
    ADD CONSTRAINT prestanadicional_equipos_fk FOREIGN KEY ( equipos_id )
        REFERENCES equipos ( id );

ALTER TABLE prestanadicional
    ADD CONSTRAINT prestanadicional_salonesreunion_fk FOREIGN KEY ( salonesreunion_id )
        REFERENCES salonesreunion ( id );

ALTER TABLE prestangratis
    ADD CONSTRAINT prestangratis_equipos_fk FOREIGN KEY ( equipos_id )
        REFERENCES equipos ( id );

ALTER TABLE prestangratis
    ADD CONSTRAINT prestangratis_salonesconferencia_fk FOREIGN KEY ( salonesconferencia_id )
        REFERENCES salonesconferencia ( id );

ALTER TABLE reservan
    ADD CONSTRAINT reservan_habitaciones_fk FOREIGN KEY ( habitaciones_id )
        REFERENCES habitaciones ( id );

ALTER TABLE reservan
    ADD CONSTRAINT reservan_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planesconsumo_fk FOREIGN KEY ( planesconsumo_id )
        REFERENCES planesconsumo ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_usuarios_fk FOREIGN KEY ( usuarios_num_documento,
                                                      usuarios_correo,
                                                      usuarios_nombre,
                                                      usuarios_tipo_documento )
        REFERENCES usuarios ( num_documento,
                              correo,
                              nombre,
                              tipo_documento );

ALTER TABLE reservassalonconferencia
    ADD CONSTRAINT reservassalonconferencia_reservasservicio_fk FOREIGN KEY ( reservasservicio_id )
        REFERENCES reservasservicio ( id );

ALTER TABLE reservassalonconferencia
    ADD CONSTRAINT reservassalonconferencia_salonesconferencia_fk FOREIGN KEY ( salonesconferencia_id )
        REFERENCES salonesconferencia ( id );

ALTER TABLE reservassalonreunion
    ADD CONSTRAINT reservassalonreunion_reservasservicio_fk FOREIGN KEY ( reservasservicio_id )
        REFERENCES reservasservicio ( id );

ALTER TABLE reservassalonreunion
    ADD CONSTRAINT reservassalonreunion_salonesreunion_fk FOREIGN KEY ( salonesreunion_id )
        REFERENCES salonesreunion ( id );

ALTER TABLE reservasservicio
    ADD CONSTRAINT reservasservicio_habitaciones_fk FOREIGN KEY ( habitaciones_id )
        REFERENCES habitaciones ( id );

ALTER TABLE reservasspa
    ADD CONSTRAINT reservasspa_reservasservicio_fk FOREIGN KEY ( reservasservicio_id )
        REFERENCES reservasservicio ( id );

ALTER TABLE reservasspa
    ADD CONSTRAINT reservasspa_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE salonesconferencia
    ADD CONSTRAINT salonesconferencia_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );
 
ALTER TABLE salonesreunion
    ADD CONSTRAINT salonesreunion_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE servicioslavanderia
    ADD CONSTRAINT servicioslavanderia_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE serviciosprestamo
    ADD CONSTRAINT serviciosprestamo_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE sirven_bar
    ADD CONSTRAINT sirven_bar_bares_fk FOREIGN KEY ( bares_id )
        REFERENCES bares ( id );

ALTER TABLE sirven_bar
    ADD CONSTRAINT sirven_bar_productosbar_fk FOREIGN KEY ( productosbar_id )
        REFERENCES productosbar ( id );
 
ALTER TABLE sirven_res
    ADD CONSTRAINT sirven_res_productosrestaurante_fk FOREIGN KEY ( productosrestaurante_id )
        REFERENCES productosrestaurante ( id );

ALTER TABLE sirven_res
    ADD CONSTRAINT sirven_res_restaurantes_fk FOREIGN KEY ( restaurantes_id )
        REFERENCES restaurantes ( id );

ALTER TABLE spas
    ADD CONSTRAINT spas_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_tiposservicio_fk FOREIGN KEY ( tiposservicio_tipo )
        REFERENCES tiposservicio ( tipo );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_tiposusuario_fk FOREIGN KEY ( tiposusuario_tipo )
        REFERENCES tiposusuario ( tipo );

ALTER TABLE vendensuper
    ADD CONSTRAINT vendensuper_productossuper_fk FOREIGN KEY ( productossuper_id )
        REFERENCES productossuper ( id );

ALTER TABLE vendensuper
    ADD CONSTRAINT vendensuper_supermercados_fk FOREIGN KEY ( supermercados_id )
        REFERENCES supermercados ( id );
 
ALTER TABLE vendentienda
    ADD CONSTRAINT vendentienda_productostienda_fk FOREIGN KEY ( productostienda_id )
        REFERENCES productostienda ( id );

ALTER TABLE vendentienda
    ADD CONSTRAINT vendentienda_tiendas_fk FOREIGN KEY ( tiendas_id )
        REFERENCES tiendas ( id );

CREATE SEQUENCE bares_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER bares_id_trg BEFORE
    INSERT ON bares
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := bares_id_seq.nextval;
END;
/

CREATE SEQUENCE equipos_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER equipos_id_trg BEFORE
    INSERT ON equipos
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := equipos_id_seq.nextval;
END;
/

CREATE SEQUENCE gimnasios_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER gimnasios_id_trg BEFORE
    INSERT ON gimnasios
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := gimnasios_id_seq.nextval;
END;
/

CREATE SEQUENCE habitaciones_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER habitaciones_id_trg BEFORE
    INSERT ON habitaciones
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := habitaciones_id_seq.nextval;
END;
/

CREATE SEQUENCE internets_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER internets_id_trg BEFORE
    INSERT ON internets
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := internets_id_seq.nextval;
END;
/

CREATE SEQUENCE maquinas_id_maquina_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER maquinas_id_maquina_trg BEFORE
    INSERT ON maquinas
    FOR EACH ROW
    WHEN ( new.id_maquina IS NULL )
BEGIN
    :new.id_maquina := maquinas_id_maquina_seq.nextval;
END;
/

CREATE SEQUENCE piscinas_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER piscinas_id_trg BEFORE
    INSERT ON piscinas
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := piscinas_id_seq.nextval;
END;
/

CREATE SEQUENCE planesconsumo_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER planesconsumo_id_trg BEFORE
    INSERT ON planesconsumo
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := planesconsumo_id_seq.nextval;
END;
/

CREATE SEQUENCE productosbar_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productosbar_id_trg BEFORE
    INSERT ON productosbar
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := productosbar_id_seq.nextval;
END;
/

CREATE SEQUENCE productosrestaurante_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productosrestaurante_id_trg BEFORE
    INSERT ON productosrestaurante
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := productosrestaurante_id_seq.nextval;
END;
/

CREATE SEQUENCE productossuper_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productossuper_id_trg BEFORE
    INSERT ON productossuper
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := productossuper_id_seq.nextval;
END;
/

CREATE SEQUENCE productostienda_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productostienda_id_trg BEFORE
    INSERT ON productostienda
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := productostienda_id_seq.nextval;
END;
/

CREATE SEQUENCE reservasservicio_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER reservasservicio_id_trg BEFORE
    INSERT ON reservasservicio
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := reservasservicio_id_seq.nextval;
END;
/

CREATE SEQUENCE restaurantes_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER restaurantes_id_trg BEFORE
    INSERT ON restaurantes
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := restaurantes_id_seq.nextval;
END;
/

CREATE SEQUENCE salonesconferencia_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER salonesconferencia_id_trg BEFORE
    INSERT ON salonesconferencia
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := salonesconferencia_id_seq.nextval;
END;
/

CREATE SEQUENCE salonesreunion_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER salonesreunion_id_trg BEFORE
    INSERT ON salonesreunion
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := salonesreunion_id_seq.nextval;
END;
/

CREATE SEQUENCE servicioslavanderia_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER servicioslavanderia_id_trg BEFORE
    INSERT ON servicioslavanderia
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := servicioslavanderia_id_seq.nextval;
END;
/

CREATE SEQUENCE serviciosprestamo_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER serviciosprestamo_id_trg BEFORE
    INSERT ON serviciosprestamo
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := serviciosprestamo_id_seq.nextval;
END;
/

CREATE SEQUENCE serviciosspa_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER serviciosspa_id_trg BEFORE
    INSERT ON serviciosspa
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := serviciosspa_id_seq.nextval;
END;
/

CREATE SEQUENCE spas_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER spas_id_trg BEFORE
    INSERT ON spas
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := spas_id_seq.nextval;
END;
/

CREATE SEQUENCE supermercados_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER supermercados_id_trg BEFORE
    INSERT ON supermercados
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := supermercados_id_seq.nextval;
END;
/

CREATE SEQUENCE tiendas_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER tiendas_id_trg BEFORE
    INSERT ON tiendas
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := tiendas_id_seq.nextval;
END;
/

CREATE SEQUENCE utensilios_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER utensilios_id_trg BEFORE
    INSERT ON utensilios
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := utensilios_id_seq.nextval;
END;
/

CREATE SEQUENCE reservas_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER reservas_id_trg BEFORE
    INSERT ON reservas
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := reservas_id_seq.nextval;
END;
/

