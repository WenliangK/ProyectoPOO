package dao;

import BusinessEntity.Categoria;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public void insertar(Categoria categoria) {
        String sql = "INSERT INTO Categoria (nombre) VALUES (?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar categoría: " + e.getMessage());
        }
    }

    public List<Categoria> obtenerTodas() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Categoria(rs.getInt("id_categoria"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener categorías: " + e.getMessage());
        }
        return lista;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Categoria WHERE id_categoria = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar categoría: " + e.getMessage());
        }
    }
}