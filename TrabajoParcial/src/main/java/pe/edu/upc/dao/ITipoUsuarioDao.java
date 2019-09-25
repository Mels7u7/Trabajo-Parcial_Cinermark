package pe.edu.upc.dao;

import java.util.List;
import java.util.Optional; 

import pe.edu.upc.entity.UsuarioR;
import pe.edu.upc.entity.Usuario;
import pe.edu.upc.entity.TipoUsuario;

public interface ITipoUsuarioDao {
	Integer Insertar(TipoUsuario tip) throws Exception;

	Integer Actualizar(TipoUsuario tip) throws Exception;

	Integer Borrar(TipoUsuario tip) throws Exception;

	List<TipoUsuario> findAll() throws Exception;

	Optional<TipoUsuario> findById(TipoUsuario tip) throws Exception;

	Integer insertUserRole(List<UsuarioR> tipUsu) throws Exception;

	List<UsuarioR> findUserRolesByUser(Usuario usu) throws Exception;
}
