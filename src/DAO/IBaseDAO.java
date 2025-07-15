package dao;

import java.util.List;

public interface IBaseDAO<T> {
    void insertar(T t);
    void actualizar(T t);
    void eliminar(int id);
    T obtener(int id);
    List<T> listar();
}