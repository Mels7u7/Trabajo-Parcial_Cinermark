package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Auditor;
public interface IAuditorService {

	public void insertar(Auditor auditor);

	public void eliminar(int idAuditor);

	public void modificar(Auditor auditor);

	public List<Auditor> listar();

	List<Auditor> getAll() throws Exception;

	Optional<Auditor> getOne(Auditor aud) throws Exception;

	List<Auditor> findAuditorByName(String name) throws Exception;

	Optional<Auditor> findAuditorByDni(String dni) throws Exception;

}
