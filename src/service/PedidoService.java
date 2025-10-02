package service;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService implements IPedidoService{

    private final List<Pedido> pedidos;

    public PedidoService(){
        this.pedidos = new ArrayList<Pedido>();
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    @Override
    public Pedido crearPedido() {
        Pedido pedido;
        pedido = new Pedido();
        return pedido;
    }
}
