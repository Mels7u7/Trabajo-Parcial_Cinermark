package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetalleDeAuditoria;

public interface IDetalleAuditoriaService {

	public void insertar(DetalleDeAuditoria DDA);

	public void eliminar(int idDDA);

	public List<DetalleDeAuditoria> listar();

}
