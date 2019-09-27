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
	private IAuditorService aService;
	@Inject
	private ISalaService sService;

	private Auditoria auditoria;
	private Auditor auditor;
	private Sala sala;

	List<Auditoria> listaAuditorias;
	List<Auditor> listaAuditores;
	List<Sala> listaSalas;

	@PostConstruct
	public void init() {
		auditoria = new Auditoria();
		auditor = new Auditor();
		sala = new Sala();

		listaAuditorias = new ArrayList<Auditoria>();
		listaAuditores = new ArrayList<Auditor>();
		listaSalas = new ArrayList<Sala>();

		this.listAuditoria();
		this.listAuditor();
		this.listSala();
	}

	public String nuevaAuditoria() {
		this.setAuditoria(new Auditoria());
		return "auditoria.xhtml";
	}

	public String detalleEmpleado(Auditoria aud) {
		this.setAuditoria(aud);
		
		return "detalleAuditoria.xhtml";
	}
	
	public void insertar() {
		try {
			auService.insertar(auditoria);
			limpiarAuditoria();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listAuditoria() {
		try {
			listaAuditorias = auService.listar();
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

	public void listSala() {
		try {
			listaSalas = sService.listar();
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
		}
	}
	
	public void modificar() {
		try {
			auService.modificar(this.auditoria);
			limpiarAuditoria();
			this.listSala();
			this.listAuditor();
			this.listAuditoria();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	public String ModifAuditoria(Auditoria _auditoria) {
		this.setAuditoria(_auditoria);
		return "modifAuditoria.xhtml";
		
	}
	
	public String detallesAuditoria(Auditoria _auditoria) {
		this.setAuditoria(_auditoria);
		return "detalleAuditoria.xhtml";
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

	public List<Auditoria> getListaAuditorias() {
		return listaAuditorias;
	}

	public void setListaAuditorias(List<Auditoria> listaAuditorias) {
		this.listaAuditorias = listaAuditorias;
	}

	public List<Auditor> getListaAuditores() {
		return listaAuditores;
	}

	public void setListaAuditores(List<Auditor> listaAuditores) {
		this.listaAuditores = listaAuditores;
	}

	public List<Sala> getListaSalas() {
		return listaSalas;
	}

	public void setListaSalas(List<Sala> listaSalas) {
		this.listaSalas = listaSalas;
	}
}
