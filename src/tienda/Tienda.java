package tienda;

import java.util.ArrayList;

public class Tienda {
	
	private ArrayList <Producto> productos;
	private ArrayList <Vendedor> vendedores;
	
	
	public Tienda() {
		// inicializamos las listas al crear la tienda
	    productos = new ArrayList<Producto>();
	    vendedores = new ArrayList<Vendedor>();
	}
	
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	public void agregarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}
	
	public ArrayList<Producto> getProductos() {
	    return productos;
	}
	public ArrayList<Vendedor> getVendedores() {
	    return vendedores;
	}
	
}
