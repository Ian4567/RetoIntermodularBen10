package clases;

import java.sql.Date;
import java.time.LocalDate;

public class Pelicula_Serie extends Producto {
	// atributos
	private String genero;
	private String fechaLanzamiento;
	private String idioma;
	private String subtitulado;
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

	public String getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(String fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getSubtitulado() {
		return subtitulado;
	}

	public void setSubtitulado(String subtitulado) {
		this.subtitulado = subtitulado;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

}
