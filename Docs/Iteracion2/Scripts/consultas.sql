---Para RFC1
---Si existe una reserva de servicio asociada a una habitacion aparece el registro en 0, si hay algún tipo de consumo se suma el costo asociado al consumo
SELECT h.id AS habitacion_id,
COALESCE(SUM(c.costo), 0) AS dinero_recolectado
FROM	
    habitaciones h
LEFT JOIN
    consumos c ON h.id = c.habitaciones_id
WHERE
    c.fecha_consumo >= ADD_MONTHS(CURRENT_DATE, -12)
GROUP BY
    h.id;

---RFC2
SELECT
    s.tipo AS servicio,
    COUNT(c.tiposservicio_tipo) AS cantidad_consumos
FROM
    consumos c
INNER JOIN
    tiposservicio s ON c.tiposservicio_tipo = s.tipo
WHERE
    c.fecha_consumo >= TRUNC(SYSDATE - INTERVAL '15' MONTH)  -- Período de 6 meses
GROUP BY
    s.tipo
ORDER BY
    cantidad_consumos DESC
FETCH FIRST 20 ROWS ONLY;

--- RFC3
-- Redondeado, no da indice exacto

WITH ReservasEnUltimoAnio AS (
    SELECT
        r.habitaciones_id,
        GREATEST(rs.fecha_inicio, (SYSDATE - INTERVAL '1' YEAR)) AS fecha_entrada,  
        LEAST(rs.fecha_salida, SYSDATE) AS fecha_salida
    FROM
        reservan r
    INNER JOIN
        reservas rs ON r.reservas_id = rs.id
    WHERE
        rs.fecha_inicio <= SYSDATE
        AND rs.fecha_salida >= (SYSDATE - INTERVAL '1' YEAR)  
)
SELECT
    h.id AS habitacion_id,
    ROUND(COALESCE(SUM(TO_NUMBER(fecha_salida - fecha_entrada) + 1), 0)) AS dias_ocupados_en_ultimo_anio,
    ROUND(COALESCE((SUM(TO_NUMBER(fecha_salida - fecha_entrada) + 1) / 365) * 100, 0)) AS porcentaje_ocupacion_en_ultimo_anio
FROM
    habitaciones h
LEFT JOIN
    ReservasEnUltimoAnio ro ON h.id = ro.habitaciones_id
GROUP BY
    h.id;


    
---RFC5
SELECT
    u.num_documento AS numero_documento,
    u.nombre,
    SUM(c.costo) AS suma_consumos
FROM
    reservas r
INNER JOIN
    habitaciones h ON r.id = h.id
INNER JOIN
    consumos c ON h.id = c.habitaciones_id
INNER JOIN
    usuarios u ON r.usuarios_num_documento = u.num_documento AND r.usuarios_tipo_documento = u.tipo_documento
WHERE
    u.num_documento = '1765432' -- Reemplaza con el número de documento del usuario que deseas buscar
    AND c.fecha_consumo BETWEEN '01/01/2023' AND '30/12/2023' -- Reemplaza con el rango de fechas deseado
GROUP BY
    u.num_documento, u.nombre;
    
---RFC6
---a)
WITH FechasReservas AS (
    SELECT DISTINCT fecha AS fecha_reserva
    FROM (
        SELECT fecha_inicio AS fecha FROM reservas
        UNION ALL
        SELECT fecha_salida AS fecha FROM reservas))
SELECT fr.fecha_reserva, COUNT(r.id) AS reservas_activas
FROM FechasReservas fr
JOIN reservas r ON fr.fecha_reserva BETWEEN r.fecha_inicio AND r.fecha_salida
GROUP BY fr.fecha_reserva
ORDER BY reservas_activas DESC
FETCH FIRST 10 ROWS ONLY;

--- B)
WITH FechasConsumos AS (
    SELECT DISTINCT fecha_consumo AS fecha
    FROM consumos)
SELECT fc.fecha, SUM(c.costo) AS costo_consumos, COUNT(c.costo) AS consumos_realizados
FROM FechasConsumos fc
JOIN consumos c ON fc.fecha = c.fecha_consumo
GROUP BY fc.fecha
ORDER BY costo_consumos DESC
FETCH FIRST 10 ROWS ONLY;

--- C
WITH FechasReservas AS (
    SELECT DISTINCT fecha AS fecha_reserva
    FROM (
        SELECT fecha_inicio AS fecha FROM reservas
        UNION ALL
        SELECT fecha_salida AS fecha FROM reservas))
SELECT fr.fecha_reserva, COUNT(r.id) AS reservas_activas
FROM FechasReservas fr
JOIN reservas r ON fr.fecha_reserva BETWEEN r.fecha_inicio AND r.fecha_salida
GROUP BY fr.fecha_reserva
ORDER BY reservas_activas ASC
FETCH FIRST 10 ROWS ONLY;


