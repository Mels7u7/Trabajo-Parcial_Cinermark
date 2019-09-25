package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEmpleadoxAuditoriaDao;

import pe.edu.upc.entity.EmpleadoxAuditoria;

public class EmpleadoxAuditoriaDaoImpl implements IEmpleadoxAuditoriaDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="TrabajoParcial")
	private EntityManager em;
	
    @Transactional
	@Override
	public void insertar(EmpleadoxAuditoria empleadoxAuditoria) {
		// TODO Auto-generated method stub
    	try
		{
			em.persist(empleadoxAuditoria);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
    @Transactional
	@Override
	public void eliminar(int idEmpeladoxAuditoria) {
		// TODO Auto-generated method stub
		
    	EmpleadoxAuditoria emp = new EmpleadoxAuditoria();
		try {
			emp = em.getReference(EmpleadoxAuditoria.class, idEmpeladoxAuditoria);
			em.remove(emp);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    	
    	
    	
	}
    
    @Transactional
	@Override
	public void modificar(EmpleadoxAuditoria empleadoxAuditoria) {
		// TODO Auto-generated method stub
		
    	try {
			em.merge(empleadoxAuditoria);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
    
    @SuppressWarnings("unchecked")
	@Override
	public List<EmpleadoxAuditoria> listar() {
		// TODO Auto-generated method stub
    	List<EmpleadoxAuditoria> lista = new ArrayList<EmpleadoxAuditoria>();
		try
		{
			Query q = em.createQuery("Select h from EmpleadoxAuditoria h");
			lista = (List<EmpleadoxAuditoria>) q.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

}
