package clases;

public class Tarjeta {
	// atributos
	private String numeroTarjeta;
	private int CVV;
	private float saldo;

	// cosntructor
	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters y setters
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


}
