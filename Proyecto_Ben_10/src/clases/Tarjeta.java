package clases;

public class Tarjeta {
	// atributos
	private String numeroTarjeta;
	private String CVV;
	private String saldo;

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

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

}
