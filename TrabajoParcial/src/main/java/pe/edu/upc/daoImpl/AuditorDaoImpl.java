package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IAuditorDao;
import pe.edu.upc.entity.Auditor;

public class AuditorDaoImpl implements IAuditorDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(Auditor auditor)
	{
		try
		{
			em.persist(auditor);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
