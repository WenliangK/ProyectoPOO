package dao;

import model.Venta;
import util.Conexion;

import java.sql.*;
import java.time.LocalDate;

public class VentaDAO {

    public int registrar(Venta venta) {
        String sql = "INSERT INTO Venta (id_cliente, fecha, total) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, venta.getIdCliente());
            stmt.setDate(2, Date.valueOf(venta.getFecha()));
            stmt.setDouble(3, venta.getTotal());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int idVentaGenerada = rs.getInt(1);
                System.out.println("✅ Venta registrada con ID: " + idVentaGenerada);
                return idVentaGenerada;
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al registrar venta: " + e.getMessage());
        }
        return -1;
    }
}
