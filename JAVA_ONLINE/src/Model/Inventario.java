package Model;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<ProductoElectrodomestico> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public ProductoElectrodomestico buscarProductoEnInventario(String nombreProducto) {
        for (ProductoElectrodomestico producto : productos) {
            if (producto.getNombre() == nombreProducto) {
                return producto;
            }
        }
        return null; 
    }

   
    public void agregarProducto(ProductoElectrodomestico producto) {
        productos.add(producto);
    }

    
    public void actualizarInventario(ProductoElectrodomestico producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre() == producto.getNombre()) {
                productos.get(i).setPrecio(producto.getPrecio());
                return;
            }
        }
    }


    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre() == nombreProducto) {
                productos.remove(i);
                return;
            }
        }
    }

   public ArrayList<ProductoElectrodomestico> getProductos() {
        return productos;
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (ProductoElectrodomestico producto : productos) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
        }
    }
  
}
