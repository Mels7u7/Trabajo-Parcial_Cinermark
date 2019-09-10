package pe.edu.upc.serviceImpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAuditorDao;
import pe.edu.upc.entity.Auditor;
import pe.edu.upc.service.IAuditorService;

@Named
@RequestScoped
public class AuditorServiceImpl implements IAuditorService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IAuditorDao aD;
	
	@Override
	public void insertar(Auditor auditor) {
		aD.insertar(auditor);
	}
}
