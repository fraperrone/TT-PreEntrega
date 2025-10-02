package service;

import model.Producto;
import exception.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoService implements IProductoService{

    private final List<Producto> productos = new ArrayList<>();

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productos;
    }

    @Override
    public boolean eliminarProducto(int idProducto) {
            return productos.removeIf( p -> p.getId() == idProducto);
    }


    @Override
    public void actualizarProducto(Producto producto, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        producto.setStock(nuevoStock);
    }

    @Override
    public Producto buscarProductoPorId(int id) throws ProductoNoEncontradoException {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(()-> new ProductoNoEncontradoException(id));

    }
}
