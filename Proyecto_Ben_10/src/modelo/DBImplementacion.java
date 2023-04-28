package modelo;

import java.util.ArrayList;
import java.util.Map;

import clases.Cesta_Compra;
import clases.Persona;
import clases.Producto;
import clases.Tarjeta;

public interface DBImplementacion {

	public void insertarProducto(Producto prod);

	public boolean validarFloat(String cadena);

	public int numeroProducto(Producto prod);

	public ArrayList<Producto> recogerProductos();

	public void eliminarProducto(Producto prod);

	public Producto recogerProductoId(String codigo_producto);

	public Producto recogerLineaRopaId(String codigo_producto);

	public Producto recogerJugueteId(String codigo_producto);

	public Producto recogerPeliculaId(String codigo_producto);

	public void modificarProducto(Producto prod);


	public Map<String, Cesta_Compra> listarCompra();
	
	public Map<String, Producto> listarProdRopa();
	
	public Map<String, Producto> listarProdJuguete();
	
	public Map<String, Producto> listarProdPeli();
	
	public void insertarTarjeta(Tarjeta tar);
	
	public int numeroPersona(Persona pers);
	
	public void insertarPersona(Persona pers);
}

