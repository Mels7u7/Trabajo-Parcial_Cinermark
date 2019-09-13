package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Especialidad;

public interface IEspecialidadService {

	public void insertar(Especialidad especialidad);
	public void eliminar(int idEspecialidad);
	public List<Especialidad> listar();
}
