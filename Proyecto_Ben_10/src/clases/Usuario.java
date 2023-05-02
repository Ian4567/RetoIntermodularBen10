package clases;

import java.time.LocalDate;

public class Usuario extends Persona {
	// atributos
	private String numeroTarjeta;
	private String nombrePersonal;
	private String apellido;
	private String fecha_nacimiento;
	private String direccion;

	// constructor
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters y setters
	public String getNombrePersonal() {
		return nombrePersonal;
	}

	public void setNombrePersonal(String nombrePersonal) {
		this.nombrePersonal = nombrePersonal;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

}
