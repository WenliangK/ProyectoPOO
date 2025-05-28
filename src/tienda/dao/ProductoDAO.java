package tienda.dao;

import tienda.Producto;
import java.util.List;
import java.util.ArrayList;

public class ProductoDAO implements IBaseDAO<Producto> {
    @Override
    public void insertar(Producto producto) {
        // Lógica de inserción
    }

    @Override
    public void actualizar(Producto producto) {
        // Lógica de actualización
    }

    @Override
    public void eliminar(int id) {
        // Lógica de eliminación
    }

    @Override
    public Producto obtener(int id) {
        // Lógica para obtener producto
        return null;
    }

    @Override
    public List<Producto> listar() {
        // Lógica para listar productos
        return new ArrayList<>();
    }
}