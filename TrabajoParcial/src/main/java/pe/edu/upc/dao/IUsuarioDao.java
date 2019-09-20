package pe.edu.upc.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Usuario;

public interface IUsuarioDao {
	Integer insert(Usuario us) throws Exception;

	Integer update(Usuario us) throws Exception;

	Integer delete(Usuario us) throws Exception;

	List<Usuario> findAll() throws Exception;

	Optional<Usuario> findById(Usuario us) throws Exception;

	String getPassworHashedByUserName(String nusuario) throws Exception;

	Optional<Usuario> findUserByUsername(Usuario us) throws Exception;
}
