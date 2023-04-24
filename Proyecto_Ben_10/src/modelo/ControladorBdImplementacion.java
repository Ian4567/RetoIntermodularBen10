package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import clases.Juguete;
import clases.Linea_De_Ropa;
import clases.Pelicula_Serie;
import clases.Producto;

public class ControladorBdImplementacion implements DBImplementacion {

	private Connection con;
	private PreparedStatement stmt;

	// sentencia SQL
	private final String ACTUALIZAR_LINEA_ROPA = "UPDATE LINEA_DE_ROPA SET talla=?, tejido=?, color=?, fabricante=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_JUGUETE = "UPDATE JUGUETE SET material=?, articulable=?, edad_minima=?, pilas=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_PELICULA = "UPDATE PELICULA SET genero=?, fecha_de_lanzamiento=?, idioma=?, subtitulado=?, duracion=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_PRODUCTO = "UPDATE PRODUCTO SET nombre=?, precio=?, peso=?, num_existencias=?, dimensiones=? WHERE codigo_producto=?";
	private final String ALTA_PRODUCTO = "INSERT INTO PRODUCTO (codigo_producto, nombre, precio, peso, num_existencias, dimensiones) VALUES (?,?,?,?,?,?)";
	private final String ALTA_LINEA_ROPA = "INSERT INTO LINEA_DE_ROPA (codigo_producto, talla, tejido, color, fabricante) VALUES (?,?,?,?,?)";
	private final String ALTA_JUGUETE = "INSERT INTO JUGUETE (codigo_producto, material, articulable, edad_minima, pilas) VALUES (?,?,?,?,?)";
	private final String ALTA_PELIS_SERIES = "INSERT INTO PELICULA_SERIE (codigo_producto, genero, fecha_de_lanzamiento, idioma, subtitulado, duracion) VALUES (?,?,?,?,?,?)";
	private final String SELECT_PRODUCTOS = "SELECT * FROM PRODUCTO";
	private final String DELETE_PRODUCTO = "DELETE FROM PRODUCTO WHERE CODIGO_PRODUCTO = ?";
	private final String SELECT_PRODUCTO_COD = "SELECT * FROM PRODUCTO WHERE codigo_producto=?";
	private final String SELECT_LINEA_ROPA = "SELECT * FROM LINEA_DE_ROPA WHERE codigo_producto=?";
	private final String SELECT_JUGUETE = "SELECT * FROM JUGUETE WHERE codigo_producto=?";
	private final String SELECT_PELICULA = "SELECT * FROM PELICULA_SERIE WHERE codigo_producto=?";
	private ResourceBundle configFichero;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	// Metodo para conectarnos a la base de datos
	public ControladorBdImplementacion() {
		this.configFichero = ResourceBundle.getBundle("modelo.configuracion");
		this.driverBD = this.configFichero.getString("Driver");
		this.urlBD = this.configFichero.getString("Conn");
		this.userBD = this.configFichero.getString("DBUser");
		this.passwordBD = this.configFichero.getString("DBPass");
	}

	private void openConnection() {
		try {
			// Class.forName(this.driverBD);
			con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha abierto la base de datos");
			e.printStackTrace();
		}
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	public void insertarProducto(Producto prod) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(ALTA_PRODUCTO); // Cargamos el insert de persona con el stmt
			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, prod.getCodigoProducto());
			stmt.setString(2, prod.getNombre());
			stmt.setFloat(3, prod.getPrecio());
			stmt.setFloat(4, prod.getPeso());
			stmt.setInt(5, prod.getNumExistencias());
			stmt.setString(6, prod.getDimensiones());

