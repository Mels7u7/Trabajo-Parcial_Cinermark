package pe.edu.upc.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.service.IEspecialidadService;

@Named
@RequestScoped
public class EspecialidadController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IEspecialidadService esService;
	private Especialidad especialidad;
	
	@PostConstruct
	public void init() {
		this.especialidad = new Especialidad();
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
	public void limpiarEspecialidad() {
		this.init();
	}
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
	
}
