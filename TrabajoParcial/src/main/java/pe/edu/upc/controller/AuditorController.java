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

@Named
@RequestScoped
public class AuditorController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IAuditorService aService;
	private Auditor auditor;
	private Especialidad especialidad;
	private FirmaConsultora firma;
	List<Auditor>listaAuditores;
	List<Especialidad>listaEspecialidades;
	List<FirmaConsultora>listaFirmas;
	
	@PostConstruct
	public void init() {
		this.listaAuditores = new ArrayList<Auditor>();
		this.auditor = new Auditor();
		this.listar();
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
	public void listar() {
		try {
			listaAuditores = aService.listar();
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
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public IAuditorService getaService() {
		return aService;
	}
	public void setaService(IAuditorService aService) {
		this.aService = aService;
	}
	public Auditor getAuditor() {
		return auditor;
	}
	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}
	public List<Auditor> getListaAuditores() {
		return listaAuditores;
	}
	public void setListaAuditores(List<Auditor> listaAuditores) {
		this.listaAuditores = listaAuditores;
	}
	
}
