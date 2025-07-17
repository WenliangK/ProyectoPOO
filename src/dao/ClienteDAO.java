package dao;

import BusinessEntity.Cliente;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nombre, correo, telefono) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getCorreo());
            stmt.setString(3, cliente.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> obtenerTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener clientes: " + e.getMessage());
        }
        return lista;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar cliente: " + e.getMessage());
        }
    }
}

