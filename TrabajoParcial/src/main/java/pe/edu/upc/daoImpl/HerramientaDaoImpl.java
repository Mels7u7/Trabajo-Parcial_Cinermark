package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		try {
			em.persist(herramienta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional	
	@Override
	public void eliminar(int idHerramienta)
	{
	
		Herramienta her = new Herramienta();
		try {
			her = em.getReference(Herramienta.class, idHerramienta);
			em.remove(her);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Herramienta> listar()
	{
		List<Herramienta> lista = new ArrayList<Herramienta>();
		try {
			Query q = em.createQuery("Select h from Herramienta h");
			lista = (List<Herramienta>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

}
