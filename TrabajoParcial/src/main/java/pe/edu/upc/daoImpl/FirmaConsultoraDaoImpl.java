package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IFirmaConsultoraDao;
import pe.edu.upc.entity.FirmaConsultora;

public class FirmaConsultoraDaoImpl implements IFirmaConsultoraDao, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(FirmaConsultora firma)
	{
		try
		{
			em.persist(firma);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
