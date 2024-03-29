package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IHerramientaDao;
import pe.edu.upc.entity.Herramienta;
import pe.edu.upc.service.IHerramientaService;

@Named
@RequestScoped
public class HerramientaServiceImpl implements IHerramientaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IHerramientaDao hD;

	@Override
	public void insertar(Herramienta herramienta) {
		hD.insertar(herramienta);
	}

	@Override
	public void eliminar(int idHerramienta) {
		hD.eliminar(idHerramienta);
	}

	@Override
	public List<Herramienta> listar() {
		return hD.listar();
	}

}
