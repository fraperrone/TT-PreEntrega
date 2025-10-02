import java.awt.*;
import java.util.Scanner;

import controller.IPedidoController;
import controller.IProductoController;
import controller.PedidoController;
import controller.ProductoController;
import service.IPedidoService;
import service.IProductoService;
import service.PedidoService;
import service.ProductoService;
import view.MenuPrincipal;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IPedidoService pedidoService = new PedidoService();

        IProductoService productoService = new ProductoService();
        IProductoController productoController = new ProductoController(productoService, scanner);

        IPedidoController pedidoController = new PedidoController(pedidoService, scanner, productoController);


        MenuPrincipal menuPrincipal = new MenuPrincipal(scanner,productoController,pedidoController);

        menuPrincipal.inicar();

    }

}