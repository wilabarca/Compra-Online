package Model;
import java.util.ArrayList;
import Model.CarritoCompra;
import Model.ProductoElectrodomestico;

public class TicketDePago {
    private CarritoCompra carritoCompra;  

    public TicketDePago(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    
    public double obtenerTotal() {
        ArrayList<ProductoElectrodomestico> productosEnCarrito = carritoCompra.getProductos();
        double total = 0;

        for (ProductoElectrodomestico producto : productosEnCarrito) {
            total += producto.getPrecio();
        }

        return total;
    }

    
    public ArrayList<ProductoElectrodomestico> obtenerProductos() {
        return carritoCompra.getProductos();
    }

  
    public void imprimirTicket() {
        System.out.println("---- Ticket de Pago ----");
        System.out.println("Productos:");

        for (ProductoElectrodomestico producto : carritoCompra.getProductos()) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }

        System.out.println("Total: " + obtenerTotal());
        System.out.println("Gracias por su compra!");
    }
}
