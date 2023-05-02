package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import clases.Cesta_Compra;
import clases.Juguete;
import clases.Linea_De_Ropa;
import clases.Pelicula_Serie;
import clases.Persona;
import clases.Producto;
import clases.Tarjeta;
import clases.Usuario;

public class ControladorBdImplementacion implements DBImplementacion {

	private Connection con;
	private PreparedStatement stmt;

	// sentencia SQL
	private final String ACTUALIZAR_LINEA_ROPA = "UPDATE linea_de_ropa SET talla=?, tejido=?, color=?, fabricante=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_JUGUETE = "UPDATE juguete SET material=?, articulable=?, edad_minima=?, pilas=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_PELICULA = "UPDATE pelicula_serie SET genero=?, fecha_de_lanzamiento=?, idioma=?, subtitulado=?, duracion=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_PRODUCTO = "UPDATE producto SET nombre=?, precio=?, peso=?, num_existencias=?, dimensiones=? WHERE codigo_producto=?";
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
	private final String SELECT_COMPRA = "SELECT * FROM CESTA_COMPRA";
	private final String SELECT_PROD_LINEA = "SELECT * FROM PRODUCTO P JOIN LINEA_DE_ROPA L ON P.codigo_producto=L.codigo_producto";
	private final String SELECT_PROD_JUGUETE = "SELECT * FROM PRODUCTO P JOIN JUGUETE J ON P.codigo_producto=J.codigo_producto";
	private final String SELECT_PROD_PELI = "SELECT * FROM PRODUCTO P JOIN PELICULA_SERIE PS ON P.codigo_producto=PS.codigo_producto";
	private final String SUMA_PRECIO = "select sum(peso) from realiza r join usuario u on r.CODIGO_PERSONA=u.CODIGO_PERSONA JOIN producto P ON R.CODIGO_PRODUCTO=P.CODIGO_PRODUCTO WHERE U.CODIGO_PERSONA = P001";
	private final String INSERT_PERSONA = "INSERT INTO persona (codigo_persona, nombre, email, num_telefono, contraseña ) VALUES ( ?, ?, ?, ?,?)";
	private final String INSERT_USUARIO = "INSERT INTO usuario (codigo_persona_usuario, numero_tarjeta, nombre, apellido, fecha_nacimiento, direccion) VALUES ( ?, ?, ?, ?, ?,?)";
	private final String INSERT_TARJETA = "INSERT INTO tarjeta (numero_tarjeta, cvv) VALUES ( ?, ?)";
	private final String SELECT_EN_CESTA = "SELECT P.CODIGO_PRODUCTO,P.NOMBRE,PESO, PRECIO, CC.NUMREFERENCIA,  FECHA_INICIO, CANTIDAD FROM REALIZA R JOIN PRODUCTO P ON P.CODIGO_PRODUCTO=R.CODIGO_PRODUCTO JOIN USUARIO U ON R.CODIGO_PERSONA= U.CODIGO_PERSONA_USUARIO JOIN CESTA_COMPRA CC ON R.NUMREFERENCIA=CC.NUMREFERENCIA WHERE U.CODIGO_PERSONA_USUARIO=? AND CC.FECHA_FIN IS NULL AND R.NUMREFERENCIA=?";
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
					stmt.setString(3, ((Pelicula_Serie) prod).getFechaLanzamiento());
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
				((Pelicula_Serie) prod).setFechaLanzamiento(rs.getString("fecha_de_lanzamiento"));
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
			stmt.setFloat(4, prod.getPeso());
			stmt.setInt(3, prod.getNumExistencias());
			stmt.setFloat(5, Float.parseFloat(prod.getDimensiones()));

			stmt.setString(6, prod.getCodigoProducto());

