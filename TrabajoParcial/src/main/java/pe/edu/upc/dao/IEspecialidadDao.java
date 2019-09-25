package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Especialidad;

public interface IEspecialidadDao {

	public void insertar(Especialidad especialidad);

	public void eliminar(int idEspecialidad);

	public List<Especialidad> listar();

	public void modificar(Especialidad especialidad);
}
