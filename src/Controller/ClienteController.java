package Controller;

import dao.ClienteDAO;
import BusinessEntity.Cliente;
import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public boolean registrarCliente(Cliente cliente) {
        return clienteDAO.insertar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.obtenerTodos();
    }

    public Cliente buscarPorId(int id) {
        return clienteDAO.obtenerPorId(id);
    }

    public boolean actualizarCliente(Cliente cliente) {
        return clienteDAO.actualizar(cliente);
    }

    public boolean eliminarCliente(int id) {
        return clienteDAO.eliminar(id);
    }
}
