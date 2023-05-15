package modelo;

import java.util.ArrayList;
import java.util.Map;

import clases.Cesta_Compra;
import clases.Persona;
import clases.Producto;
import clases.Realiza;
import clases.Tarjeta;

public interface DAO {

	public void insertarProducto(Producto prod);

	public boolean validarFloat(String cadena);

	public int numeroProducto(Producto prod);

	public Persona recogerDatosPersonaEmail(String email);

	public ArrayList<Producto> recogerProductos();

	public void eliminarProducto(Producto prod);

	public Producto recogerProductoId(String codigo_producto);

	public Producto recogerLineaRopaId(String codigo_producto);

	public Producto recogerJugueteId(String codigo_producto);

	public Producto recogerPeliculaId(String codigo_producto);

	public void modificarProducto(Producto prod);

	public Map<String, Cesta_Compra> listarCompra(Persona per);

	public Map<String, Producto> listarProdRopa();

	public Map<String, Producto> listarProdJuguete();

	public Map<String, Producto> listarProdPeli();

	public void insertarTarjeta(Tarjeta tar);

	public int numeroPersona(Persona pers);

	public void insertarPersona(Persona pers);

	public boolean esEmail(String email);

	public int existePersona(String persona);

	public int existeNumeroTarjeta(long numeroTarjeta);

	public Persona login(Persona per);

	public int numeroReferencia(Cesta_Compra cesta);

	public void insertarCompra_Cesta(Cesta_Compra cesta);

	public void insertarRealiza(Realiza realiza);

	public Tarjeta recogerDatosTarjeta(String email);

	public void eliminarCuenta(Persona per);

	public void modificarCesta(Cesta_Compra cesta, Persona pers);

	public void eliminarRealiza(Persona pers);

	public void eliminarCesta(Persona pers);

	public void eliminarTarjeta(Persona pers);

	public void añadirStockProducto(Producto prod, Persona pers);

	public ArrayList<Producto> recogerProductosId(Persona pers);

	public ArrayList<Realiza> recogerCantidad(Persona pers);

	public boolean validarInt(String cadena);

	public boolean validarLong(String cadena);

	public Cesta_Compra crearOferta(String numReferencia);

	public int existeEmail(String persona);

	public int existeTelefono(int numTelefono);
}
