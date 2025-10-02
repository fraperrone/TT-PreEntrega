package view;

import controller.IPedidoController;
import controller.IProductoController;

import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner;
    private final IProductoController productoController;
    private final IPedidoController pedidoController;

    public MenuPrincipal(Scanner scanner, IProductoController productoController, IPedidoController pedidoController){
        this.scanner = scanner;
        this.productoController = productoController;
        this.pedidoController = pedidoController;
    }

    public void inicar(){
        int opcion;
        do{
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion);
        } while(opcion != 0);
    }

    public void mostrarMenu(){
            System.out.println("=================================== SISTEMA DE GESTIÓN - TECHLAB ==================================");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");
            System.out.print("\nElija una opción: ");
    }

    public int leerOpcion(){
        while(!scanner.hasNextInt()){
            System.out.println("Entrada invalida, ingrese nuevamente");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1 -> productoController.agregarProducto();
            case 2 -> productoController.listarProductos();
            case 3 -> productoController.buscarActualizarProducto();
            case 4 -> productoController.eliminarProducto();
            case 5 -> pedidoController.crearPedido();
            case 6 -> pedidoController.listarPedidos();
            case 7 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opcion incorrecta.");

        }
    }

}
