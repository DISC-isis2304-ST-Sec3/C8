import random
import string
import sys
import os

nombre = ["Juan", "María", "Luis", "Ana", "Carlos", "Sofía", "Pedro", "Laura", "Javier", "Elena", "Miguel", "Lucía", "Ricardo", "Isabel", "Fernando", "Carmen", "Alejandro", "Rosa", "Andrés", "Patricia", "José", "Silvia", "Diego", "Beatriz", "Antonio", "Natalia", "Manuel", "Valeria", "Roberto", "Marta", "Jorge", "Gabriela", "Eduardo", "Pilar", "Raúl", "Victoria", "Gabriel", "Clara", "Francisco", "Lourdes", "Rodrigo", "Lorena", "Alberto", "Teresa", "Gonzalo", "Susana", "Luisa", "Santiago", "Mariana", "Joaquín", "Nieves", "Daniel", "Alicia", "Rafael", "Cecilia", "César", "Diana", "René", "Marina", "Hugo", "Esther", "Julio", "Olga", "Víctor", "Gloria", "Ignacio", "Eva", "Héctor", "Adriana", "Mauricio", "Sara", "Marcelo", "Emma", "Alejandra", "Cristina", "Lucas", "Liliana", "Pablo", "Luisiana", "Guillermo", "Yolanda", "Nicolás", "Rita", "Tomás", "Catalina", "Martín", "Elisa", "Federico", "Vanesa", "Emilio", "Belen", "Roberto", "Verónica", "Eduardo", "Paula", "Lorenzo", "Nora", "Simón", "Marisa", "Mateo", "Josefina"

]

apellido = ["González", "Rodríguez", "Martínez", "López", "Hernández", "Pérez", "Gómez", "Fernández", "Díaz", "Sánchez", "Romero", "Sánchez", "Suárez", "Ramírez", "Torres", "Jiménez", "Alvarez", "Gutiérrez", "Vargas", "Reyes", "Mendoza", "Castro", "Ortega", "Soto", "Silva", "Rojas", "Morales", "Navarro", "Cruz", "Guerrero", "Flores", "Núñez", "Ortiz", "Medina", "Aguilar", "Molina", "Chávez", "Rivas", "Paredes", "Vega", "Lara", "Muñoz", "Campos", "Herrera", "Flores", "Giménez", "Peña", "Arias", "Fuentes", "Miranda", "Figueroa", "Cortez", "García", "Andrade", "Ríos", "Montes", "Luna", "Calderón", "Ponce", "Escobar", "Mora", "Barrios", "Villanueva", "Valenzuela", "Bustos", "Cabrera", "Palma", "Serrano", "Álvarez", "Pino", "Guzmán", "Valdés", "Zúñiga", "Leiva", "Araya", "Aguirre", "Ferreira", "Orellana", "Sepúlveda", "Ávila", "Aguayo", "Cáceres", "Vidal", "Dominguez", "Toledo", "Sáez", "Benitez", "Moreno", "Sanhueza", "Guerrero", "Ojeda", "Valencia", "Riquelme", "Albornoz", "Poblete", "Rivas"
]


def username(nombre, apellido):
    username = nombre[:3] + apellido[:3] + str(random.randint(1, 99999))
    return username

def document():
    document = ''.join(str(random.randint(0, 9)) for _ in range(10))
    return document


