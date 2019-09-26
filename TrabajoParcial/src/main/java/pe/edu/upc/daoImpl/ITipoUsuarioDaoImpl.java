package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.dao.ITipoUsuarioDao;
import pe.edu.upc.entity.TipoUsuario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioR;

public class ITipoUsuarioDaoImpl implements ITipoUsuarioDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;

	@Override
	public Integer Insertar(TipoUsuario tip) throws Exception {
		em.persist(tip);
		return tip.getId();
	}

	@Override
	public Integer Actualizar(TipoUsuario tip) throws Exception {
		em.merge(tip);
		return tip.getId();
	}

	@Override
	public Integer Borrar(TipoUsuario tip) throws Exception {
		em.remove(tip);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoUsuario> findAll() throws Exception {
		List<TipoUsuario> tip = new ArrayList<TipoUsuario>();

		Query q = em.createQuery("SELECT r FROM Tipo r");
		tip = (List<TipoUsuario>) q.getResultList();
		return tip;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<TipoUsuario> findById(TipoUsuario tip) throws Exception {
		TipoUsuario t = new TipoUsuario();
		List<TipoUsuario> tipos = new ArrayList<TipoUsuario>();
		Query query = em.createQuery("FROM Rol r where r.id = ?1");
		query.setParameter(1, tip.getId());

		tipos = (List<TipoUsuario>) query.getResultList();

		if (tipos != null && !tipos.isEmpty()) {
			t = tipos.get(0);
		}

		return Optional.of(t);
	}

	@Override
	public Integer insertUserRole(List<UsuarioR> tipUsu) throws Exception {
		try {

			final int[] iarr = { 0 };
			tipUsu.forEach(r -> {
				em.persist(r);
				if (iarr[0] % 100 == 0) {
					em.flush();
					em.clear();
				}
				iarr[0]++;
			});
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioR> findUserRolesByUser(Usuario usu) throws Exception {
		List<UsuarioR> usut = new ArrayList<UsuarioR>();

		try {
			Query query = em.createQuery("FROM UserRol ur where ur.user.customer.id =?1");
			query.setParameter(1, usu.getId());

			usut = (List<UsuarioR>) query.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return usut;
	}
}
