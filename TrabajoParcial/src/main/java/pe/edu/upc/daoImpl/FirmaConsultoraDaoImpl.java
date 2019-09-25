package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IFirmaConsultoraDao;
import pe.edu.upc.entity.Auditoria;
import pe.edu.upc.entity.FirmaConsultora;

public class FirmaConsultoraDaoImpl implements IFirmaConsultoraDao, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(FirmaConsultora firma)
	{
		try
		{
			em.persist(firma);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional	
	@Override
	public void eliminar(int idFirma)
	{
	
		FirmaConsultora firm = new FirmaConsultora();
		try {
			firm = em.getReference(FirmaConsultora.class, idFirma);
			em.remove(firm);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Transactional
	@Override
	public void modificar(FirmaConsultora firma) {
		try {
			em.merge(firma);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FirmaConsultora> listar()
	{
		List<FirmaConsultora> lista = new ArrayList<FirmaConsultora>();
		try
		{
			Query q = em.createQuery("Select f from FirmaConsultora f");
			lista = (List<FirmaConsultora>) q.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

}
