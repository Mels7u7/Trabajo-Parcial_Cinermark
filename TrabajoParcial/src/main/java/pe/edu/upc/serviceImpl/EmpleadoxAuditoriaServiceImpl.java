package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEmpleadoxAuditoriaDao;
import pe.edu.upc.entity.EmpleadoxAuditoria;
import pe.edu.upc.service.IEmpleadoxAuditoriaService;

@Named
@RequestScoped
public class EmpleadoxAuditoriaServiceImpl implements IEmpleadoxAuditoriaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private IEmpleadoxAuditoriaDao eD;

	@Override
	public void insertar(EmpleadoxAuditoria empleadoxAuditoria) {
		// TODO Auto-generated method stub
		eD.insertar(empleadoxAuditoria);
	}

	@Override
	public void eliminar(int idEmpeladoxAuditoria) {
		// TODO Auto-generated method stub
		eD.eliminar(idEmpeladoxAuditoria);
	}

	@Override
	public void modificar(EmpleadoxAuditoria empleadoxAuditoria) {
		// TODO Auto-generated method stub
		eD.modificar(empleadoxAuditoria);
		
	}

	@Override
	public List<EmpleadoxAuditoria> listar() {
		// TODO Auto-generated method stub
		return eD.listar();
	}

}
