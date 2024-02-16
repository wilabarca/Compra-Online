import java.util.Scanner;

import Model.Administrador;
import Model.CarritoCompra;
import Model.Comprador;
import Model.Inventario;
import Model.ProductoElectrodomestico;
import Model.TicketDePago;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String usuarioComprador = "abarca";
        String contrasenaComprador = "abarca";
        String usuarioAdministrador = "admin";
        String contrasenaAdministrador = "adminpass";

        System.out.println("Seleccione el tipo de usuario (comprador/administrador): ");
        String tipoUsuario = scanner.next();

        if (compararCadenas(tipoUsuario, "comprador")) {
            System.out.println("Ingrese el usuario de comprador: ");
            String usuarioInput = scanner.next();
            System.out.println("Ingrese la contraseña de comprador: ");
            String contrasenaInput = scanner.next();

            if (compararCadenas(usuarioComprador, usuarioInput) && compararCadenas(contrasenaComprador, contrasenaInput)) {
                Comprador comprador = new Comprador(usuarioComprador, contrasenaComprador);
                comprador.agregarProductoAlCarrito(new ProductoElectrodomestico("Lavadora", 400.0));
                comprador.agregarProductoAlCarrito(new ProductoElectrodomestico("Televisor", 300.0));
                comprador.agregarProductoAlCarrito(new ProductoElectrodomestico("Mauz", 423.0));
                menuComprador(comprador, scanner);
            } else {
                System.out.println("Usuario o contraseña incorrectos para comprador. Saliendo del programa.");
            }
        } else if (compararCadenas(tipoUsuario, "administrador")) {
            System.out.println("Ingrese el usuario de administrador: ");
            String usuarioInput = scanner.next();
            System.out.println("Ingrese la contraseña de administrador: ");
            String contrasenaInput = scanner.next();

            if (compararCadenas(usuarioAdministrador, usuarioInput) && compararCadenas(contrasenaAdministrador, contrasenaInput)) {
                Inventario inventario = new Inventario();
                Administrador administrador = new Administrador(usuarioAdministrador, contrasenaAdministrador, inventario);
                administrador.agregarProducto(new ProductoElectrodomestico("Lavadora", 400.0));
                administrador.agregarProducto(new ProductoElectrodomestico("Televisor", 300.0));
                menuAdministrador(administrador, null, scanner);
            } else {
                System.out.println("Usuario o contraseña incorrectos para administrador. Saliendo del programa.");
            }
        } else {
            System.out.println("Tipo de usuario no válido. Saliendo del programa.");
        }
    }

    private static boolean compararCadenas(String cadena1, String cadena2) {
        return cadena1.compareTo(cadena2) == 0;
    }

    private static void menuComprador(Comprador comprador, Scanner scanner) {
        int opcion;

        do {
            System.out.println("Menú Comprador:");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Eliminar producto del carrito");
            System.out.println("3. Realizar compra");
            System.out.println("4. Mostrar productos en el carrito");
            System.out.println("5. Generar ticket de pago");
            System.out.println("6. Salir");
            System.out.println("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del producto a agregar al carrito: ");
                    String nombreProductoAgregar = scanner.next();
                    System.out.println("Ingrese el precio del producto: ");
                    double precioProductoAgregar = scanner.nextDouble();
                    comprador.agregarProductoAlCarrito(new ProductoElectrodomestico(nombreProductoAgregar, precioProductoAgregar));
                    System.out.println("Producto agregado al carrito.");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto a eliminar del carrito: ");
                    String nombreProductoEliminar = scanner.next();
                    comprador.eliminarProductoDelCarrito(nombreProductoEliminar);
                    System.out.println("Producto eliminado del carrito.");
                    break;
                case 3:
                    comprador.realizarCompra();
                    System.out.println("Compra realizada.");
                    break;
                case 4:
                    comprador.mostrarProductosEnCarrito();
                    break;
                case 5:
                    generarTicket(comprador.getCarrito());
                    break;
                case 6:
                    System.out.println("Saliendo del menú de comprador.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void menuAdministrador(Administrador administrador, Comprador comprador, Scanner scanner) {
        int opcion;

        do {
            System.out.println("Menú Administrador:");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Eliminar producto del inventario");
            System.out.println("3. Actualizar precio de un producto");
            System.out.println("4. Procesar compra");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.println("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del producto a agregar al inventario: ");
                    String nombreProductoAgregar = scanner.next();
                    System.out.println("Ingrese el precio del producto: ");
                    double precioProductoAgregar = scanner.nextDouble();
                    administrador.agregarProducto(new ProductoElectrodomestico(nombreProductoAgregar, precioProductoAgregar));
                    System.out.println("Producto agregado al inventario.");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto a eliminar del inventario: ");
                    String nombreProductoEliminar = scanner.next();
                    administrador.eliminarProducto(nombreProductoEliminar);
                    System.out.println("Producto eliminado del inventario.");
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto cuyo precio desea actualizar: ");
                    String nombreProductoActualizar = scanner.next();
                    System.out.println("Ingrese el nuevo precio del producto: ");
                    double nuevoPrecioProducto = scanner.nextDouble();
                    administrador.actualizarProducto(nombreProductoActualizar, nuevoPrecioProducto);
                    break;
                case 4:
                    administrador.procesarCompra(comprador);
                    System.out.println("Compra procesada.");
                    break;
                case 5:
                    administrador.getInventario().mostrarInventario();
                    break;
                case 6:
                    System.out.println("Saliendo del menú de administrador.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void generarTicket(CarritoCompra carritoCompra) {
        TicketDePago ticketDePago = new TicketDePago(carritoCompra);
        ticketDePago.imprimirTicket();
    }
}
