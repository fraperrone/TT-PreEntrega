package exception;

import model.Producto;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(Producto producto) {

        super("Sin stock de: "+producto);
    }
}
