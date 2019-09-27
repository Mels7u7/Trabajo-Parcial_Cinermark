package pe.edu.upc.dao;

import java.util.List;


import pe.edu.upc.entity.Sede;

public interface ISedeDao {

	public void insertar(Sede sede);
	public void eliminar(int idSede);
	public void modificar(Sede sede);
	public List<Sede> listar();
	
}
