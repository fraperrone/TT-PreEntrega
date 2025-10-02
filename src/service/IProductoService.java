package service;

import exception.ProductoNoEncontradoException;
import model.Producto;

import java.util.List;

public interface IProductoService {

    void agregarProducto(Producto producto);
    List<Producto> listarProductos();
    boolean eliminarProducto(int idProducto);

    void actualizarProducto(Producto producto, String nuevoNombre, double nuevoPrecio, int nuevoStock);

    Producto buscarProductoPorId(int idProducto) throws ProductoNoEncontradoException;
}
