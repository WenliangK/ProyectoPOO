package tienda;

import java.sql.*;

import java.util.ArrayList;


public class CategoriaDAO {


    public ArrayList<Categoria> obtenerCategorias() {

        ArrayList<Categoria> lista = new ArrayList<>();

        String sql = "SELECT * FROM categorias";


        try (Connection conn = Conexion.conectar();

             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {

                lista.add(new Categoria(rs.getInt("id"), rs.getString("nombre")));

            }
        } catch (SQLException e) {

            System.out.println("Error cargando categorías: " + e.getMessage());

        }

        return lista;

    }
}