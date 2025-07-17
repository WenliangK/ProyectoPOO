package Controller;

import dao.ClienteDAO;
import BusinessEntity.Cliente;
import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void registrarCliente(Cliente cliente) {
        clienteDAO.insertar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.obtenerTodos();
    }

    public void eliminarCliente(int id) {
        clienteDAO.eliminar(id);
    }
}
