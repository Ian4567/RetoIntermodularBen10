package clases;

public class Persona {
	// atributos
	private String codigoPersona;
	private String nombreUsuario;
	private String email;
	private int numTelefono;
	private String contrasea;

	// constructor
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(String codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public String getNombre() {
		return nombreUsuario;
	}

	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}
	
	public String getContrasea() {
		return contrasea;
	}

	public void setContrasea(String contrasea) {
		this.contrasea = contrasea;
	}

}
