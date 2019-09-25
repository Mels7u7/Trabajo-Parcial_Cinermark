package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISalaDao;
import pe.edu.upc.entity.Sala;

@Named
public class SalaDaoImpl implements ISalaDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Sala sala) {
		try {
			em.persist(sala);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional
	@Override
	public void eliminar(int idSala) {

		Sala sala = new Sala();
		try {
			sala = em.getReference(Sala.class, idSala);
			em.remove(sala);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sala> listar() {
		List<Sala> lista = new ArrayList<Sala>();
		try {
			Query q = em.createQuery("Select s from Sala s");
			lista = (List<Sala>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	@Transactional
	@Override
	public void modificar(Sala sala) {
		try {
			em.merge(sala);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
