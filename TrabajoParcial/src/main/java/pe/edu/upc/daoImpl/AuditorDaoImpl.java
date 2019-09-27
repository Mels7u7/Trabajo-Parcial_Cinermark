package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IAuditorDao;
import pe.edu.upc.entity.Auditor;

public class AuditorDaoImpl implements IAuditorDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Auditor auditor) {
		try {
			em.persist(auditor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional
	@Override
	public void eliminar(int idAuditor) {

		Auditor aud = new Auditor();
		try {
			aud = em.getReference(Auditor.class, idAuditor);
			em.remove(aud);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auditor> listar() {
		List<Auditor> lista = new ArrayList<Auditor>();
		try {
			Query q = em.createQuery("Select a from Auditor a");
			lista = (List<Auditor>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	@Transactional
	@Override
	public void modificar(Auditor auditor) {
		try {
			em.merge(auditor);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
