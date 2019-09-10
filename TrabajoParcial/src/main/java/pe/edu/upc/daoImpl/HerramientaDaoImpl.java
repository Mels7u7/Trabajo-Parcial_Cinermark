package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IHerramientaDao;
import pe.edu.upc.entity.Herramienta;

public class HerramientaDaoImpl implements IHerramientaDao, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(Herramienta herramienta)
	{
		try
		{
			em.persist(herramienta);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
