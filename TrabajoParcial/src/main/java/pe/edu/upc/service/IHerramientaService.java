package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Herramienta;

public interface IHerramientaService {

	public void insertar(Herramienta herramienta);
	public void eliminar(int idHerramienta);
	public List<Herramienta> listar();

}
