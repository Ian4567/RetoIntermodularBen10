package clases;

public class Juguete extends Producto {
	// atributos
	private String material;
	private String articulable;
	private int edadMinima;
	private String pilas;
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
	
	public String getArticulable() {
		return articulable;
	}

	public void setArticulable(String articulable) {
		this.articulable = articulable;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	
	public String getPilas() {
		return pilas;
	}

	public void setPilas(String pilas) {
		this.pilas = pilas;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

}
