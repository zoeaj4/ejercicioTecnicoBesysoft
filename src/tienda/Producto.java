package tienda;
/*Ver repositorio en github:
 * https://github.com/zoeaj4/ejercicioTecnicoBesysoft
 * 
 * */

public class Producto {
	private int codigo;
	private String nombre;
	private double precio;
	private String categoria;
	
	
	public Producto(int codigo, String nombre, double precio, String categoria) {
		this.setCategoria(categoria);
		this.setCodigo(codigo);
		this.setPrecio(precio);
		this.setNombre(nombre);
	}
	
	
	public String toString() {
	    return "Codigo: " + codigo + " | Nombre: " + nombre + " | Precio: " + precio + " | Categoria: " + categoria;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
