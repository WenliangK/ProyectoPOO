package DAO;

import BusinessEntity.ComprobanteCompra;

import java.util.List;
import java.util.ArrayList;

public class ComprobanteCompraDAO implements IBaseDAO<ComprobanteCompra> {
    @Override
    public void insertar(ComprobanteCompra c) {
        // Lógica de inserción
    } 

    @Override
    public void actualizar(ComprobanteCompra c) {
        // Lógica de actualización
    }

    @Override
    public void eliminar(int id) {
        // Lógica de eliminación
    }

    @Override
    public ComprobanteCompra obtener(int id) {
        // Lógica para obtener comprobante
        return null;
    }

    @Override
    public List<ComprobanteCompra> listar() {
        // Lógica para listar comprobantes
        return new ArrayList<>();
    }
}