package dao;

import BusinessEntity.ComprobanteCompra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComprobanteCompraDAO implements IBaseDAO<ComprobanteCompra> {

    @Override
    public void insertar(ComprobanteCompra comprobante) {
        String sql = "INSERT INTO comprobantes (fecha, montoTotal) VALUES (?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, comprobante.getFecha());
            stmt.setDouble(2, comprobante.getMontoTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertando comprobante: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(ComprobanteCompra comprobante) {
        String sql = "UPDATE comprobantes SET fecha=?, montoTotal=? WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, comprobante.getFecha());
            stmt.setDouble(2, comprobante.getMontoTotal());
            stmt.setInt(3, comprobante.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando comprobante: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM comprobantes WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando comprobante: " + e.getMessage());
        }
    }

    @Override
    public ComprobanteCompra obtener(int id) {
        String sql = "SELECT * FROM comprobantes WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ComprobanteCompra(rs.getInt("id"), rs.getString("fecha"), rs.getDouble("montoTotal"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo comprobante: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ComprobanteCompra> listar() {
        List<ComprobanteCompra> lista = new ArrayList<>();
        String sql = "SELECT * FROM comprobantes";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new ComprobanteCompra(rs.getInt("id"), rs.getString("fecha"), rs.getDouble("montoTotal")));
            }
        } catch (SQLException e) {
            System.out.println("Error listando comprobantes: " + e.getMessage());
        }
        return lista;
    }
}
