package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISedeDao;
import pe.edu.upc.entity.Empleado;
import pe.edu.upc.entity.Sede;
import pe.edu.upc.service.ISedeService;

@Named
@RequestScoped
public class SedeServiceImpl implements ISedeService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISedeDao sD;
	
	@Override
	public void insertar(Sede sede) {
		sD.insertar(sede);
	}
	
	@Override
	public void eliminar(int idSede)
	{
		sD.eliminar(idSede);
	}
	
	@Override
	public List<Sede> listar()
	{
		return sD.listar();
	}
	
	@Override
	public void modificar(Sede sede) {
		sD.modificar(sede);
	}
}
