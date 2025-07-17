package dao;

import BusinessEntity.Empleado;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {

    public Empleado login(String usuario, String contrasena) {
        String sql = "SELECT * FROM Empleado WHERE usuario = ? AND contrasena = ?";
        Empleado emp = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                emp = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("usuario"),
                        rs.getString("contrasena")
                );
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al iniciar sesión: " + e.getMessage());
        }

        return emp;
    }
}
