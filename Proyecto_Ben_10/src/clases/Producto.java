package clases;

public class Producto {
	// atributos
	private String codigoProducto;
	private String nombre;
	private float precio;
	private float peso;
	private int numExistencias;
	private String dimensiones;

	// constructor
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters y setters

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getNumExistencias() {
		return numExistencias;
	}

	public void setNumExistencias(int numExistencias) {
		this.numExistencias = numExistencias;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

}
