package pe.edu.upc.serviceImpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAuditoriaDao;
import pe.edu.upc.entity.Auditoria;
import pe.edu.upc.service.IAuditoriaService;

@Named
@RequestScoped
public class AuditoriaServiceImpl implements IAuditoriaService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IAuditoriaDao aD;
	
	@Override
	public void insertar(Auditoria auditoria) {
		aD.insertar(auditoria);
	}

}
