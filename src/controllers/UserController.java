package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserController {
    private Connection conn;

    public UserController(Connection conn) {
        this.conn = conn;
    }

    // Método para obtener todos los usuarios de la base de datos
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM customer LIMIT 100";

        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id_customer");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String address = rs.getString("address_customer");
                User user = new User(id, fname, lname, address);
                users.add(user);
            }
        }

        return users;
    }

    // Otros métodos para crear, actualizar y eliminar usuarios

    public boolean createUser(User user) throws SQLException {
        String query = "INSERT INTO customer(first_name,last_name,address_customer) VALUES( ?, ?, ?);";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getFname());
            stmt.setString(2, user.getLname());
            stmt.setString(3, user.getAddress());

            int rowInserted = stmt.executeUpdate();
            return rowInserted > 0;
        }
    }

    public User getUserById(int id) throws SQLException {
        String query = "SELECT * FROM customer WHERE id_customer = ?";
        User user = null;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String fname = rs.getString("first_name");
                    String lname = rs.getString("last_name");
                    String address = rs.getString("address_customer");
                    user = new User(id, fname, lname, address);
                }
            }
        }

        return user;
    }

    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE customer SET first_name=?, last_name=?, address_customer=? WHERE `id_customer`=?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getFname());
            stmt.setString(2, user.getLname());
            stmt.setString(3, user.getAddress());
            stmt.setInt(4, user.getId());

            int rowUpdated = stmt.executeUpdate();
            return rowUpdated > 0;
        }
    }

    public boolean deleteUser(int id) throws SQLException {
        String query = "DELETE FROM `customer` WHERE `id_customer`=?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowDeleted = stmt.executeUpdate();
            return rowDeleted > 0;
        }
    }

}
