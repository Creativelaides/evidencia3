<!-- Reemplaza 'url_del_logo.png' con la URL o ruta de tu logo -->
<div align="center"><img src="..\..\assets\sena_logo.png" width="80px">

[🔙 Descripción de la Aplicación](/)
</div>

# Descripción del Modelo de Usuario

El paquete `models` contiene la definición de la clase `User`, que representa un objeto de usuario. Esta clase se utiliza para modelar la información de los usuarios que se almacenan en la base de datos y se utilizan en la aplicación de gestión de usuarios.

## Clase `User`

La clase `User` tiene los siguientes atributos y métodos:

### Atributos

- `id` (int): Representa el identificador único del usuario.
- `fname` (String): Almacena el nombre (nombre de pila) del usuario.
- `lname` (String): Almacena el apellido del usuario.
- `address` (String): Almacena la dirección del usuario.

### Constructores

1. **Constructor con ID**: Este constructor se utiliza para crear un objeto `User` cuando se conoce el identificador único (ID) del usuario. Toma como parámetros el ID, el nombre, el apellido y la dirección del usuario.

2. **Constructor sin ID (para la base de datos)**: Este constructor se utiliza para crear un objeto `User` cuando se va a insertar un nuevo usuario en la base de datos y no se conoce su ID en ese momento. Toma como parámetros el nombre, el apellido y la dirección del usuario.

### Métodos

- **Getters y Setters**: La clase `User` incluye métodos getter y setter para acceder y modificar los atributos `id`, `fname`, `lname` y `address`. Estos métodos permiten establecer y obtener los valores de estos atributos de manera controlada.

Estos modelos de usuario se utilizan en la aplicación para representar la información de los usuarios que se manipula a través de las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos. Los objetos `User` encapsulan la información de un usuario y facilitan su manipulación dentro de la aplicación.
