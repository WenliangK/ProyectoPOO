package dao;

import BusinessEntity.Categoria;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public boolean insertar(Categoria categoria) {
        String sql = "INSERT INTO Categoria (nombre) VALUES (?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNombre());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar categoría: " + e.getMessage());
            return false;
        }
    }

    public List<Categoria> obtenerTodas() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria cat = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre")
                );
                lista.add(cat);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al listar categorías: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Categoria WHERE id_categoria = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar categoría: " + e.getMessage());
            return false;
        }
    }
}
