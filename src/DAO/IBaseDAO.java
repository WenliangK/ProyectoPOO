package dao;

import java.util.List;

public interface IBaseDAO<T> {
    void insertar(T entidad);
    void actualizar(T entidad);
    void eliminar(int id);
    T obtener(int id);
    List<T> listar();
}
