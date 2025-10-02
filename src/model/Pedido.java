package model;

import exception.StockInsuficienteException;

import java.util.ArrayList;

public class Pedido {
    private static int contadorId = 1;
    private final int id;
    private final ArrayList<Producto> productos;

    // Constructor
    public Pedido() {
        this.id = contadorId++;
        this.productos = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // Agregar producto al pedido
    public void agregarProducto(Producto producto) throws StockInsuficienteException {
        int stock = producto.getStock();
        if (stock <= 0) {throw new StockInsuficienteException(producto);}
        productos.add(producto);
        producto.setStock(stock-1);
    }

    // Calcular total del pedido
    public double calcularTotal() {
        double total = 0.0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    // Mostrar pedido
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(id).append("\n");
        sb.append("Productos:\n");
        for (Producto p : productos) {
            sb.append(" - ").append(p.getNombre())
                    .append(" ($").append(p.getPrecio()).append(")\n");
        }
        sb.append("Total: $").append(calcularTotal());
        return sb.toString();
    }
}