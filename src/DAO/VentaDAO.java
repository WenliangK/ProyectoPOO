package dao;

import BusinessEntity.Venta;
import util.Conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAO {

    // Registra una venta y retorna el ID generado
    public int registrar(Venta venta) {
        String sql = "INSERT INTO Venta (id_cliente, fecha, total) VALUES (?, ?, ?)";
        int idGenerado = -1;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, venta.getIdCliente());
            stmt.setDate(2, Date.valueOf(venta.getFecha()));
            stmt.setDouble(3, venta.getTotal());

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
