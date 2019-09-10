package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Auditor;

public interface IAuditorDao {

	public void insertar(Auditor auditor);
	public void eliminar(int idAuditor);
	public List<Auditor> listar();
}
