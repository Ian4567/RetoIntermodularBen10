package modelo;

import java.util.ArrayList;
import java.util.Map;

import clases.Cesta_Compra;
import clases.Producto;

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

	public Map<String, Producto> listarProducto();

	public Map<String, Cesta_Compra> listarCompra();
}
