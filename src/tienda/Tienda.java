package tienda;

import java.util.ArrayList;

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
	
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	public void agregarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}
	
	
	public void registrarVenta(int codigoProducto, int codigoVendedor, int cantidad) {
	    Producto producto = null;
	    for (int i = 0; i < productos.size(); i++) {
	        if (productos.get(i).getCodigo() == codigoProducto) {
	            producto = productos.get(i);
	        }
	    }
	    
	    Vendedor vendedor = null;
	    for (int i = 0; i < vendedores.size(); i++) {
	        if (vendedores.get(i).getCodigo() == codigoVendedor) {
	            vendedor = vendedores.get(i);
	        }
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
	
}
