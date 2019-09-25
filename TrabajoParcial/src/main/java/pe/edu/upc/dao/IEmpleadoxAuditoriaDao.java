package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.EmpleadoxAuditoria;

public interface IEmpleadoxAuditoriaDao {

	public void insertar (EmpleadoxAuditoria empleadoxAuditoria);
	public void eliminar (int idEmpeladoxAuditoria);
	public void modificar (EmpleadoxAuditoria empleadoxAuditoria);
	public List<EmpleadoxAuditoria> listar();
	
}

