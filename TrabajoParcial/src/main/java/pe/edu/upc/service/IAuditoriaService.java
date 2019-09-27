package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Auditoria;

public interface IAuditoriaService {

	public void insertar(Auditoria auditoria);

	public void eliminar(int idAuditoria);

	public void modificar(Auditoria auditoria);

	public List<Auditoria> listar();

}
