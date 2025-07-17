package Controller;

import dao.EmpleadoDAO;
import BusinessEntity.Empleado;

public class EmpleadoController {
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public Empleado login(String user, String pass) {
        return empleadoDAO.login(user, pass);
    }
}
