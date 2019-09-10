package pe.edu.upc.serviceImpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.dao.IEmpleadoDao;
import pe.edu.upc.entity.Empleado;
import pe.edu.upc.service.IEmpleadoService;

@Named
@RequestScoped
public class EmpleadoServiceImpl implements IEmpleadoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IEmpleadoDao eD;
	
	@Override
	public void insertar(Empleado empleado) {
		eD.insertar(empleado);
	}
	
	@Override
	public void eliminar(int idEmpleado)
	{
		eD.eliminar(idEmpleado);
	}
}
