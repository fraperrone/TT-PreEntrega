package controller;

import model.Producto;
import service.IPedidoService;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoController implements IPedidoController {

    private final IPedidoService pedidoService;
    private final List<Pedido> pedidos = new ArrayList<Pedido>();
    private final Scanner scanner;
    private final IProductoController productoController;

    public PedidoController(IPedidoService pedidoService, Scanner scanner, IProductoController productoController){
       this.pedidoService = pedidoService;
       this.scanner = scanner;
       this.productoController = productoController;
    }

    @Override
    public void crearPedido() {
        Pedido pedido = pedidoService.crearPedido();
        String opcion;
        do{
            System.out.println("Desea agregar producto?s/n");
            opcion = scanner.nextLine();
            if(opcion.equalsIgnoreCase("s")){
                //logica para agregar productos
                Producto producto = productoController.buscarProductoPorId();
                if(producto != null){

                    /// Falta mejorar capa para que lo haga a la service
                    /// FALTA tratamiento excepction

                        pedido.agregarProducto(producto);
                        System.out.println("Producto Agregado");


                }

            }
        }while(!opcion.equalsIgnoreCase("n"));

        //agregamos el pedido a la lista de pedidos
        pedidos.add(pedido);


    }

    @Override
    public void listarPedidos() {
        System.out.println("Pedidos:");
        System.out.println(pedidos);
    }

    @Override
    public void agregarProductoAlPedido() {

    }


}
