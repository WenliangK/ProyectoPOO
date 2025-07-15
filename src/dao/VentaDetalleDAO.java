package dao;

import model.VentaDetalle;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentaDetalleDAO {

    public void registrar(VentaDetalle detalle) {
        String sqlDetalle = "INSERT INTO VentaDetalle (id_venta, id_producto, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        String sqlStock = "UPDATE Producto SET stock = stock - ? WHERE id_producto = ?";

        try (Connection conn = Conexion.getConnection()) {
            conn.setAutoCommit(false); // Comenzar transacción

            try (PreparedStatement stmtDetalle = conn.prepareStatement(sqlDetalle);
                 PreparedStatement stmtStock = conn.prepareStatement(sqlStock)) {

                // Insertar detalle
                stmtDetalle.setInt(1, detalle.getIdVenta());
                stmtDetalle.setInt(2, detalle.getIdProducto());
                stmtDetalle.setInt(3, detalle.getCantidad());
                stmtDetalle.setDouble(4, detalle.getSubtotal());
                stmtDetalle.executeUpdate();

                // Actualizar stock del producto
                stmtStock.setInt(1, detalle.getCantidad());
                stmtStock.setInt(2, detalle.getIdProducto());
                stmtStock.executeUpdate();

                conn.commit(); // Confirmar transacción
                System.out.println("✅ Detalle registrado y stock actualizado.");
            } catch (SQLException e) {
                conn.rollback(); // Deshacer si hay error
                System.err.println("❌ Error al registrar detalle: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("❌ Error de conexión: " + e.getMessage());
        }
    }
}
