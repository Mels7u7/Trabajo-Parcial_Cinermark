package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Auditoria;
import pe.edu.upc.entity.DetalleDeAuditoria;
import pe.edu.upc.entity.Herramienta;
import pe.edu.upc.service.IAuditoriaService;
import pe.edu.upc.service.IDetalleAuditoriaService;
import pe.edu.upc.service.IHerramientaService;

@Named
@RequestScoped
public class DetalleAuditoriaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleAuditoriaService daS;

	@Inject
	private IHerramientaService hS;

	@Inject
	private IAuditoriaService aS;

	private DetalleDeAuditoria dda;
	private Herramienta her;
	private Auditoria aud;

	List<DetalleDeAuditoria> listaDDA;
	List<Herramienta> listaHerramienta;
	List<Auditoria> listaAuditorias;

	private String mensaje = "";

	@PostConstruct
	public void init() {
		listaDDA = new ArrayList<DetalleDeAuditoria>();
		listaHerramienta = new ArrayList<Herramienta>();
		listaAuditorias = new ArrayList<Auditoria>();

		dda = new DetalleDeAuditoria();
		her = new Herramienta();
		aud = new Auditoria();

		this.listDDA();
		this.listAuditoria();
		this.listHerramienta();

	}

	public String nuevoDDA() {
		this.setDetalleAuditoria(new DetalleDeAuditoria());
		return "DetallexAuditoria.xhtml";
	}

	public String ModifDDA(DetalleDeAuditoria det) {
		this.setDetalleAuditoria(det);
		return "modifDDA.xhtml";
	}

	public void insertar() {
		try {
			daS.insertar(dda);
			limpiarDDA();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listDDA() {
		try {
			listaDDA = daS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listAuditoria() {
		try {
			listaAuditorias = aS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listHerramienta() {
		try {
			listaHerramienta = hS.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(DetalleDeAuditoria dda) {
		try {
			daS.eliminar(dda.getIdDetalledeAuditoria());
			listDDA();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarDDA() {
		this.init();
	}

	public DetalleDeAuditoria getDDA() {
		return dda;
	}

	public void setDetalleAuditoria(DetalleDeAuditoria dda) {
		this.dda = dda;
	}

	public List<DetalleDeAuditoria> getListDDA() {
		return listaDDA;
	}

	public void setListaDDA(List<DetalleDeAuditoria> listaDDA) {
		this.listaDDA = listaDDA;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Herramienta getHerramienta() {
		return her;
	}

	public void setEmpleado(Herramienta herra) {
		this.her = herra;
	}

	public Auditoria getAuditoria() {
		return aud;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.aud = auditoria;
	}

	public List<Herramienta> getListaHerramienta() {
		return listaHerramienta;
	}

	public void setListaHerramienta(List<Herramienta> listaHer) {
		this.listaHerramienta = listaHer;
	}

	public List<Auditoria> getListaAuditorias() {
		return listaAuditorias;
	}

	public void setListaAuditorias(List<Auditoria> listaAuditorias) {
		this.listaAuditorias = listaAuditorias;
	}
}
