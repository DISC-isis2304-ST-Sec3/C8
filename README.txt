Para la instalación de este proyecto simplemente clone el proyecto, revise que tenga por lo meos la versión de java 17 instalada, springboot con sus extensiones y un IDE para ejecutar el proyecto.

Para unir la base de datos con la aplicación, cambiar nombre de usuario y contraseña en applicationproperties a la correspondiente con la base de datos de la universidad

Para ejecutar el proyecto:

1. Abra SQL developer y abra el archivo dentro de la carpeta "Scripts" dentro de "docs" llamado Cleanablas.sql y ejecútelo para borrar toda la información de otras tablas que puedas interceptar estas
2. Dentro de esta misma carpeta abra y ejecute CreateTablas.sql y poblarTablas.sql en este orden, asegúrese que todas las tablas y datos hayan quedado correctamente en la base de datos.
3. Abra el proyecto spring y el puerto 8080 en su navegador
4. seleccione la vista de usuario a utilizar y explore los requerimientos implementados

Para abrir los modelos:

Entidad relación: abra en data modeler el archivo dmd dentro de la carpeta ./docs/ModeloEntidadRelacion/Modelo.dmd y coloque que abra el archivo relacional que ya está contruido
Modelo Relacional: abra el excel (sugerido) o pdf dentro de la carpeta docs llamado ModeloRelacional
Diagrama de clases: abra el archivo png o pdf (sugerido) dentro de la carpeta docs llamado modeloConcepual

Para ejecutar las pruebas:

abra en sql developer el archivo pruebas.sql y ejecute los bloques de código entre comentarios
