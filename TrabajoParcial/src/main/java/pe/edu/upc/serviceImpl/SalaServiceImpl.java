package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISalaDao;
import pe.edu.upc.entity.Sala;
import pe.edu.upc.service.ISalaService;

@Named
@RequestScoped
public class SalaServiceImpl implements ISalaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ISalaDao sD;

	@Override
	public void insertar(Sala sala) {
		sD.insertar(sala);
	}

	@Override
	public void eliminar(int idSala) {
		sD.eliminar(idSala);
	}

	@Override
	public List<Sala> listar() {
		return sD.listar();
	}

	@Override
	public void modificar(Sala sala) {
		sD.modificar(sala);
	}
}
