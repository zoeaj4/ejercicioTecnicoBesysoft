package tienda;

public class Venta {
	private Vendedor vendedor;
	private Producto producto;
	private int cantidad;
	
	public Venta(Vendedor vendedor, Producto producto,int cantidad) {
		this.setVendedor(vendedor);
		this.setProducto(producto);
		this.setCantidad(cantidad);
	}

	public double getTotal() {
		return producto.getPrecio() * cantidad;
	}
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String toString() {
	    return "Vendedor: " + vendedor + " | Producto: " + producto + " | Cantidad: " + cantidad;
	}
	

}
