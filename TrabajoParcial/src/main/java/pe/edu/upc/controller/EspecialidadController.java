package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.service.IEspecialidadService;

@Named
@RequestScoped
public class EspecialidadController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IEspecialidadService esService;

	private Especialidad especialidad;

	List<Especialidad> listaEspecialidades;

	private String mensaje = "";

	@PostConstruct
	public void init() {
		this.listaEspecialidades = new ArrayList<Especialidad>();
		this.especialidad = new Especialidad();
		this.listar();
	}

	public String nuevaEspecialidad() {
		this.setEspecialidad(new Especialidad());
		return "especialidad.xhtml";
	}

	public void insertar() {
		try {
			esService.insertar(especialidad);
			limpiarEspecialidad();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(Especialidad especialidad) {
		try {
			esService.eliminar(especialidad.getIdEspecialidad());

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listar() {
		try {
			listaEspecialidades = esService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarEspecialidad() {
		this.init();
	}

	public String detallesEspecialidad(Especialidad _especialidad) {
		this.setEspecialidad(_especialidad);
		return "detalleEspecialidad.xhtml";
	}

	public void modificar() {
		try {
			esService.modificar(this.especialidad);
			limpiarEspecialidad();
			this.listar();
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede modificar";
		}
	}

	public String editar(Especialidad especialidad) {
		this.setEspecialidad(especialidad);
		return "modifEspecialidad.xhtml";
	}

	// get y set

	public IEspecialidadService getEsService() {
		return esService;
	}

	public void setEsService(IEspecialidadService esService) {
		this.esService = esService;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<Especialidad> getListaEspecialidades() {
		return listaEspecialidades;
	}

	public void setListaEspecialidades(List<Especialidad> listaEspecialidades) {
		this.listaEspecialidades = listaEspecialidades;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
