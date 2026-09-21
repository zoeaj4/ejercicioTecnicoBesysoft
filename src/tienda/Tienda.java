package tienda;
/*Ver repositorio en github:
 * https://github.com/zoeaj4/ejercicioTecnicoBesysoft
 * 
 * */

import java.util.ArrayList;
import tienda.exception.ProductoNoEncontradoException;
import tienda.exception.VendedorNoEncontradoException;
import tienda.exception.DatoInvalidoException;

public class Tienda {

	private ArrayList <Producto> productos;
	private ArrayList <Vendedor> vendedores;
	private ArrayList <Venta> ventas;


	public Tienda() {
		// inicializamos las listas al crear la tienda
	    productos = new ArrayList<Producto>();
	    vendedores = new ArrayList<Vendedor>();
	    ventas = new ArrayList<Venta>();
	}


	public void agregarProducto(Producto producto) throws DatoInvalidoException {
		if (producto.getPrecio() <= 0) {
			throw new DatoInvalidoException("El precio tiene que ser mayor a 0");
		}
		productos.add(producto);
	}

	public void agregarVendedor(Vendedor vendedor) throws DatoInvalidoException {
		if (vendedor.getSueldo() < 0) {
			throw new DatoInvalidoException("El sueldo no puede ser negativo");
		}
		vendedores.add(vendedor);
	}


	public void registrarVenta(int codigoProducto, int codigoVendedor, int cantidad)
			throws ProductoNoEncontradoException, VendedorNoEncontradoException, DatoInvalidoException {

		if (cantidad <= 0) {
			throw new DatoInvalidoException("La cantidad tiene que ser mayor a 0");
		}

	    Producto producto = null;
	    for (int i = 0; i < productos.size(); i++) {
	        if (productos.get(i).getCodigo() == codigoProducto) {
	            producto = productos.get(i);
	        }
	    }
	    if (producto == null) {
	    	throw new ProductoNoEncontradoException("No existe un producto con codigo " + codigoProducto);
	    }

	    Vendedor vendedor = null;
	    for (int i = 0; i < vendedores.size(); i++) {
	        if (vendedores.get(i).getCodigo() == codigoVendedor) {
	            vendedor = vendedores.get(i);
	        }
	    }
	    if (vendedor == null) {
	    	throw new VendedorNoEncontradoException("No existe un vendedor con codigo " + codigoVendedor);
	    }

	    Venta venta = new Venta(vendedor, producto, cantidad);
	    ventas.add(venta);
	}


	public ArrayList<Producto> getProductos() {
	    return productos;
	}

	public ArrayList<Vendedor> getVendedores() {
	    return vendedores;
	}
	public ArrayList<Venta> getVentas() {
	    return ventas;
	}

	//buscadores

	public ArrayList<Producto> buscarPorCategoria(String categoria){
		ArrayList<Producto> resultado = new ArrayList<Producto>();

		for (int i = 0; i<productos.size(); i++) {
			if (productos.get(i).getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
				resultado.add(productos.get(i));
			}

		}
		return resultado;
	}
	public ArrayList<Producto> buscarPorNombre(String nombre){
		ArrayList<Producto> resultado = new ArrayList<Producto>();

		for (int i = 0; i<productos.size(); i++) {
			if (productos.get(i).getNombre().toLowerCase().contains(nombre.toLowerCase())) {
				resultado.add(productos.get(i));
			}

		}
		return resultado;
	}

	public ArrayList<Producto> buscarPorRangoPrecios(Double precioMinimo, Double precioMaximo){

		ArrayList<Producto> resultado = new ArrayList<Producto>();

		for (int i = 0; i<productos.size(); i++) {
			if (productos.get(i).getPrecio()>=precioMinimo && productos.get(i).getPrecio()<= precioMaximo) {
				resultado.add(productos.get(i));
			}

		}
		return resultado;
	}

	public ArrayList<Producto> buscarPorCodigo(int codigo){
		ArrayList<Producto> resultado = new ArrayList<Producto>();

		for (int i = 0; i<productos.size(); i++) {
			if (productos.get(i).getCodigo()==codigo) {
				resultado.add(productos.get(i));
			}

		}

		return resultado;
	}

	// calcular comision
	public double calcularComision(int codigoVendedor) throws VendedorNoEncontradoException {

		boolean existe = false;
		for (int i = 0; i < vendedores.size(); i++) {
			if (vendedores.get(i).getCodigo() == codigoVendedor) {
				existe = true;
			}
		}
		if (!existe) {
			throw new VendedorNoEncontradoException("No existe un vendedor con codigo " + codigoVendedor);
		}

		int totalUnidades = 0;
		double totalVendido = 0;

	 for (int i = 0; i<ventas.size(); i++) {
			if (ventas.get(i).getVendedor().getCodigo() == codigoVendedor) {
				totalUnidades = totalUnidades+ventas.get(i).getCantidad();
				totalVendido = totalVendido + ventas.get(i).getTotal();
			}
		}

		double comision;
		if (totalUnidades<=2) {
			comision = totalVendido * 0.05;
		} else {
			comision = totalVendido * 0.10;
		}

		return comision;
	}


}