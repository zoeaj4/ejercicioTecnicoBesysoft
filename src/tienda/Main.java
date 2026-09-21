/*Ver repositorio en github:
 * https://github.com/zoeaj4/ejercicioTecnicoBesysoft
 * 
 * */

package tienda;


import java.util.ArrayList;
import java.util.Scanner;
import tienda.exception.ProductoNoEncontradoException;
import tienda.exception.VendedorNoEncontradoException;
import tienda.exception.DatoInvalidoException;

public class Main {

	static Scanner scanner = new Scanner (System.in);
	static Tienda tienda = new Tienda();

	public static void main(String[] args) {

        int opcion = -1;
        while (opcion != 0) {

            System.out.println("===== MENU TIENDA =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar vendedor");
            System.out.println("3. Registrar venta");
            System.out.println("4. Listar productos");
            System.out.println("5. Listar vendedores");
            System.out.println("6. Listar ventas");
            System.out.println("7. Buscar productos");
            System.out.println("8. Calcular comision de un vendedor");
            System.out.println("0. Salir");

            System.out.print("Elegi una opcion: ");
            String texto = scanner.nextLine();
            opcion = Integer.parseInt(texto);

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    registrarVendedor();
                    break;
                case 3:
                    registrarVenta();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 5:
                    listarVendedores();
                    break;
                case 6:
                    listarVentas();
                    break;
                case 7:
                    buscarProductos();
                    break;
                case 8:
                    calcularComision();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Esa opcion no existe, proba de nuevo.");
            }

            System.out.println();
        }

        scanner.close();
	}

	private static void calcularComision() {
		System.out.println("Codigo del vendedor: ");
		int codigoVendedor = Integer.parseInt(scanner.nextLine());

		try {
			double comision = tienda.calcularComision(codigoVendedor);
			System.out.println("La comision es " + comision);
		} catch (VendedorNoEncontradoException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void registrarVenta() {
		System.out.println("Código del producto: ");
		int codigoProducto = Integer.parseInt(scanner.nextLine());
		System.out.println("Codigo del vendedor: ");
		int codigoVendedor = Integer.parseInt(scanner.nextLine());
		System.out.println("Cantidad: ");
		int cantidad = Integer.parseInt(scanner.nextLine());

		try {
			tienda.registrarVenta(codigoProducto, codigoVendedor, cantidad);
			System.out.println("Venta registrada");
		} catch (ProductoNoEncontradoException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (VendedorNoEncontradoException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (DatoInvalidoException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void listarVendedores() {
		ArrayList<Vendedor> vendedores = tienda.getVendedores();
		if (vendedores.size() == 0) {
			System.out.println("No hay vendedores cargados.");
			return;
		}
		for (int i = 0; i < vendedores.size(); i++) {
			System.out.println(vendedores.get(i));
		}
	}

	private static void listarProductos() {
		ArrayList<Producto> productos = tienda.getProductos();

		if (productos.size() == 0) {
			System.out.println("No hay productos enlistados.");
			return;
		}

		for (int i = 0; i < productos.size(); i++) {
			System.out.println(productos.get(i));
		}
	}

	private static void registrarVendedor() {
		System.out.println("Codigo: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Sueldo: ");
		double sueldo = Double.parseDouble(scanner.nextLine());

		Vendedor vendedor = new Vendedor(codigo, nombre, sueldo);

		try {
			tienda.agregarVendedor(vendedor);
			System.out.println("Vendedor registrado.");
		} catch (DatoInvalidoException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void registrarProducto() {
		System.out.println("Código: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("Precio: ");
		Double precio = Double.parseDouble(scanner.nextLine());
		System.out.println("Categoria: ");
		String categoria = scanner.nextLine();

		Producto producto = new Producto (codigo,nombre,precio,categoria);

		try {
			tienda.agregarProducto(producto);
			System.out.println("Producto agregado");
		} catch (DatoInvalidoException e){
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void listarVentas() {
	    ArrayList<Venta> ventas = tienda.getVentas();

	    if (ventas.size() == 0) {
	        System.out.println("No hay ventas registradas.");
	        return;
	    }

	    for (int i = 0; i < ventas.size(); i++) {
	        System.out.println(ventas.get(i));
	    }
	}

	// menu buscadores
	public static void buscarProductos() {
		ArrayList<Producto> resultado = new ArrayList<Producto>();

		int opcion = -1;
        while (opcion != 0) {

            System.out.println("===== MENU BUSQUEDA =====");
            System.out.println("1. Buscar por Categoria");
            System.out.println("2. Buscar por Nombre");
            System.out.println("3. Buscar por codigo");
            System.out.println("4. Buscar entre precios");
            System.out.println("0. Salir");

            System.out.print("Elegi una opcion: ");
            String texto = scanner.nextLine();
            opcion = Integer.parseInt(texto);

            switch (opcion) {
                case 1:
                {
                	System.out.println("Categoria: ");
                	String categoria = scanner.nextLine();
                	resultado = tienda.buscarPorCategoria(categoria);
                }
                    break;
                case 2:
                {
                	System.out.println("Nombre: ");
                	String nombre = scanner.nextLine();
                	resultado = tienda.buscarPorNombre(nombre);
                }
                    break;
                case 3:
                {
                	System.out.println("Codigo: ");
                	int codigo = Integer.parseInt(scanner.nextLine());
                	resultado = tienda.buscarPorCodigo(codigo);
                }
                    break;
                case 4:
                {
                    	System.out.println("Precio minimo: ");
                    	Double precioMinimo = Double.parseDouble(scanner.nextLine());
                    	System.out.println("Precio maximo: ");
                    	Double precioMaximo = Double.parseDouble(scanner.nextLine());
                    	resultado = tienda.buscarPorRangoPrecios(precioMinimo, precioMaximo);
                }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    continue;
                default:
                    System.out.println("Esa opcion no existe, proba de nuevo.");
            }

            if (resultado.size() == 0) {
                System.out.println("No se encontraron productos.");
            } else {
                for (int i = 0; i < resultado.size(); i++) {
                    System.out.println(resultado.get(i));
                }
            }

            System.out.println();
        }
	}
}