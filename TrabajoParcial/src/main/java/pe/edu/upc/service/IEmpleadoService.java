package pe.edu.upc.service;

import java.util.List;



import pe.edu.upc.entity.Empleado;

public interface IEmpleadoService {

	public void insertar(Empleado empleado);
	public void eliminar(int idEmpleado);
	public void modificar (Empleado empleado);
	public List<Empleado> listar();

}