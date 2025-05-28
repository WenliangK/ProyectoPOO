package tienda;

import java.sql.*;

import java.util.ArrayList;


public  class ProductoDAO {

    private CategoriaDAO categoriaDAO = new CategoriaDAO();


    public ArrayList<Producto> listarProductos() {

        ArrayList<Producto> lista = new ArrayList<>();

        String sql = "SELECT p.*, c.nombre AS cat_nombre FROM productos p JOIN categorias c ON p.categoria_id = c.id";


        try (Connection conn = Conexion.conectar();

             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {

                Categoria cat = new Categoria(rs.getInt("categoria_id"), rs.getString("cat_nombre"));

                Producto p = new Producto(rs.getInt("id"), rs.getString("nombre"), cat, rs.getDouble("precio"), rs.getInt("stock"));

                lista.add(p);

            }
        } catch (SQLException e) {

            System.out.println("Error listando productos: " + e.getMessage());

        }
        return lista;

    }

    public void insertarProducto(Producto p) {

        String sql = "INSERT INTO productos(nombre, categoria_id, precio, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());

            stmt.setInt(2, p.getCategoria().getId());

            stmt.setDouble(3, p.getPrecio());

            stmt.setInt(4, p.getStock());

            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Error insertando producto: " + e.getMessage());

        }
    }
}