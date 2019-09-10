package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEspecialidadDao;
import pe.edu.upc.entity.Especialidad;

public class EspecialidadDaoImpl implements IEspecialidadDao, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(Especialidad especialidad)
	{
		try
		{
			em.persist(especialidad);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional	
	@Override
	public void eliminar(int idEspecialidad)
	{
	
		Especialidad esp = new Especialidad();
		try {
			esp = em.getReference(Especialidad.class, idEspecialidad);
			em.remove(esp);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
