package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Empleado;

public interface IEmpleadoDao {
	
	public void insertar(Empleado empleado);
	public void eliminar(int idEmpleado);
	public void modificar(Empleado empleado);
	public List<Empleado> listar();
}
