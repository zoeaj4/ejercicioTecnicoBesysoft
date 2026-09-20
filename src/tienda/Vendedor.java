package tienda;

public class Vendedor {
	private int codigo;
	private String nombre;
	private double sueldo;
	
		public Vendedor(int codigo, String nombre, double sueldo) {
			this.setCodigo(codigo);
			this.setNombre(nombre);
			this.setSueldo(sueldo);
		}

	// setters y getters
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
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String toString() {
	    return "Codigo: " + codigo + " | Nombre: " + nombre + " | Sueldo: " + sueldo;
	}

}