---RFC7
WITH BuenClienteTiempo AS (
    SELECT DISTINCT r.usuarios_num_documento AS num_documento_cliente
    FROM reservas r
    WHERE (r.fecha_salida - r.fecha_inicio) >= 14), BuenClienteConsumo AS (
    SELECT r.usuarios_num_documento AS num_documento_cliente, SUM(c.costo) AS suma_consumos
    FROM reservas r
    JOIN consumos c ON r.id = c.habitaciones_id
    WHERE c.fecha_consumo >= (SELECT MAX(fecha_consumo) FROM consumos) - INTERVAL '1' YEAR
    GROUP BY r.usuarios_num_documento
    HAVING SUM(c.costo) > 15000000)
SELECT u.num_documento AS num_documento_cliente, u.nombre AS nombre_cliente,
       CASE
           WHEN u.num_documento IN (SELECT num_documento_cliente FROM BuenClienteConsumo) THEN TO_CHAR((SELECT suma_consumos FROM BuenClienteConsumo WHERE num_documento_cliente = u.num_documento), '$999,999,999.99')
           ELSE 'Buen usuario por tiempo'
       END AS Razon
FROM usuarios u
WHERE u.num_documento IN (
    SELECT num_documento_cliente FROM BuenClienteConsumo
    UNION
    SELECT num_documento_cliente FROM BuenClienteTiempo);

---RFC8
WITH ConsumosPorSemana AS (
  SELECT t.tipo, TO_CHAR(c.fecha_consumo, 'IYYY-IW') AS semana, COUNT(*) AS veces_consumido
  FROM consumos c INNER JOIN tiposservicio t ON c.tiposservicio_tipo = t.tipo
  WHERE c.fecha_consumo BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD')
  GROUP BY t.tipo, TO_CHAR(c.fecha_consumo, 'IYYY-IW') )
SELECT s.tipo, s.semana, s.veces_consumido
FROM ConsumosPorSemana s
WHERE s.veces_consumido < 3;


---RFC9
-- Definir los parámetros como valores literales (reemplaza con tus valores)

-- Consulta SQL para obtener la información
SELECT
    r.usuarios_num_documento AS num_documento_cliente,
    r.usuarios_nombre AS nombre_cliente,
    c.tiposservicio_tipo AS tipo_servicio,
    COUNT(c.tiposservicio_tipo) AS veces_utilizado
FROM consumos c
LEFT JOIN reservan rv ON c.habitaciones_id = rv.habitaciones_id
LEFT JOIN reservas r ON rv.reservas_id = r.id
WHERE c.tiposservicio_tipo = 'spa' AND c.fecha_consumo BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD')
GROUP BY r.usuarios_num_documento, r.usuarios_nombre, c.tiposservicio_tipo
ORDER BY r.usuarios_nombre ASC;

    
--- Dentro de java revisar variables para hacer el ordenamiento
--- RFC10
-- Consulta SQL para encontrar clientes que NO consumieron un servicio específico
SELECT
    u.num_documento AS num_documento_cliente,
    u.nombre AS nombre_cliente
FROM
    usuarios u
WHERE
    u.num_documento NOT IN (
        SELECT
        r.usuarios_num_documento AS num_documento_cliente
        FROM
        consumos c
        LEFT JOIN
        reservan rv ON c.habitaciones_id = rv.habitaciones_id
        LEFT JOIN
        reservas r ON rv.reservas_id = r.id
        WHERE
        c.tiposservicio_tipo = 'supermercado'
        AND c.fecha_consumo BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD')
        GROUP BY r.usuarios_num_documento, r.usuarios_nombre, c.tiposservicio_tipo
    );
---RFC11
WITH Semanas AS (
    SELECT
        TO_CHAR(fecha_inicio, 'IYYY-IW') AS semana,
        reservan.reservas_id AS reserva_id,
        consumos.tiposservicio_tipo AS tipoServicio,
        reservan.habitaciones_id AS habitacion_id 
    FROM reservas
    JOIN reservan ON reservan.reservas_id = reservas.id
    JOIN consumos ON reservan.habitaciones_id = consumos.habitaciones_id),
ServiciosConsumidos AS (
    SELECT
        semana,
        tipoServicio,
        COUNT(*) AS total_consumos
    FROM Semanas
    GROUP BY semana, tipoServicio),
HabitacionesSolicitadas AS (
    SELECT
        semana,
        habitacion_id,
        COUNT(*) AS total_solicitudes
    FROM Semanas
    GROUP BY semana, habitacion_id),
MaxMinServicios AS (
    SELECT
        semana,
        MAX(total_consumos) AS max_consumos,
        MIN(total_consumos) AS min_consumos
    FROM ServiciosConsumidos
    GROUP BY semana
), MaxMinHabitaciones AS (
    SELECT
        semana,
        MAX(total_solicitudes) AS max_solicitudes,
        MIN(total_solicitudes) AS min_consumos
    FROM HabitacionesSolicitadas
    GROUP BY semana)
