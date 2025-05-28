package tienda.dao;

import tienda.Cliente;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAO implements IBaseDAO<Cliente> {
    @Override
    public void insertar(Cliente cliente) {
        // Lógica de inserción
    }

    @Override
    public void actualizar(Cliente cliente) {
        // Lógica de actualización
    }

    @Override
    public void eliminar(int id) {
        // Lógica de eliminación
    }

    @Override
    public Cliente obtener(int id) {
        // Lógica para obtener cliente
        return null;
    }

    @Override
    public List<Cliente> listar() {
        // Lógica para listar clientes
        return new ArrayList<>();
    }
}