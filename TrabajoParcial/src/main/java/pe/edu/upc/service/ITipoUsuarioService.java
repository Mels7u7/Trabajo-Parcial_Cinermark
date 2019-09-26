package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.TipoUsuario;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.UsuarioR;

public interface ITipoUsuarioService {
	Integer insert(TipoUsuario tU) throws Exception;

	Integer update(TipoUsuario tU) throws Exception;

	Integer delete(TipoUsuario tU) throws Exception;

	List<TipoUsuario> getAll() throws Exception;

	Optional<TipoUsuario> getOne(TipoUsuario tU) throws Exception;

	Integer assignRolesToUser(Usuario usu, List<TipoUsuario> tU) throws Exception;

	List<UsuarioR> findUserRolesByUser(Usuario usu) throws Exception;
}
