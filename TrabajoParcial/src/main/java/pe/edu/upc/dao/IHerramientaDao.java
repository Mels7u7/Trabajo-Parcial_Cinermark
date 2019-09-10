package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Herramienta;

public interface IHerramientaDao {

	public void insertar(Herramienta herramienta);
	public void eliminar(int idHerramienta);
	public List<Herramienta> listar();
	
}
