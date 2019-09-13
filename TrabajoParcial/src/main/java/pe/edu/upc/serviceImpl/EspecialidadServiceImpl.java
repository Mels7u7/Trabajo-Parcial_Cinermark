package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEspecialidadDao;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.service.IEspecialidadService;

@Named
@RequestScoped
public class EspecialidadServiceImpl implements IEspecialidadService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IEspecialidadDao eD;
	
	@Override
	public void insertar(Especialidad especialidad) {
		eD.insertar(especialidad);
	}
	
	@Override
	public void eliminar(int idEspecialidad)
	{
		eD.eliminar(idEspecialidad);
	}

	@Override
	public List<Especialidad> listar() {
		return eD.listar();
	}
}
