package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Auditoria;

public interface IAuditoriaDao {

	public void insertar(Auditoria auditoria);
	public void eliminar(int idAuditoria);
	public List<Auditoria> listar();
}
