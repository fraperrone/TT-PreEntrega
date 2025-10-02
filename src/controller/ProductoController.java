package controller;

import exception.ProductoNoEncontradoException;
import model.Producto;
import service.IProductoService;

import java.util.List;
import java.util.Scanner;

public class ProductoController implements IProductoController {


    private final IProductoService productoService;
    private final Scanner scanner;

    public ProductoController(IProductoService productoService, Scanner scanner){
        this.productoService = productoService;
        this.scanner = scanner;
    }

    @Override
    public void agregarProducto() {
        System.out.println("Ingrese nombre del producto:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese precio del producto:");
        Double precio = scanner.nextDouble();

        System.out.println("Ingrese stock del producto:");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(nombre,precio,stock);
        productoService.agregarProducto(producto);
        System.out.println("Producto agregado exitosamente");

    }

    @Override
    public void listarProductos() {
        List<Producto> productos = productoService.listarProductos();
        System.out.println("productos = " + productos);
    }

    @Override
    public void buscarActualizarProducto() {
        System.out.println("ingrese id del producto");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Producto productoBuscado = productoService.buscarProductoPorId(id);
            System.out.println("ingrese nuevo nombre");
            String nuevoNombre = scanner.nextLine();
            System.out.println("ingrese precio");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Ingrese Stock");
            int nuevoStock = scanner.nextInt();
            scanner.nextLine();
            productoService.actualizarProducto(productoBuscado,nuevoNombre, nuevoPrecio, nuevoStock);

        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarProducto() {
        System.out.println("Ingrese id");
        int id = scanner.nextInt();
        boolean resultado = productoService.eliminarProducto(id);
        if(resultado){
           System.out.println("Producto Eliminado");
        }else {
           System.out.println("Producto no encontrado");
        }
    }


    @Override
    public Producto buscarProductoPorId() {
        System.out.println("ingrese id del producto");
        int id = scanner.nextInt();
        scanner.nextLine();
        Producto producto = null;
        try {
            producto = productoService.buscarProductoPorId(id);
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
        return producto;
    }
}
