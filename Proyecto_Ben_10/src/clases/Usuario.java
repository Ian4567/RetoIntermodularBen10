package clases;

import java.time.LocalDate;

public class Usuario extends Persona {
	// atributos
	private String nombrePersonal;
	private String apellido;
	private LocalDate fecha_nacimiento;
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

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
