package tienda.dao;

import tienda.Empleado;
import java.util.List;
import java.util.ArrayList;

public class EmpleadoDAO implements IBaseDAO<Empleado> {
    @Override
    public void insertar(Empleado empleado) {
        // Lógica de inserción
    }

    @Override
    public void actualizar(Empleado empleado) {
        // Lógica de actualización
    }

    @Override
    public void eliminar(int id) {
        // Lógica de eliminación
    }

    @Override
    public Empleado obtener(int id) {
        // Lógica para obtener empleado
        return null;
    }

    @Override
    public List<Empleado> listar() {
        // Lógica para listar empleados
        return new ArrayList<>();
    }
}