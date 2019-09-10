package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Auditor;

public interface IAuditorService {

	public void insertar(Auditor auditor);
	public void eliminar(int idAuditor);
	public List<Auditor> listar();

}
