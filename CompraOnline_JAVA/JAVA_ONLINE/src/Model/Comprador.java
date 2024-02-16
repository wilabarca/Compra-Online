package Model;

import java.util.Scanner;

public class Comprador {
    private CarritoCompra carrito;
    private String contrasena;
    private String usuario;

    public Comprador(String usuarioComprador, String contrasenaComprador) {
        this.usuario = usuarioComprador;
        this.contrasena = contrasenaComprador;
        this.carrito = new CarritoCompra(new Inventario());
    }

   
    public String getNombreUsuario() {
        return usuario;
    }

    public void agregarProductoAlCarrito(ProductoElectrodomestico producto) {
        carrito.agregarProducto(producto);
    }

    public void eliminarProductoDelCarrito(String nombreProducto) {
        carrito.eliminarProducto(nombreProducto);
    }

    public void realizarCompra() {
        carrito.realizarCompra();
    }

    public void mostrarProductosEnCarrito() {
        carrito.mostrarProductos();
    }

    public ProductoElectrodomestico getProductoActual() {
        return carrito.getProductoActual();
    }

    public void setProductoActual(ProductoElectrodomestico productoActual) {
        carrito.setProductoActual(productoActual);
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }

}
