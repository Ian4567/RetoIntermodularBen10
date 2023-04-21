package clases;

import java.time.LocalDate;

public class Pelicula_Serie extends Producto {
	// atributos
	private String genero;
	private LocalDate fechaLanzamiento;
	private String idioma;
	private boolean subtitulado;
	private String duracion;

	// constructor
	public Pelicula_Serie() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters y setters
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isSubtitulado() {
		return subtitulado;
	}

	public void setSubtitulado(boolean subtitulado) {
		this.subtitulado = subtitulado;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

}