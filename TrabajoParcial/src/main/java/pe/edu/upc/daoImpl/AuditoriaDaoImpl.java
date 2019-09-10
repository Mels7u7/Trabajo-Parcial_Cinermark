package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IAuditoriaDao;
import pe.edu.upc.entity.Auditoria;

public class AuditoriaDaoImpl implements IAuditoriaDao, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(Auditoria auditoria)
	{
		try
		{
			em.persist(auditoria);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional	
	@Override
	public void eliminar(int idAuditoria)
	{
	
		Auditoria aud = new Auditoria();
		try {
			aud = em.getReference(Auditoria.class, idAuditoria);
			em.remove(aud);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
