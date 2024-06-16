package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Producto;

public interface ProductoDao {

    void insertar(Producto producto) throws SQLException;

    void actualizar(Producto producto);

    void eliminar(int codigoProducto);

    Producto mostrarporcodigoProducto(int codigoProducto);

    List<Producto> obtenerTodos();

}