def generateDataUsuarios(num):
    with open("Usuarios.csv", "w") as file:
        sys.stdout = file
        for i in range(num):
            data = str(i + 1) + ","
            name = random.choice(nombre)
            lastname = random.choice(apellido) 
            data = data + username(name, lastname)
            data = data + ","
            data = data + name + " " + lastname
            data = data + ","
            data = data + document()
            data = data + ","
            data = data + name.lower() + lastname[0:random.randint(0, len(lastname))].lower() + (str(random.randint(0, 9999)) if random.choice([True, True, False]) else "") + "@" + random.choice(["gmail", "yahoo", "hotmail", "outlook"]) + ".com"
            data = data + ","
            data = data + random.choice(["Cedula", "Tarjeta Identidad"])
            data = data + ","
            data = data + str(random.randint(1, 5)) # TIPODEUSUARIO_ID
            print(data)

    with open("Usuarios.csv", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()

def generateSQLUsuarios(num):
    with open("Usuarios.sql", "w") as file:
        sys.stdout = file
        for i in range(num):
            data = "INSERT INTO USUARIOS (tipo_documento, num_documento, nombre, correo, tipo_usuario_tipo) VALUES (" + "usuariossecuencia.nextval" + ","
            name = random.choice(nombre)
            lastname = random.choice(apellido)
            data = data + "'" + random.choice(['CC', 'CE', 'CIF', 'TI', 'pasaporte']) + "'"
            data = data + ","
            data = data + document()
            data = data + ","
            data = data + "'" + name + " " + lastname + "'"
            data = data + ","
            data = data + "'" + name.lower() + lastname[0:random.randint(0, len(lastname))].lower() + (str(random.randint(0, 9999)) if random.choice([True, True, False]) else "") + "@" + random.choice(["gmail", "yahoo", "hotmail", "outlook"]) + ".com" + "'"
            data = data + ","
            data = data + "'" + random.choice(['cliente', 'recepcionista', 'empleado', 'administrador', 'gerente']) + "'"
            data = data + ");"
            print(data)

    with open("Usuarios.sql", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()

def generateDataHabitaciones(pisos, habitacionesxpiso):
    with open("Habitaciones.csv", "w") as file:
        sys.stdout = file
        for i in range(1, pisos + 1):
            for j in range(1, habitacionesxpiso + 1):
                data = str(i) + ","
                data = data + str(random.randint(1, 6))
                data = data + ","
                data = data + str(random.randint(120000, 980000))
                data = data + ","
                data = data + str(i) + (str(0) if j < 10 else "") + str(j)
                data = data + ","
                data = data + "'" + random.choice(['doble', 'sencilla']) + "'"
                print(data)
    
    with open("Habitaciones.csv", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()

def generateSQLHabitaciones(pisos, habitacionesxpiso):
    with open("Habitaciones.sql", "w") as file:
        sys.stdout = file
        for i in range(1, pisos + 1):
            for j in range(1, habitacionesxpiso + 1):
                data = "INSERT INTO HABITACIONES (id, capacidad, costo, tiposHabitacion_tipo) VALUES (" + "habitacionessecuencia.nextvalor" + ","
                data = data + str(random.randint(1, 6))
                data = data + ","
                data = data + str(random.randint(120000, 980000))
                data = data + ","
                data = data + str(i) + (str(0) if j < 10 else "") + str(j)
                data = data + ","
                data = data + "'" + random.choice(['doble', 'sencilla']) + "'"
                data = data + ");"
                print(data)
    
    with open("Habitaciones.sql", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()

def generateDataReservas(num, users):
    with open("Reservas.csv", "w") as file:
        sys.stdout = file
        for i in range(num):
            data = str(i + 1) + ","
            data = data + str(random.randint(1, 6))
            data = data + ","
            data = data + "TO_DATE('" + str(random.randint(1, 28)) + "/" + str(random.randint(1, 6)) + "/" + str(random.randint(2020, 2021)) + "')"
            data = data + ","
            data = data + "TO_DATE('" + str(random.randint(1, 28)) + "/" + str(random.randint(6, 12)) + "/" + str(random.randint(2021, 2022)) + "')"
            data = data + ","
            data = data + str(random.randint(1, 6))
            data = data + ","
            data = data + document()
            data = data + ","
            data = data + "'" + name.lower() + lastname[0:random.randint(0, len(lastname))].lower() + (str(random.randint(0, 9999)) if random.choice([True, True, False]) else "") + "@" + random.choice(["gmail", "yahoo", "hotmail", "outlook"]) + ".com" + "'"
            data = data + ","
            name = random.choice(nombre)
            lastname = random.choice(apellido)
            data = data + "'" + username(name, lastname) + "'"
            data = data + ","
            data = data + "'" + name + " " + lastname + "'"
            data = data + ","
            data = data + str(random.randint(1, users))
            data = data + ","
            data = data + str(random.randint(1, 2)) # PLANESDECONSUMO_ID
            data = data + ","
            data = data + random.choice(["Cedula", "Tarjeta Identidad"])
            data = data + ");"
            print(data)

    with open("Reservas.csv", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()

def generateSQLReservas(num, users):
    with open("Reservas.sql", "w") as file:
        sys.stdout = file
        for i in range(num):
            data = "INSERT INTO RESERVASHABITACIONES (id, fecha_inicio, fecha_salida, num_personas, usuarios_num_documento, usuarios_correo, usuarios_nombre, planesconsumo_id, usuarios_tipo_documento) VALUES (" + "reservashabitacionessecuencia.nextvalor" + ","
            name = random.choice(nombre)
            lastname = random.choice(apellido)
            data = data + str(random.randint(1, 1000))
            data = data + ","
            data = data + "TO_DATE('" + str(random.randint(1, 28)) + "/" + str(random.randint(1, 6)) + "/" + str(random.randint(2020, 2021)) + "', 'DD/MM/YYYY')"
            data = data + ","
            data = data + "TO_DATE('" + str(random.randint(1, 28)) + "/" + str(random.randint(6, 12)) + "/" + str(random.randint(2021, 2022)) + "', 'DD/MM/YYYY')"
            data = data + str(random.randint(1, 6))
            data = data + ","
            data = data + document()
            data = data + ","
            data = data + "'" + name.lower() + lastname[0:random.randint(0, len(lastname))].lower() + (str(random.randint(0, 9999)) if random.choice([True, True, False]) else "") + "@" + random.choice(["gmail", "yahoo", "hotmail", "outlook"]) + ".com" + "'"
            data = data + ","
            data = data + "'" + username(name, lastname) + "'"
            data = data + ","
            data = data + "'" + name + " " + lastname + "'"
            data = data + ","
            data = data + str(random.randint(1, users))
            data = data + ","
            data = data + str(random.randint(1, 2)) # PLANESDECONSUMO_ID
            data = data + ","
            data = data + random.choice(["Cedula", "Tarjeta Identidad"])
            data = data + ");"
            print(data)

    with open("Reservas.sql", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()

def generateDataReservasServicio(num, users):
    with open("ReservasServicios.csv", "w") as file:
        sys.stdout = file
        for i in range(num):
            data = str(i + 1) + ","
            data = data + str(random.randint(1, 1000))
            data = data + ","
            data = data + str(random.randint(1, 28)) + "/" + str(random.randint(1, 6)) + "/" + str(random.randint(2020, 2021))
            data = data + ","
            data = data + str(random.randint(1, 28)) + "/" + str(random.randint(6, 12)) + "/" + str(random.randint(2021, 2022))
            data = data + ","
            data = data + str(random.randint(1, users))
            data = data + ","
            data = data + str(random.randint(1, 50))
            print(data)

    with open("ReservasServicios.csv", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()

def generateSQLReservasServicios(num, users):
    with open("ReservasServicio.sql", "w") as file:
        sys.stdout = file
        for i in range(num):
            data = "INSERT INTO RESERVASSERVICIO (id, duracion_hora, dia, hora, habitaciones_id) VALUES (" + "reservasserviciossecuencia.nextval" + ","
            data = data + str(random.randint(1, 6))
            data = data + ","
            data = data + str(random.randint(1, 3))
            data = data + ","
            data = data + "TO_DATE('" + str(random.randint(1, 28)) + "/" + str(random.randint(1, 6)) + "/" + str(random.randint(2020, 2021)) + "')"
            data = data + ","
            data = data + str(random.randint(1, 24))
            data = data + ","
            data = data + str(random.randint(1, users))
            data = data + ");"
            print(data)

    with open("ReservasServicios.sql", "rb+") as file:
        file.seek(-1, os.SEEK_END)
        file.truncate()



usuarios = int(input("Numero de usuarios: "))
roomsPerFloor = int(input("Numero de habitaciones por piso: "))
roomReservations = int(input("Numero de reservas habitacion: "))
serviceReservations = int(input("Numero de servicios reservacion: "))

generateDataUsuarios(usuarios)
generateSQLUsuarios(usuarios)
generateDataHabitaciones(usuarios, roomsPerFloor)
generateSQLHabitaciones(usuarios, roomsPerFloor)
generateSQLReservas(roomReservations, usuarios)
generateDataReservasServicio(serviceReservations, usuarios)
generateSQLReservasServicios(serviceReservations, usuarios)