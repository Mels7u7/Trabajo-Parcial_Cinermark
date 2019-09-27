package pe.edu.upc.serviceImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAuditorDao;
import pe.edu.upc.entity.Auditor;
import pe.edu.upc.service.IAuditorService;

@Named
@RequestScoped
public class AuditorServiceImpl implements IAuditorService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IAuditorDao aD;

	@Override
	public void insertar(Auditor auditor) {
		aD.insertar(auditor);
	}

	@Override
	public void eliminar(int idAuditor) {
		aD.eliminar(idAuditor);
	}

	@Override
	public List<Auditor> listar() {
		return aD.listar();
	}

	@Override
	public void modificar(Auditor auditor) {
		aD.modificar(auditor);

	}

	@Override
	public List<Auditor> getAll() throws Exception {
		return aD.findAll();
	}

	@Override
	public Optional<Auditor> getOne(Auditor aud) throws Exception {
		return aD.findById(aud);
	}

	@Override
	public List<Auditor> findAuditorByName(String name) throws Exception {
		return aD.findByName(name);
	}

	@Override
	public Optional<Auditor> findAuditorByDni(String dni) throws Exception {
		return aD.findByDni(dni);
	}
}
