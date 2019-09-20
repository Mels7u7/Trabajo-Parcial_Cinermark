package pe.edu.upc.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entity.Usuario;

@Named
public class UsuarioDaoImpl implements IUsuarioDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;

	@Override
	public Integer insert(Usuario us) throws Exception {
		em.persist(us);
		return us.getId();
	}

	@Override
	public Integer update(Usuario us) throws Exception {
		em.merge(us);
		return us.getId();
	}

	@Override
	public Integer delete(Usuario us) throws Exception {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() throws Exception {
		List<Usuario> usua = new ArrayList<>();
		Query q = em.createQuery("Select m from m");
		usua = (List<Usuario>) q.getResultList();
		return usua;
	}

	@Override
	public Optional<Usuario> findById(Usuario us) throws Exception {
		Usuario usua;
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM User u WHERE u.id = ?1", Usuario.class);
		query.setParameter(1, us.getId());

		usua = query.getSingleResult();

		return Optional.of(usua);
	}

	@Override
	public String getPassworHashedByUserName(String nusuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> findUserByUsername(Usuario us) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