SELECT
    s.semana,
    MAX(CASE WHEN sc.total_consumos = mms.max_consumos THEN tipoServicio END) AS servicio_mas_consumido,
    MIN(CASE WHEN sc.total_consumos = mms.min_consumos THEN tipoServicio END) AS servicio_menos_consumido,
    MAX(CASE WHEN hs.total_solicitudes = mmh.max_solicitudes THEN habitacion_id END) AS habitacion_mas_solicitada,
    MIN(CASE WHEN hs.total_solicitudes = mmh.min_consumos THEN habitacion_id END) AS habitacion_menos_solicitada
FROM (SELECT DISTINCT semana FROM Semanas) s
JOIN MaxMinServicios mms ON s.semana = mms.semana
JOIN MaxMinHabitaciones mmh ON s.semana = mmh.semana
LEFT JOIN ServiciosConsumidos sc ON s.semana = sc.semana
LEFT JOIN HabitacionesSolicitadas hs ON s.semana = hs.semana
GROUP BY s.semana
ORDER BY s.semana;

---RFC12
--- Reservas por trimestre
SELECT usuarios_nombre AS nombre_cliente, usuarios_num_documento AS num_documento_cliente, usuarios_correo AS correo
FROM reservas
WHERE fecha_inicio BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-03-31', 'YYYY-MM-DD')
    AND usuarios_num_documento IN (
        SELECT usuarios_num_documento
        FROM reservas
        WHERE fecha_inicio BETWEEN TO_DATE('2023-05-01', 'YYYY-MM-DD') AND TO_DATE('2023-08-30', 'YYYY-MM-DD')
    ) AND usuarios_num_documento IN (
        SELECT usuarios_num_documento
        FROM reservas
        WHERE fecha_inicio BETWEEN TO_DATE('2023-09-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-30', 'YYYY-MM-DD'));
---Por lo menos un consumo de servicio costoso
SELECT
    r.usuarios_nombre AS nombre_cliente,
    r.usuarios_num_documento AS num_documento_cliente,
    r.usuarios_correo AS correo
FROM reservas r
WHERE r.usuarios_num_documento IN (
    SELECT r2.usuarios_num_documento
    FROM reservas r2
    WHERE EXISTS (
        SELECT 1
        FROM consumos c
        WHERE c.fecha_consumo BETWEEN r2.fecha_inicio AND r2.fecha_salida AND c.costo >= 300000))
GROUP BY r.usuarios_num_documento, r.usuarios_nombre,r.usuarios_correo ;

-------
SELECT
    r.usuarios_nombre AS nombre,
    r.usuarios_num_documento AS num_doc,
    r.usuarios_correo
    FROM RESERVAS r
WHERE r.usuarios_num_documento NOT IN (
    SELECT DISTINCT re.usuarios_num_documento
    FROM
        RESERVASSERVICIO rs
    INNER JOIN RESERVAN ON rs.habitaciones_id = reservan.habitaciones_id
    INNER JOIN RESERVAS re ON rs.dia BETWEEN re.fecha_inicio AND re.fecha_salida
    WHERE rs.duracion_hora < 4
)
GROUP BY r.usuarios_nombre, r.usuarios_num_documento, r.usuarios_correo;


SELECT *
FROM consumos
WHERE
    (precio >= :precioMin OR :precioMin IS NULL)
    AND (precio <= :precioMax OR :precioMax IS NULL)
    AND (fecha_consumo >= :fechaInicio OR :fechaInicio IS NULL)
    AND (fecha_consumo <= :fechaFin OR :fechaFin IS NULL)
    AND (empleado = :empleado OR :empleado IS NULL)
    AND (tipo = :tipo OR :tipo IS NULL)
    AND (categoria = :categoria OR :categoria IS NULL);

--- 
SELECT
    r.usuarios_nombre AS nombre_cliente,
    r.usuarios_num_documento AS num_documento_cliente
FROM
    reservas r
WHERE
    r.usuarios_num_documento IN (
        SELECT usuarios_num_documento
        FROM reservas
        WHERE fecha_inicio BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-03-31', 'YYYY-MM-DD')
    )
    AND r.usuarios_num_documento IN (
        SELECT usuarios_num_documento
        FROM consumos
        WHERE fecha_consumo BETWEEN r.fecha_inicio AND r.fecha_salida
        AND (
            (tiposservicio_tipo = 'SPA' AND duracion_horas > 4)
            OR (tiposservicio_tipo = 'salonesreunion' AND duracion_horas > 4)
        )
    )
AND r.usuarios_num_documento IN (
    SELECT usuarios_num_documento
    FROM reservas
    WHERE fecha_inicio BETWEEN TO_DATE('2023-04-01', 'YYYY-MM-DD') AND TO_DATE('2023-06-30', 'YYYY-MM-DD')
)
AND r.usuarios_num_documento IN (
    SELECT usuarios_num_documento
    FROM reservas
    WHERE fecha_inicio BETWEEN TO_DATE('2023-07-01', 'YYYY-MM-DD') AND TO_DATE('2023-09-30', 'YYYY-MM-DD')
)
AND r.usuarios_num_documento IN (
    SELECT usuarios_num_documento
    FROM reservas
    WHERE fecha_inicio BETWEEN TO_DATE('2023-10-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD')
);




