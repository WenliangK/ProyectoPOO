package Controller;

import dao.EmpleadoDAO;
import BusinessEntity.Empleado;
import java.util.List;

public class EmpleadoController {
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public boolean registrarEmpleado(Empleado empleado) {
        return empleadoDAO.insertar(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoDAO.obtenerTodos();
    }

    public Empleado buscarPorId(int id) {
        return empleadoDAO.obtenerPorId(id);
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        return empleadoDAO.actualizar(empleado);
    }

    public boolean eliminarEmpleado(int id) {
        return empleadoDAO.eliminar(id);
    }
}
