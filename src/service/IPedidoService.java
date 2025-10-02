package service;

import model.Pedido;

import java.util.List;

public interface IPedidoService {

    List<Pedido> listarPedidos();

    Pedido crearPedido();

}
