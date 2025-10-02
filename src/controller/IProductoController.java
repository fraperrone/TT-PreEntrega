package controller;
import model.Producto;

public interface IProductoController {

    public void agregarProducto();

    public void listarProductos();

    public void buscarActualizarProducto();

    public void eliminarProducto();

    public Producto buscarProductoPorId();
}
