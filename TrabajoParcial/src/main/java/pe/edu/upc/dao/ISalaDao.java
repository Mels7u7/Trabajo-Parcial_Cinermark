package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Sala;

public interface ISalaDao {

	public void insertar(Sala sala);

	public void eliminar(int idSala);
	
	public void modificar(Sala sala);

	public List<Sala> listar();

}
