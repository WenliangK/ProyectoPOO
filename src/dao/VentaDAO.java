package dao;

import BusinessEntity.Venta;
import util.Conexion;

import java.sql.*;

public class VentaDAO {

    public int registrar(Venta venta) {
        String sql = "INSERT INTO Venta (id_cliente, fecha, total) VALUES (?, ?, ?)";
        int idGenerado = -1;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, venta.getIdCliente());
            stmt.setDate(2, Date.valueOf(venta.getFecha()));
            stmt.setDouble(3, venta.getMontoTotal()); // ← CORREGIDO

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al registrar venta: " + e.getMessage());
        }

        return idGenerado;
    }
}
