package pe.edu.upc.daoImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	@Transactional	
	@Override
	public void eliminar(int idSede)
	{
	
		Sede sede = new Sede();
		try {
			sede = em.getReference(Sede.class, idSede);
			em.remove(sede);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sede> listar()
	{
		List<Sede> lista = new ArrayList<Sede>();
		try
		{
			Query q = em.createQuery("Select s from Sede s");
			lista = (List<Sede>) q.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
	
	@Transactional
	@Override
	public void modificar(Sede sede) {
		try {
			em.merge(sede);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
