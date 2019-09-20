package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IUsuarioDao uD;

	@Transactional
	@Override
	public Integer Insertar(Usuario us) throws Exception {
		return uD.insert(us);
	}

	@Transactional
	@Override
	public Integer Actualizar(Usuario us) throws Exception {
		return uD.update(us);
	}

	@Transactional
	@Override
	public Integer Borrar(Usuario us) throws Exception {
		return uD.delete(us);
	}

	@Override
	public List<Usuario> getAll() throws Exception {
		return uD.findAll();
	}

	@Override
	public Optional<Usuario> getOne(Usuario us) throws Exception {
		return uD.findById(us);
	}

	@Override
	public Optional<Usuario> autenticacion(Usuario us) throws Exception {
		String contrase�a = us.getContrase�a();

		String passwordHash = uD.getPassworHashedByUserName(us.getNusuario());

		if (BCrypt.checkpw(contrase�a, passwordHash)) {
			us.setContrase�a(passwordHash);
			return uD.findUserByUsername(us);
		}

		return Optional.of(new Usuario());
	}

}
