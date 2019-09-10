package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Sede;

public interface ISedeService {

	public void insertar(Sede sede);
	public void eliminar(int idSede);
	public List<Sede> listar();

}
