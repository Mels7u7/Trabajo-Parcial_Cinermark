package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Auditor> findAll() throws Exception {
		List<Auditor> aud = new ArrayList<Auditor>();

		Query q = em.createQuery("SELECT c FROM Customer c");
		aud = (List<Auditor>) q.getResultList();
		return aud;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Auditor> findById(Auditor aud) throws Exception {
		Auditor audF = new Auditor();

		List<Auditor> aud2 = new ArrayList<Auditor>();
		Query q = em.createQuery("FROM Auditor c where c.id = ?1");
		q.setParameter(1, aud.getIdAuditor());

		aud2 = (List<Auditor>) q.getResultList();

		if (aud2 != null && !aud2.isEmpty()) {
			audF = aud2.get(0);
		}
		return Optional.of(audF);
	}

	@Override
	public List<Auditor> findByName(String name) throws Exception {
		return em.createQuery("from Auditor where name like :name", Auditor.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}

	@Override
	public Optional<Auditor> findByDni(String dni) throws Exception {
		Auditor aud;
		TypedQuery<Auditor> audE = em.createQuery("Select c from Auditor c  where c.dni =:dni", Auditor.class);
		audE.setParameter("dni", dni);
		aud = audE.getSingleResult();

		return Optional.of(aud);
	}
}
