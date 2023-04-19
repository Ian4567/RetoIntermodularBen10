package clases;

public class Linea_De_Ropa extends Producto {
	// atributos
	private String talla;
	private String tejido;
	private String color;
	private String fabricante;

	// cosntructor
	public Linea_De_Ropa() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters y setters
	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getTejido() {
		return tejido;
	}

	public void setTejido(String tejido) {
		this.tejido = tejido;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

}
