package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Auditor;
import pe.edu.upc.entity.Auditoria;
import pe.edu.upc.entity.Sala;
import pe.edu.upc.service.IAuditorService;
import pe.edu.upc.service.IAuditoriaService;
import pe.edu.upc.service.ISalaService;

@Named
@RequestScoped
public class AuditoriaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IAuditoriaService auService;
	@Inject
	private IAuditorService aS;
	@Inject
	private ISalaService sS;

	private Auditoria auditoria;
	private Auditor auditor;
	private Sala sala;
	private String mensaje = "";

	List<Auditoria> listarAuditorias;
	List<Auditor> listarAuditores;
	List<Sala> listarSalas;

	@PostConstruct
	public void init() {
		listarAuditorias = new ArrayList<Auditoria>();
		listarAuditores = new ArrayList<Auditor>();
		listarSalas = new ArrayList<Sala>();
		
		auditoria = new Auditoria();
		auditor = new Auditor();
		sala = new Sala();

		this.listAuditoria();
		this.listAuditor();
		this.listSala();

	}

	public String nuevoAuditoria() {
		this.setAuditoria(new Auditoria());
		return "auditoria.xhtml";
	}

	public String ModifAuditoria(Auditoria _auditoria) {
		this.setAuditoria(_auditoria);
		return "modifauditoria.xhtml";		
	}
	
	public void insertar() {
		try {
			auService.insertar(auditoria);
			limpiarAuditoria();
			mensaje = "Se registró correctamente";
		} catch (Exception e) {
			e.getMessage();
			
		}
	}

	public void listAuditoria() {
		try {
			listarAuditorias = auService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listAuditor() {
		try {
			listarAuditores = aS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listSala() {
		try {
			listarSalas = sS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarAuditoria() {
		this.init();
	}

	public void eliminar(Auditoria auditoria) {
		try {
			auService.eliminar(auditoria.getIdAuditoria());
			listAuditoria();
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede eliminar";
		}
	}

	public void modificar() {
		try {
			auService.modificar(this.auditoria);
			limpiarAuditoria();
			this.listAuditoria();
			this.listAuditor();
			this.listSala();
			
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede modificar";
		}
	}
	
	// get y set
	
	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Auditoria> getListarAuditorias() {
		return listarAuditorias;
	}

	public void setListarAuditorias(List<Auditoria> listarAuditorias) {
		this.listarAuditorias = listarAuditorias;
	}

	public List<Auditor> getListarAuditores() {
		return listarAuditores;
	}

	public void setListarAuditores(List<Auditor> listarAuditores) {
		this.listarAuditores = listarAuditores;
	}

	public List<Sala> getListarSalas() {
		return listarSalas;
	}

	public void setListarSalas(List<Sala> listarSalas) {
		this.listarSalas = listarSalas;
	}
	
}
