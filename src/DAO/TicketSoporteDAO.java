package DAO;

import dao.Conexion;
import BusinessEntity.TicketSoporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketSoporteDAO implements dao.IBaseDAO<TicketSoporte> {

    @Override
    public void insertar(TicketSoporte ticket) {
        String sql = "INSERT INTO tickets (descripcion, estado, fechaRegistro, clienteId, empleadoId) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ticket.getDescripcion());
            stmt.setString(2, ticket.getEstado());
            stmt.setString(3, ticket.getFechaRegistro());
            stmt.setInt(4, ticket.getClienteId());
            stmt.setInt(5, ticket.getEmpleadoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertando ticket: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(TicketSoporte ticket) {
        String sql = "UPDATE tickets SET descripcion=?, estado=?, fechaRegistro=?, clienteId=?, empleadoId=? WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ticket.getDescripcion());
            stmt.setString(2, ticket.getEstado());
            stmt.setString(3, ticket.getFechaRegistro());
            stmt.setInt(4, ticket.getClienteId());
            stmt.setInt(5, ticket.getEmpleadoId());
            stmt.setInt(6, ticket.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando ticket: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM tickets WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando ticket: " + e.getMessage());
        }
    }

    @Override
    public TicketSoporte obtener(int id) {
        String sql = "SELECT * FROM tickets WHERE id=?";
        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TicketSoporte(rs.getInt("id"), rs.getString("descripcion"),
                        rs.getString("estado"), rs.getString("fechaRegistro"),
                        rs.getInt("clienteId"), rs.getInt("empleadoId"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo ticket: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TicketSoporte> listar() {
        List<TicketSoporte> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new TicketSoporte(rs.getInt("id"), rs.getString("descripcion"),
                        rs.getString("estado"), rs.getString("fechaRegistro"),
                        rs.getInt("clienteId"), rs.getInt("empleadoId")));
            }
        } catch (SQLException e) {
            System.out.println("Error listando tickets: " + e.getMessage());
        }
        return lista;
    }
}
