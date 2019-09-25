package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.EmpleadoxAuditoria;

public interface IEmpleadoxAuditoriaService {

	public void insertar (EmpleadoxAuditoria empleadoxAuditoria);
	public void eliminar (int idEmpeladoxAuditoria);
	public void modificar (EmpleadoxAuditoria empleadoxAuditoria);
	public List<EmpleadoxAuditoria> listar();
	

	
}
