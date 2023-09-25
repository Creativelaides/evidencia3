<!-- Reemplaza 'url_del_logo.png' con la URL o ruta de tu logo -->
<div align="center"><img src="..\..\assets\sena_logo.png" width="80px">

[🔙 Descripción de la Aplicación](src\controllers\README.md)
</div>



# Descripción del Controlador de Usuarios

El paquete `controllers` contiene la clase `UserController`, que actúa como un controlador en la aplicación de gestión de usuarios. El controlador se encarga de interactuar con la base de datos y gestionar las operaciones relacionadas con los usuarios.

## Clase `UserController`

La clase `UserController` tiene los siguientes atributos y métodos:

### Atributos

- `conn` (Connection): Representa la conexión a la base de datos MariaDB que se utiliza para realizar operaciones en la base de datos.

### Constructor

- **Constructor**: El constructor de `UserController` toma como parámetro una conexión a la base de datos (`Connection`) y la almacena en el atributo `conn`. Esta conexión se utiliza para ejecutar consultas y operaciones en la base de datos.

### Métodos

1. **getAllUsers()**: Este método obtiene todos los usuarios almacenados en la base de datos. Realiza una consulta SQL para seleccionar todos los registros de la tabla "customer". Luego, crea objetos `User` con la información de los usuarios obtenidos y los agrega a una lista que se devuelve como resultado.

2. **createUser(User user)**: Permite crear un nuevo usuario en la base de datos. Toma un objeto `User` como parámetro, que contiene la información del usuario a ser agregado. Luego, ejecuta una consulta SQL de inserción para agregar el nuevo usuario a la tabla "customer" en la base de datos.

3. **getUserById(int id)**: Recupera un usuario específico de la base de datos según su ID. Toma el ID del usuario como parámetro y ejecuta una consulta SQL para seleccionar el usuario correspondiente. Luego, crea un objeto `User` con la información obtenida y lo devuelve.

4. **updateUser(User user)**: Actualiza la información de un usuario existente en la base de datos. Toma un objeto `User` como parámetro, que contiene la nueva información del usuario. Luego, ejecuta una consulta SQL de actualización para modificar el usuario en la tabla "customer" en función de su ID.

5. **deleteUser(int id)**: Elimina un usuario de la base de datos según su ID. Toma el ID del usuario como parámetro y ejecuta una consulta SQL de eliminación para eliminar el usuario de la tabla "customer".

Estos métodos permiten realizar operaciones CRUD en la base de datos para gestionar la información de los usuarios. La clase `UserController` actúa como una interfaz entre la lógica de la aplicación y la base de datos, facilitando la manipulación de datos de usuario de manera controlada y eficiente.

