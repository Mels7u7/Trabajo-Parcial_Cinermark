package pe.edu.upc.serviceImpl;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IFirmaConsultoraDao;
import pe.edu.upc.entity.FirmaConsultora;
import pe.edu.upc.service.IFirmaConsultoraService;

@Named
@RequestScoped
public class FirmaConsultoraServiceImpl implements IFirmaConsultoraService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IFirmaConsultoraDao fD;
	
	@Override
	public void insertar(FirmaConsultora firma) {
		fD.insertar(firma);
	}
}
