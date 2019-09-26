package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.DetalleDeAuditoria;

public interface IDetalleAuditoria {
	public void insertar(DetalleDeAuditoria DDA);

	public void eliminar(int idDDA);

	public void modificar(DetalleDeAuditoria DDA);

	public List<DetalleDeAuditoria> listar();
}
