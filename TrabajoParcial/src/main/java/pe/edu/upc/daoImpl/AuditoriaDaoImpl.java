package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public void insertar(Auditoria auditoria) {
		try {
			em.persist(auditoria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional
	@Override
	public void eliminar(int idAuditoria) {
		Auditoria audi = new Auditoria();
		try {
			audi = em.getReference(Auditoria.class, idAuditoria);
			em.remove(audi);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auditoria> listar() {
		List<Auditoria> lista = new ArrayList<Auditoria>();
		try {
			Query q = em.createQuery("Select au from Auditoria au");
			lista = (List<Auditoria>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void modificar(Auditoria auditoria) {
		try {
			em.merge(auditoria);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
