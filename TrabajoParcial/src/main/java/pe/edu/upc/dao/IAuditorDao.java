package pe.edu.upc.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Auditor;

public interface IAuditorDao {

	public void insertar(Auditor auditor);

	public void eliminar(int idAuditor);
	
	public void modificar(Auditor auditor);

	public List<Auditor> listar();
	
	List<Auditor> findAll() throws Exception;

	Optional<Auditor> findById(Auditor aud) throws Exception;

	List<Auditor> findByName(String name) throws Exception;

	Optional<Auditor> findByDni(String dni) throws Exception;
}
