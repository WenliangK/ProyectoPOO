package dao;

import BusinessEntity.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements IBaseDAO<Empleado> {

    @Override
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleados (nombre, dni, cargo) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getDni());
            stmt.setString(3, empleado.getCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertando empleado: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Empleado empleado) {
        String sql = "UPDATE empleados SET nombre=?, dni=?, cargo=? WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getDni());
            stmt.setString(3, empleado.getCargo());
            stmt.setInt(4, empleado.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando empleado: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando empleado: " + e.getMessage());
        }
    }

    @Override
    public Empleado obtener(int id) {
        String sql = "SELECT * FROM empleados WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"), rs.getString("cargo"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo empleado: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"), rs.getString("cargo")));
            }
        } catch (SQLException e) {
            System.out.println("Error listando empleados: " + e.getMessage());
        }
        return lista;
    }
}
