package Model;

import java.util.ArrayList;

public class CarritoCompra {
    private ArrayList<ProductoElectrodomestico> productos;
    private Inventario inventario;
    private ProductoElectrodomestico productoActual;

    public CarritoCompra(Inventario inventario) {
        this.productos = new ArrayList<>();
        this.inventario = inventario;
    }

    public void agregarProducto(ProductoElectrodomestico producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombreProducto)) {
                productos.remove(i);
                return;
            }
        }
    }

    public void mostrarProductos() {
        for (ProductoElectrodomestico producto : productos) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
    }
    

    public ArrayList<ProductoElectrodomestico> getProductos() {
        return productos;
    }

    public void realizarCompra() {
        for (ProductoElectrodomestico productoCarrito : productos) {
            ProductoElectrodomestico productoInventario = inventario.buscarProductoEnInventario(productoCarrito.getNombre());
            if (productoInventario != null) {
                inventario.actualizarInventario(new ProductoElectrodomestico(productoInventario.getNombre(), productoInventario.getPrecio()));
            }
        }
        productos.clear();
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    
    public void setProductoActual(ProductoElectrodomestico productoActual) {
        this.productoActual = productoActual;
    }

    public ProductoElectrodomestico getProductoActual() {
        return this.productoActual;
    }

  
}
