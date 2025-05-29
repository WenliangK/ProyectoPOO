package dao;

import BusinessEntity.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IBaseDAO<Cliente> {

    @Override
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, dni, direccion, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDni());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertando cliente: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre=?, dni=?, direccion=?, telefono=? WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDni());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getTelefono());
            stmt.setInt(5, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando cliente: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente obtener(int id) {
        String sql = "SELECT * FROM clientes WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"),
                        rs.getString("direccion"), rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo cliente: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"),
                        rs.getString("direccion"), rs.getString("telefono")));
            }
        } catch (SQLException e) {
            System.out.println("Error listando clientes: " + e.getMessage());
        }
        return lista;
    }
}
