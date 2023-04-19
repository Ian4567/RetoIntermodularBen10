package clases;

public class Juguete extends Producto {
	// atributos
	private String material;
	private boolean articulable;
	private int edadMinima;
	private boolean pilas;
	private int pegi;

	// constructor
	public Juguete() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters y setters
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isArticulable() {
		return articulable;
	}

	public void setArticulable(boolean articulable) {
		this.articulable = articulable;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public boolean isPilas() {
		return pilas;
	}

	public void setPilas(boolean pilas) {
		this.pilas = pilas;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

}