			if (stmt.executeUpdate() == 1) {
				if (prod instanceof Linea_De_Ropa) {

					stmt = con.prepareStatement(ACTUALIZAR_LINEA_ROPA);
					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Linea_De_Ropa) prod).getTalla());
					stmt.setString(3, ((Linea_De_Ropa) prod).getTejido());
					stmt.setString(4, ((Linea_De_Ropa) prod).getColor());
					stmt.setString(5, ((Linea_De_Ropa) prod).getFabricante());

					stmt.executeUpdate();
				} else if (prod instanceof Juguete) {
					stmt = con.prepareStatement(ACTUALIZAR_JUGUETE);
					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Juguete) prod).getMaterial());
					stmt.setString(3, ((Juguete) prod).getArticulable());
					stmt.setInt(4, ((Juguete) prod).getEdadMinima());
					stmt.setString(5, ((Juguete) prod).getPilas());

					stmt.executeUpdate();
				} else if (prod instanceof Pelicula_Serie) {
					stmt = con.prepareStatement(ACTUALIZAR_PELICULA);
					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Pelicula_Serie) prod).getGenero());
					stmt.setString(3, ((Pelicula_Serie) prod).getFechaLanzamiento());
					stmt.setString(4, ((Pelicula_Serie) prod).getIdioma());
					stmt.setString(5, ((Pelicula_Serie) prod).getSubtitulado());
					stmt.setString(6, ((Pelicula_Serie) prod).getDuracion());

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

	public Map<String, Cesta_Compra> listarCompra() {
		ResultSet rs = null;
		Cesta_Compra compra;
		Map<String, Cesta_Compra> listaCompra = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_COMPRA);

			rs = stmt.executeQuery();

			while (rs.next()) {
				compra = new Cesta_Compra();
				compra.setNumReferencia(rs.getString("numreferencia"));
				compra.setFecha_Inicio(Date.valueOf(rs.getString("fecha_inicio")).toLocalDate());
				compra.setFecha_fin(Date.valueOf(rs.getString("fecha_fin")).toLocalDate());
				compra.setPeso_total(rs.getFloat("peso_total"));
				compra.setPeso_total(rs.getFloat("precio_total"));
				listaCompra.put(compra.getNumReferencia(), compra);
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaCompra;
	}

	public Producto recogerCesta(String codigo_persona, String numreferencia) {
		this.openConnection();
		Persona per = null;
		Producto prod =null;
		Cesta_Compra cesta = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_EN_CESTA);
			stmt.setString(1, codigo_persona);
			stmt.setString(2, numreferencia);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setCodigoProducto(rs.getString("codigo_producto"));

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

	public Map<String, Producto> listarProdRopa() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listaProd = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_PROD_LINEA);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Linea_De_Ropa();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setPrecio(rs.getFloat("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				((Linea_De_Ropa) prod).setTalla(rs.getString("talla"));
				((Linea_De_Ropa) prod).setTejido(rs.getString("tejido"));
				((Linea_De_Ropa) prod).setColor(rs.getString("color"));
				((Linea_De_Ropa) prod).setFabricante(rs.getString("fabricante"));
				listaProd.put(prod.getCodigoProducto(), prod);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaProd;
	}

	public Map<String, Producto> listarProdJuguete() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listaProd = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_PROD_JUGUETE);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Juguete();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setPrecio(rs.getFloat("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				((Juguete) prod).setMaterial(rs.getString("material"));
				((Juguete) prod).setArticulable(rs.getString("articulable"));
				((Juguete) prod).setEdadMinima(rs.getInt("edad_minima"));
				((Juguete) prod).setPilas(rs.getString("pilas"));
				listaProd.put(prod.getCodigoProducto(), prod);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaProd;
	}

	public Map<String, Producto> listarProdPeli() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listaProd = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_PROD_PELI);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Pelicula_Serie();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setPrecio(rs.getFloat("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				((Pelicula_Serie) prod).setGenero(rs.getString("genero"));
				((Pelicula_Serie) prod).setFechaLanzamiento(rs.getString("fecha_de_lanzamiento"));
				((Pelicula_Serie) prod).setIdioma(rs.getString("idioma"));
				((Pelicula_Serie) prod).setSubtitulado(rs.getString("subtitulado"));
				((Pelicula_Serie) prod).setDuracion(rs.getString("duracion"));
				listaProd.put(prod.getCodigoProducto(), prod);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaProd;
	}

	public void insertarPersona(Persona pers) {
		this.openConnection();

		try {
			stmt = con.prepareStatement(INSERT_PERSONA);

			stmt.setString(1, pers.getCodigoPersona());
			stmt.setString(2, pers.getNombre());
			stmt.setString(3, pers.getEmail());
			stmt.setInt(4, pers.getNumTelefono());
			stmt.setString(5, pers.getContrasena());
			if (stmt.executeUpdate() == 1) {
				if (pers instanceof Usuario) {
					stmt = con.prepareStatement(INSERT_USUARIO);

					stmt.setString(1, pers.getCodigoPersona());
					stmt.setString(2, ((Usuario) pers).getNumeroTarjeta());
					stmt.setString(3, ((Usuario) pers).getNombrePersonal());
					stmt.setString(4, ((Usuario) pers).getApellido());
					stmt.setString(5, (((Usuario) pers).getFecha_nacimiento()));
					stmt.setString(6, ((Usuario) pers).getDireccion());

					stmt.executeUpdate();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto- generated catch block
			e.printStackTrace();
		}

	}

	public void insertarTarjeta(Tarjeta tar) {
		this.openConnection();

		try {
			stmt = con.prepareStatement(INSERT_TARJETA);

			stmt.setString(1, tar.getNumeroTarjeta());
			stmt.setInt(2, tar.getCVV());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto- generated catch block
			e.printStackTrace();
		}

	}

	public int numeroPersona(Persona pers) {
		ResultSet rs = null;
		String numPersona = "SELECT COUNT(codigo_persona)FROM persona";
		int n = 0;
		this.openConnection();

		try {
			stmt = con.prepareStatement(numPersona);
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

}