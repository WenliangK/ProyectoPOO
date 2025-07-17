package dao;

import BusinessEntity.VentaDetalle;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentaDetalleDAO {

    public void registrar(VentaDetalle detalle) {
        String sql = "INSERT INTO VentaDetalle (id_venta, id_producto, cantidad, subtotal) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, detalle.getIdVenta());
            stmt.setInt(2, detalle.getIdProducto());
            stmt.setInt(3, detalle.getCantidad());
            stmt.setDouble(4, detalle.getSubtotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("❌ Error al registrar detalle de venta: " + e.getMessage());
        }
    }
}
