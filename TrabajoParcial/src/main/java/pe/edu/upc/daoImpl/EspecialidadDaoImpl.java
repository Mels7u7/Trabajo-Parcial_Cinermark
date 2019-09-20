package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> listar() {
		List<Especialidad> lista = new ArrayList<Especialidad>();
		try
		{
			Query q = em.createQuery("Select e from Especialidad e");
			lista = (List<Especialidad>) q.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

}
