package modelo;

import java.util.ArrayList;

import clases.Producto;

public interface DBImplementacion{
	
	public void insertarProducto(Producto prod);
	
	public boolean validarFloat(String cadena);
	
	public int numeroProducto(Producto prod);
	
	public ArrayList<Producto> recogerProductos();
}
