package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDetalleAuditoria;
import pe.edu.upc.entity.DetalleDeAuditoria;

public class DetalleAuditoriaDaoImpl implements IDetalleAuditoria, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(DetalleDeAuditoria DDA) {
		try {
			em.persist(DDA);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Transactional
	@Override
	public void eliminar(int idDDA) {
		DetalleDeAuditoria dda = new DetalleDeAuditoria();
		try {
			dda = em.getReference(DetalleDeAuditoria.class, idDDA);
			em.remove(dda);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleDeAuditoria> listar() {
		List<DetalleDeAuditoria> lista = new ArrayList<DetalleDeAuditoria>();
		try {
			Query q = em.createQuery("Select h from EmpleadoxAuditoria h");
			lista = (List<DetalleDeAuditoria>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
}
