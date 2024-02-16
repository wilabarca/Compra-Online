package Model;

public class Administrador {
    private String usuario;
    private String contrasena;
    private Inventario inventario;

    public Administrador(String usuario, String contrasena, Inventario inventario) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.inventario = inventario;
    }

    public void agregarProducto(ProductoElectrodomestico producto) {
        inventario.agregarProducto(producto);
        System.out.println("Producto '" + producto.getNombre() + "' agregado al inventario por el administrador.");
    }

    public void eliminarProducto(String nombreProducto) {
        inventario.eliminarProducto(nombreProducto);
        System.out.println("Producto '" + nombreProducto + "' eliminado del inventario por el administrador.");
    }

    public void actualizarProducto(String nombreProducto, double nuevoPrecio) {
        ProductoElectrodomestico producto = obtenerProducto(nombreProducto);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio del producto '" + nombreProducto + "' actualizado a $" + nuevoPrecio + " por el administrador.");
        } else {
            System.out.println("El producto '" + nombreProducto + "' no está en el inventario.");
        }
    }

    public void procesarCompra(Comprador comprador) {
        System.out.println("Compra procesada para el comprador " + comprador.getNombreUsuario() + " por el administrador.");
    }

    private ProductoElectrodomestico obtenerProducto(String nombreProducto) {
        for (ProductoElectrodomestico producto : inventario.getProductos()) {
            if (producto.getNombre() == nombreProducto) {
                return producto;
            }
        }
        return null;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
