package DAO;

import BusinessEntity.TicketSoporte;
import java.util.List;
import java.util.ArrayList;

public class TicketSoporteDAO implements IBaseDAO<TicketSoporte> {
    @Override
    public void insertar(TicketSoporte ticket) {
        // Lógica de inserción
    }

    @Override
    public void actualizar(TicketSoporte ticket) {
        // Lógica de actualización
    }

    @Override
    public void eliminar(int id) {
        // Lógica de eliminación
    }

    @Override
    public TicketSoporte obtener(int id) {
        // Lógica para obtener ticket
        return null;
    }

    @Override
    public List<TicketSoporte> listar() {
        // Lógica para listar tickets
        return new ArrayList<>();
    }
}