package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISalaDao;
import pe.edu.upc.entity.Sala;

public class SalaDaoImpl implements ISalaDao, Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(Sala sala)
	{
		try
		{
			em.persist(sala);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional	
	@Override
	public void eliminar(int idSala)
	{
	
		Sala sala = new Sala();
		try {
			sala = em.getReference(Sala.class, idSala);
			em.remove(sala);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
