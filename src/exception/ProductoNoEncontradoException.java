package exception;

public class ProductoNoEncontradoException extends Exception{
    public ProductoNoEncontradoException(int id){
        super("Producto con ID: " + id + " NO ENCONTRADO");
    }
}
