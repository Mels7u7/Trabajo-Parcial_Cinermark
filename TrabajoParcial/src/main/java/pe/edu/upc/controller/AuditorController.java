package pe.edu.upc.controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Auditor;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.entity.FirmaConsultora;
import pe.edu.upc.service.IAuditorService;
import pe.edu.upc.service.IEspecialidadService;
import pe.edu.upc.service.IFirmaConsultoraService;

@Named
@RequestScoped
public class AuditorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IAuditorService aService;
	@Inject
	private IEspecialidadService eService;
	@Inject
	private IFirmaConsultoraService fService;

	private Auditor auditor;
	private Especialidad especialidad;
	private FirmaConsultora firma;

	List<Auditor> listaAuditores;
	List<Especialidad> listaEspecialidad;
	List<FirmaConsultora> listaFirmas;

	@PostConstruct
	public void init() {
		auditor = new Auditor();
		especialidad = new Especialidad();
		firma = new FirmaConsultora();

		listaAuditores = new ArrayList<Auditor>();
		listaEspecialidad = new ArrayList<Especialidad>();
		listaFirmas = new ArrayList<FirmaConsultora>();

		this.listAuditor();
		this.listEspecialidad();
		this.listFirma();
	}

	public String nuevoAuditor() {
		this.setAuditor(new Auditor());
		return "auditor.xhtml";
	}

	public void insertar() {
		try {
			aService.insertar(auditor);
			limpiarAuditor();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listAuditor() {
		try {
			listaAuditores = aService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listEspecialidad() {
		try {
			listaEspecialidad = eService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listFirma() {
		try {
			listaFirmas = fService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarAuditor() {
		this.init();
	}

	public void eliminar(Auditor auditor) {
		try {
			aService.eliminar(auditor.getIdAuditor());
			listAuditor();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// get y set

	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public FirmaConsultora getFirma() {
		return firma;
	}

	public void setFirma(FirmaConsultora firma) {
		this.firma = firma;
	}

	public List<Auditor> getListaAuditores() {
		return listaAuditores;
	}

	public void setListaAuditores(List<Auditor> listaAuditores) {
		this.listaAuditores = listaAuditores;
	}

	public List<Especialidad> getListaEspecialidad() {
		return listaEspecialidad;
	}

	public void setListaEspecialidad(List<Especialidad> listaEspecialidad) {
		this.listaEspecialidad = listaEspecialidad;
	}

	public List<FirmaConsultora> getListaFirmas() {
		return listaFirmas;
	}

	public void setListaFirmas(List<FirmaConsultora> listaFirmas) {
		this.listaFirmas = listaFirmas;
	}
}
