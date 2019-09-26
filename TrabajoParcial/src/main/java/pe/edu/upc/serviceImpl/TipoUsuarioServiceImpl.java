package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import pe.edu.upc.dao.ITipoUsuarioDao;
import pe.edu.upc.entity.TipoUsuario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioR;
import pe.edu.upc.service.ITipoUsuarioService;

public class TipoUsuarioServiceImpl implements ITipoUsuarioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ITipoUsuarioDao tD;

	@Override
	public Integer insert(TipoUsuario tU) throws Exception {
		return tD.Insertar(tU);
	}

	@Override
	public Integer update(TipoUsuario tU) throws Exception {
		return tD.Actualizar(tU);
	}

	@Override
	public Integer delete(TipoUsuario tU) throws Exception {
		return tD.Borrar(tU);
	}

	@Override
	public List<TipoUsuario> getAll() throws Exception {
		return tD.findAll();
	}

	@Override
	public Optional<TipoUsuario> getOne(TipoUsuario tU) throws Exception {
		return tD.findById(tU);
	}

	@Override
	public Integer assignRolesToUser(Usuario usu, List<TipoUsuario> tU) throws Exception {
		List<UsuarioR> usuT = new ArrayList<>();

		tU.forEach(t -> {
			UsuarioR userR = new UsuarioR();
			userR.setUsuario(usu);
			userR.setTipo(t);
			usuT.add(userR);
		});

		tD.insertUserRole(usuT);

		return 1;
	}

	@Override
	public List<UsuarioR> findUserRolesByUser(Usuario usu) throws Exception {
		return tD.findUserRolesByUser(usu);
	}
}
