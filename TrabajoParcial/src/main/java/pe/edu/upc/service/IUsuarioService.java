package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Usuario;

public interface IUsuarioService {
	Integer Insertar(Usuario us) throws Exception;

	Integer Actualizar(Usuario us) throws Exception;

	Integer Borrar(Usuario us) throws Exception;

	List<Usuario> getAll() throws Exception;

	Optional<Usuario> getOne(Usuario us) throws Exception;

	Optional<Usuario> autenticacion(Usuario us) throws Exception;
}
