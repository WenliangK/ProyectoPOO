package Controller;

import dao.ProductoDAO;
import BusinessEntity.Producto;

import java.util.List;

public class ProductoController {
    private ProductoDAO productoDAO = new ProductoDAO();

    public void registrarProducto(Producto producto) {
        productoDAO.insertar(producto);
    }

    public List<Producto> listarProductos() {
        return productoDAO.obtenerTodos();
    }

    public void eliminarProducto(int id) {
        productoDAO.eliminar(id);
    }
}
