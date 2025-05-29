package Controller;

import dao.ProductoDAO;
import BusinessEntity.Producto;
import java.util.List;

public class ProductoController {
    private ProductoDAO productoDAO = new ProductoDAO();

    public boolean registrarProducto(Producto producto) {
        return productoDAO.insertar(producto);
    }

    public List<Producto> listarProductos() {
        return productoDAO.obtenerTodos();
    }

    public Producto buscarPorId(int id) {
        return productoDAO.obtenerPorId(id);
    }

    public boolean actualizarProducto(Producto producto) {
        return productoDAO.actualizar(producto);
    }

    public boolean eliminarProducto(int id) {
        return productoDAO.eliminar(id);
    }
}
