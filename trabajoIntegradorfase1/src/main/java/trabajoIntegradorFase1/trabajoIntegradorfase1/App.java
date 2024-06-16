package trabajoIntegradorFase1.trabajoIntegradorfase1;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conexion.ConexionBD;
import dao.ProductoDaoImplementa;
import entities.Producto;

public class App {

    static Scanner teclado = new Scanner(System.in);

    static ProductoDaoImplementa dao1 = new ProductoDaoImplementa();

    public static void main(String[] args) throws SQLException {

	// pruebo la conexion
	ConexionBD.conectar();

	int opcion = 0;

	do {

	    System.out.println("1. Ingresar nuevo producto");
	    System.out.println("2. Agregar stock a producto existente");
	    System.out.println("3. Actualizar precio");
	    System.out.println("4. Listar productos");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
	    System.out.print("Seleccione una opción: ");
	    opcion = teclado.nextInt();
	    teclado.nextLine();

	    try {

		switch (opcion) {
		case 1:
		    ingresarProducto();
		    break;
		case 2:
		    agregarStock();
		    break;
		case 3:
		    actualizarPrecio();
		    break;
		case 4:
		    mostrarProductos();
		    break;
		case 5:  
		    eliminarProductos();
		    breack;
		case 6:
		    System.out.println("Salir");
		    break;
		default:
		    System.out.println("Opción no válida.");
		}

	    } catch (InputMismatchException e) {
		System.out.println("Error: Entrada no válida. Por favor, ingrese un número.");
		teclado.nextLine();
	    }
	}

	while (opcion != 6);

    }

    private static void ingresarProducto() throws SQLException {

	try {

	    System.out.print("Ingrese el codigo del producto: ");
	    int codigoProducto = teclado.nextInt();
	    teclado.nextLine();

	    System.out.println("ingrese el nombre del producto: ");
	    String nombreProducto = teclado.nextLine();

	    System.out.println("ingrese la descripción del producto: ");
	    String descripcion = teclado.nextLine();

	    System.out.println("ingrese el precio de venta del producto: ");
	    double precioVenta = teclado.nextDouble();
	    teclado.nextLine();

	    System.out.println("ingrese el stock del producto ");
	    int stock = teclado.nextInt();
	    teclado.nextLine();

	    Producto producto = new Producto(codigoProducto, nombreProducto, descripcion, precioVenta, stock);

	    dao1.insertar(producto);

	    System.out.println("Producto ingresado correctamente. Código: " + producto.getCodigoProducto()
		    + "nombre del producto: " + producto.getNombreProducto() + "descripcion del producto: "
		    + producto.getDescripcion() + "precio de venta: " + producto.getPrecioVenta() + "stock: "
		    + producto.getStock());

	} catch (InputMismatchException e) {
	    System.out.println("Error: opcion no valida. Por favor, ingrese los datos correctamente.");
	    teclado.nextLine();
	}

	System.out.println("Presione Enter para regresar al menú principal...");
	teclado.nextLine();

    }

    private static void agregarStock() {

	try {

	    // Scanner teclado = null;
	    System.out.print("Ingrese el Código del producto: ");

	    int codigoProducto = teclado.nextInt();

	    Producto producto = dao1.mostrarporcodigoProducto(codigoProducto);
	    if (producto != null) {
		System.out.print("el Stock a agregar es : ");
		int stockAgregar = teclado.nextInt();
		teclado.nextLine();
		producto.setStock(producto.getStock() + stockAgregar);
		dao1.actualizar(producto);
		System.out.println("Stock actualizado correctamente.");
	    } else {
		System.out.println("Producto no encontrado.");
	    }

	} catch (InputMismatchException e) {
	    System.out.println("Error: Entrada no válida. Por favor, ingrese los datos correctamente.");
	    teclado.nextLine();
	}

    }

    private static void actualizarPrecio() {

	try {

	    System.out.print("ingrese el Código del producto a actualizar ");
	    int codigoProducto = teclado.nextInt();
	    teclado.nextLine();

	    Producto producto = dao1.mostrarporcodigoProducto(codigoProducto);
	    if (producto != null) {
		System.out.print("ingrese el nuevo precio de venta: ");
		double nuevoPrecioVenta = teclado.nextDouble();
		teclado.nextLine();
		producto.setPrecioVenta(nuevoPrecioVenta);
		dao1.actualizar(producto);
		System.out.println("Precio actualizado correctamente.");
	    } else {
		System.out.println("Producto no encontrado.");
	    }

	} catch (InputMismatchException e) {
	    System.out.println("Error: opcion no válida. Por favor, ingrese los datos correctamente.");
	    teclado.nextLine();
	}

    }

    private static void mostrarProductos() {

	for (Producto producto : dao1.obtenerTodos()) {
	    System.out.println(producto);

	}

	teclado.close();
    }

}
