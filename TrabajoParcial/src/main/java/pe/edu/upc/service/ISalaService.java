package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Sala;

public interface ISalaService {

	public void insertar(Sala sala);
	public void eliminar(int idSala);
	public List<Sala> listar();

}
