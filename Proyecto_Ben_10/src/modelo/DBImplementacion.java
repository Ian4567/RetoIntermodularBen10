package modelo;

import java.util.ArrayList;

import clases.Producto;
import clases.Tarjeta;
import clases.Usuario;

public interface DBImplementacion {

	public void insertarProducto(Producto prod);

	public boolean validarFloat(String cadena);

	public int numeroProducto(Producto prod);

	public ArrayList<Producto> recogerProductos();

	public void eliminarProducto(Producto prod);

	public Producto recogerProductoId(String codigo_producto);
	
	public Producto recogerLineaRopaId(String codigo_producto);
	
	public Producto recogerJugueteId(String codigo_producto);
	
	public void registro(Usuario us, Tarjeta tar);
}
