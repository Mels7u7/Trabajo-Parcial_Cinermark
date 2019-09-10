package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISedeDao;
import pe.edu.upc.entity.Sede;

public class SedeDaoImpl implements ISedeDao, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(Sede sede)
	{
		try
		{
			em.persist(sede);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