			if (stmt.executeUpdate() == 1) {
				if (prod instanceof Linea_De_Ropa) {
					stmt = con.prepareStatement(ALTA_LINEA_ROPA);

					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Linea_De_Ropa) prod).getTalla());
					stmt.setString(3, ((Linea_De_Ropa) prod).getTejido());
					stmt.setString(4, ((Linea_De_Ropa) prod).getColor());
					stmt.setString(5, ((Linea_De_Ropa) prod).getFabricante());
					stmt.executeUpdate();

				} else if (prod instanceof Juguete) {

					stmt = con.prepareStatement(ALTA_JUGUETE);

					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Juguete) prod).getMaterial());
					stmt.setString(3, ((Juguete) prod).getArticulable());
					stmt.setInt(4, ((Juguete) prod).getEdadMinima());
					stmt.setString(5, ((Juguete) prod).getPilas());
					stmt.executeUpdate();
				} else if (prod instanceof Pelicula_Serie) {
					stmt = con.prepareStatement(ALTA_PELIS_SERIES);

					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Pelicula_Serie) prod).getGenero());
					stmt.setDate(3, Date.valueOf(((Pelicula_Serie) prod).getFechaLanzamiento()));
					stmt.setString(4, ((Pelicula_Serie) prod).getIdioma());
					stmt.setString(5, ((Pelicula_Serie) prod).getSubtitulado());
					stmt.setString(6, ((Pelicula_Serie) prod).getDuracion());
					stmt.executeUpdate();
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public boolean validarFloat(String cadena) {
		Float num;
		try {
			// SI ES UN INT
			num = Float.parseFloat(cadena);
			return true;

		} catch (Exception e) {
			// SI ES UN STRING
			return false;
		}
	}

	public boolean validarInt(String cadena) {
		int num;
		try {
			// SI ES UN INT
			num = Integer.parseInt(cadena);
			return true;

		} catch (Exception e) {
			// SI ES UN STRING
			return false;
		}
	}

	public int numeroProducto(Producto prod) {
		ResultSet rs = null;
		String numJuguetes = "SELECT COUNT(codigo_producto)FROM producto";
		int n = 0;
		this.openConnection();

		try {
			stmt = con.prepareStatement(numJuguetes);
			rs = stmt.executeQuery();
			if (rs.next()) {
				// Si hay resultados obtengo el valor.
				n = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n;

	}

	public ArrayList<Producto> recogerProductos() {
		this.openConnection();
		Producto prod;
		ArrayList<Producto> codProd = new ArrayList<>();
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_PRODUCTOS);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setPrecio(rs.getFloat("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				codProd.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codProd;

	}

	public Producto recogerProductoId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_PRODUCTO_COD);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setPrecio(rs.getFloat("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public Producto recogerLineaRopaId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_LINEA_ROPA);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Linea_De_Ropa();
				((Linea_De_Ropa) prod).setTalla(rs.getString("talla"));
				((Linea_De_Ropa) prod).setTejido(rs.getString("tejido"));
				((Linea_De_Ropa) prod).setColor(rs.getString("color"));
				((Linea_De_Ropa) prod).setFabricante(rs.getString("fabricante"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public Producto recogerJugueteId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_JUGUETE);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Juguete();
				((Juguete) prod).setMaterial(rs.getString("material"));
				((Juguete) prod).setArticulable(rs.getString("articulable"));
				((Juguete) prod).setEdadMinima(rs.getInt("edad_minima"));
				((Juguete) prod).setPilas(rs.getString("pilas"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public Producto recogerPeliculaId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_PELICULA);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Pelicula_Serie();
				((Pelicula_Serie) prod).setGenero(rs.getString("genero"));
				((Pelicula_Serie) prod).setFechaLanzamiento(rs.getDate("fecha_de_nacimiento").toLocalDate());
				((Pelicula_Serie) prod).setIdioma(rs.getString("idioma"));
				((Pelicula_Serie) prod).setSubtitulado(rs.getString("subtitulado"));
				((Pelicula_Serie) prod).setDuracion(rs.getString("duracion"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public void eliminarProducto(Producto prod) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETE_PRODUCTO);
			stmt.setString(1, prod.getCodigoProducto());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		}

	}

	public void modificarProducto(Producto prod) {

		ResultSet rs = null;

		// Abrimos la conexion con la base de datos
		this.openConnection();

		try {

			stmt = con.prepareStatement(ACTUALIZAR_PRODUCTO);
			
			stmt.setString(1, prod.getNombre());
			stmt.setFloat(2, prod.getPrecio());
			stmt.setFloat(3, prod.getPeso());
			stmt.setInt(4, prod.getNumExistencias());
			stmt.setString(5, prod.getDimensiones());

			if (stmt.executeUpdate() == 1) {
				if (prod instanceof Linea_De_Ropa) {
					stmt = con.prepareStatement(ACTUALIZAR_LINEA_ROPA);

					stmt.setString(1, ((Linea_De_Ropa) prod).getTalla());
					stmt.setString(2, ((Linea_De_Ropa) prod).getTejido());
					stmt.setString(3, ((Linea_De_Ropa) prod).getColor());
					stmt.setString(4, ((Linea_De_Ropa) prod).getFabricante());

					stmt.executeUpdate();
				} else if (prod instanceof Juguete) {
					stmt = con.prepareStatement(ACTUALIZAR_JUGUETE);

					stmt.setString(1, ((Juguete) prod).getMaterial());
					stmt.setString(2, ((Juguete) prod).getArticulable());
					stmt.setInt(3, ((Juguete) prod).getEdadMinima());
					stmt.setString(4, ((Juguete) prod).getPilas());

					stmt.executeUpdate();
				} else if (prod instanceof Pelicula_Serie) {
					stmt = con.prepareStatement(ACTUALIZAR_PELICULA);
					stmt.setString(1, ((Pelicula_Serie) prod).getGenero());
					stmt.setDate(2, Date.valueOf(((Pelicula_Serie) prod).getFechaLanzamiento()));
					stmt.setString(3, ((Pelicula_Serie) prod).getGenero());
					stmt.setString(4, ((Pelicula_Serie) prod).getGenero());
					stmt.setString(5, ((Pelicula_Serie) prod).getGenero());

					stmt.executeUpdate();
				}

			}
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();

		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}