package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pe.edu.upc.dao.IDetalleAuditoria;
import pe.edu.upc.entity.DetalleDeAuditoria;
import pe.edu.upc.service.IDetalleAuditoriaService;

@Named
@RequestScoped
public class DetalleAuditoriaServiceImpl implements IDetalleAuditoriaService, Serializable {

	private static final long serialVersionUID = 1L;

	private IDetalleAuditoria daD;

	@Override
	public void insertar(DetalleDeAuditoria DDA) {
		daD.insertar(DDA);
	}

	@Override
	public void eliminar(int idDDA) {
		daD.eliminar(idDDA);

	}

	@Override
	public List<DetalleDeAuditoria> listar() {
		// TODO Auto-generated method stub
		return daD.listar();
	}

}
