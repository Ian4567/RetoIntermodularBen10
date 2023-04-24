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

	
	public void setArticulable(String string) {
		this.articulable = string;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}


	public String getArticulable() {
		return articulable;
	}

	public String getPilas() {
		return pilas;
	}

	public void setPilas(String string) {
		this.pilas = string;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

}
