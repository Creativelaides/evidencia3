import java.util.Scanner;

import controllers.UserController;
import models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner shell = new Scanner(System.in);

        String appUrl = "jdbc:mariadb://localhost:3306/customer";
        String appUser = "example";
        String appPass = "example123456";

        try (Connection conn = DriverManager.getConnection(appUrl, appUser, appPass)) {
            UserController userController = new UserController(conn);

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Obtener todos los usuarios");
                System.out.println("2. Buscar usuario por ID");
                System.out.println("3. Ingresar un nuevo usuario");
                System.out.println("4. Eliminar un usuario por ID");
                System.out.println("5. Actualizar un usuario por ID");
                System.out.println("6. Salir");
                System.out.print("\nSeleccione una opción: ");

                int option = shell.nextInt();
                shell.nextLine(); // Consume la nueva línea

                switch (option) {
                    case 1:
                        List<User> users = userController.getAllUsers();
                        for (User user : users) {
                            System.out.println("ID: " + user.getId() + ", Nombre: " + user.getFname() + " " + user.getLname() + ", Dirección: " + user.getAddress());
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese el ID del usuario a buscar: ");
                        int id = shell.nextInt();
                        shell.nextLine();
                        User queriedUser = userController.getUserById(id);
                        if (queriedUser != null) {
                            System.out.println("Usuario " + id + " - ID: " + queriedUser.getId() + ", Nombre: " + queriedUser.getFname());
                        } else {
                            System.out.println("El usuario no existe");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del usuario a ingresar: ");
                        String fname = shell.nextLine();
                        System.out.print("Ingrese el apellido del usuario a ingresar: ");
                        String lname = shell.nextLine();
                        System.out.print("Ingrese la dirección del usuario a ingresar: ");
                        String address = shell.nextLine();
                        User user = new User(fname, lname, address);
                        userController.createUser(user);
                        System.out.println("Usuario ingresado correctamente");
                        break;
                    case 4:
                        System.out.print("Ingrese el ID del usuario a eliminar: ");
                        int deleteId = shell.nextInt();
                        shell.nextLine();
                        userController.deleteUser(deleteId);
                        System.out.println("Usuario eliminado correctamente");
                        break;
                    case 5:
                        System.out.print("Ingrese el ID del usuario a actualizar: ");
                        int updateId = shell.nextInt();
                        shell.nextLine();
                        System.out.print("Ingrese el nombre del usuario a actualizar: ");
                        String updateFname = shell.nextLine();
                        System.out.print("Ingrese el apellido del usuario a actualizar: ");
                        String updateLname = shell.nextLine();
                        System.out.print("Ingrese la dirección del usuario a actualizar: ");
                        String updateAddress = shell.nextLine();
                        User updateUser = new User(updateId, updateFname, updateLname, updateAddress);
                        userController.updateUser(updateUser);
                        System.out.println("Usuario actualizado correctamente");
                        break;
                    case 6:
                        // Salir del programa
                        conn.close();
                        shell.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
