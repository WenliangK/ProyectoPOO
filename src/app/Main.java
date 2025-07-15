package app;

import dao.*;
import model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Login
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        System.out.println("🛡️ LOGIN DE EMPLEADO");
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        Empleado empleado = empleadoDAO.login(user, pass);
        if (empleado == null) {
            System.out.println("❌ Credenciales incorrectas. Saliendo...");
            return;
        }
        System.out.println("✅ Bienvenido, " + empleado.getNombre());

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        VentaDAO ventaDAO = new VentaDAO();
        VentaDetalleDAO detalleDAO = new VentaDetalleDAO();

        int opcion;
        do {
            System.out.println("\n🛍️ MENÚ PRINCIPAL");
            System.out.println("1. Gestión de categorías");
            System.out.println("2. Gestión de productos");
            System.out.println("3. Gestión de clientes");
            System.out.println("4. Registrar venta");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> menuCategorias(sc, categoriaDAO);
                case 2 -> menuProductos(sc, productoDAO);
                case 3 -> menuClientes(sc, clienteDAO);
                case 4 -> menuVentas(sc, clienteDAO, productoDAO, ventaDAO, detalleDAO);
                case 5 -> System.out.println("👋 Hasta luego.");
                default -> System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    // Categorías
    public static void menuCategorias(Scanner sc, CategoriaDAO dao) {
        int opcion;
        do {
            System.out.println("\n📁 GESTIÓN DE CATEGORÍAS");
            System.out.println("1. Registrar categoría");
            System.out.println("2. Listar categorías");
            System.out.println("3. Eliminar categoría");
            System.out.println("4. Volver");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    dao.insertar(new Categoria(nombre));
                }
                case 2 -> {
                    List<Categoria> lista = dao.obtenerTodas();
                    for (Categoria c : lista) {
                        System.out.println("→ " + c.getId() + " - " + c.getNombre());
                    }
                }
                case 3 -> {
                    System.out.print("ID de la categoría a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    dao.eliminar(id);
                }
                case 4 -> System.out.println("↩ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción inválida.");
            }

        } while (opcion != 4);
    }

    // Productos
    public static void menuProductos(Scanner sc, ProductoDAO dao) {
        int opcion;
        do {
            System.out.println("\n🛒 GESTIÓN DE PRODUCTOS");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Volver");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());
                    System.out.print("ID de categoría: ");
                    int idCat = Integer.parseInt(sc.nextLine());

                    dao.insertar(new Producto(nombre, precio, stock, idCat));
                }
                case 2 -> {
                    List<Producto> productos = dao.obtenerTodos();
                    for (Producto p : productos) {
                        System.out.println("→ " + p.getId() + " - " + p);
                    }
                }
                case 3 -> {
                    System.out.print("ID del producto a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    dao.eliminar(id);
                }
                case 4 -> System.out.println("↩ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción inválida.");
            }

        } while (opcion != 4);
    }

    // Clientes
    public static void menuClientes(Scanner sc, ClienteDAO dao) {
        int opcion;
        do {
            System.out.println("\n🧍 GESTIÓN DE CLIENTES");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Volver");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    dao.insertar(new Cliente(nombre, correo, telefono));
                }
                case 2 -> {
                    List<Cliente> lista = dao.obtenerTodos();
                    for (Cliente c : lista) {
                        System.out.println("→ " + c.getId() + " - " + c);
                    }
                }
                case 3 -> {
                    System.out.print("ID del cliente a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    dao.eliminar(id);
                }
                case 4 -> System.out.println("↩ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción inválida.");
            }

        } while (opcion != 4);
    }

    public static void menuVentas(Scanner sc, ClienteDAO clienteDAO, ProductoDAO productoDAO, VentaDAO ventaDAO, VentaDetalleDAO detalleDAO) {
        System.out.println("\n🧾 REGISTRAR VENTA");

        // 1. Seleccionar cliente
        System.out.println("Clientes disponibles:");
        List<Cliente> clientes = clienteDAO.obtenerTodos();
        for (Cliente c : clientes) {
            System.out.println("→ " + c.getId() + " - " + c);
        }
        System.out.print("ID del cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());

        // 2. Agregar productos al carrito
        List<Producto> carrito = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();
        double totalVenta = 0.0;
        boolean seguir;

        do {
            System.out.println("\nProductos disponibles:");
            List<Producto> productos = productoDAO.obtenerTodos();
            for (Producto p : productos) {
                System.out.println("→ " + p.getId() + " - " + p);
            }

            System.out.print("ID del producto: ");
            int idProducto = Integer.parseInt(sc.nextLine());
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            Producto seleccionado = productos.stream()
                    .filter(p -> p.getId() == idProducto)
                    .findFirst()
                    .orElse(null);

            if (seleccionado != null) {
                carrito.add(seleccionado);
                cantidades.add(cantidad);
                totalVenta += seleccionado.getPrecio() * cantidad;
            } else {
                System.out.println("⚠️ Producto no encontrado.");
            }

            System.out.print("¿Agregar otro producto? (s/n): ");
            seguir = sc.nextLine().equalsIgnoreCase("s");

        } while (seguir);

        // 3. Registrar venta
        Venta venta = new Venta(idCliente, LocalDate.now(), totalVenta);
        int idVenta = ventaDAO.registrar(venta);

        // 4. Registrar detalles de la venta
        for (int i = 0; i < carrito.size(); i++) {
            Producto p = carrito.get(i);
            int cant = cantidades.get(i);
            double subtotal = p.getPrecio() * cant;
            VentaDetalle detalle = new VentaDetalle(idVenta, p.getId(), cant, subtotal);
            detalleDAO.registrar(detalle);
        }

        System.out.println("✅ Venta registrada con total: S/. " + totalVenta);
    }

}
