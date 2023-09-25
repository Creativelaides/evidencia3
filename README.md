<!-- Reemplaza 'url_del_logo.png' con la URL o ruta de tu logo -->
<p align="center"><img src="assets\sena_logo.png" width="80px"></p>

# Descripción de la Aplicación

Esta aplicación de consola en Java es un programa de gestión de usuarios que interactúa con una base de datos MariaDB. Permite realizar diversas operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una tabla de usuarios. Los usuarios pueden ser consultados, agregados, actualizados o eliminados de la base de datos a través de un menú de consola interactivo.

## Requisitos

Antes de ejecutar la aplicación, asegúrese de tener lo siguiente configurado:

- Una base de datos MariaDB en ejecución.
- Los controladores JDBC de MariaDB configurados en su entorno de desarrollo.
- Un esquema de base de datos llamado "customer" con una tabla de usuarios.
- Las credenciales de usuario y contraseña de la base de datos deben coincidir con las proporcionadas en el código.

## Componentes de la Aplicación

La aplicación consta de los siguientes componentes principales:

### Modelos (Package `models`)

Los modelos son representaciones de los objetos de usuario en la aplicación. El modelo principal es la clase `User`, que contiene atributos como el ID, nombre, apellido y dirección de un usuario. Estos modelos encapsulan la información de usuario y permiten su manipulación dentro de la aplicación de manera estructurada.

[🔜 Descripción del Modelo de Usuario](/src/models/)

### Controladores (Package `controllers`)

Los controladores actúan como intermediarios entre la lógica de la aplicación y la base de datos. La clase `UserController` contiene métodos para realizar operaciones CRUD en la tabla de usuarios de la base de datos. Estos controladores gestionan la creación, lectura, actualización y eliminación de usuarios en la base de datos, utilizando los modelos de usuario para representar y manipular la información.

[🔜 Descripción del Controlador de Usuarios](/src/controllers/)

## Funcionalidades

La aplicación ofrece las siguientes funcionalidades:

1. **Obtener todos los usuarios:** Lista todos los usuarios almacenados en la base de datos junto con su ID, nombre y dirección.

2. **Buscar usuario por ID:** Permite buscar un usuario específico por su ID y muestra su información.

3. **Ingresar un nuevo usuario:** Permite ingresar un nuevo usuario proporcionando su nombre, apellido y dirección.

4. **Eliminar un usuario por ID:** Elimina un usuario de la base de datos según su ID.

5. **Actualizar un usuario por ID:** Actualiza la información de un usuario existente según su ID.

6. **Salir:** Cierra la conexión a la base de datos y termina la aplicación.

## Uso

1. Inicie la aplicación proporcionando las credenciales correctas para la base de datos MariaDB (appUrl, appUser, appPass).

2. Seleccione una opción del menú ingresando el número correspondiente y siga las instrucciones para cada operación.

3. Para salir de la aplicación, seleccione la opción "6" en el menú.

## Notas

- Asegúrese de que los controladores JDBC de MariaDB estén incluidos en el proyecto.
- Esta aplicación es un ejemplo simple y puede ser ampliada y mejorada según las necesidades del proyecto.

¡Disfrute usando esta aplicación de gestión de usuarios que utiliza modelos y controladores para interactuar con una base de datos MariaDB de manera eficiente y organizada!