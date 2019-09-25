package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Auditoria;
import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.entity.FirmaConsultora;
import pe.edu.upc.service.IFirmaConsultoraService;

@Named
@RequestScoped
public class FirmaConsultoraController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IFirmaConsultoraService fService;
	private FirmaConsultora firma;
	List<FirmaConsultora> listaFirmas;

	private String mensaje = "";

	@PostConstruct
	public void init() {

		this.listaFirmas = new ArrayList<FirmaConsultora>();
		this.firma = new FirmaConsultora();
		this.listar();
	}

	public String nuevoFirma() {

		this.setFirma(new FirmaConsultora());
		return "firmaConsultora.xhtml";
	}

	public void insertar() {
		try {
			fService.insertar(firma);
			limpiarFirma();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public String detallesFirmaConsultora(FirmaConsultora firma) {
		this.setFirma(firma);;
		return "detallefirmaconsultora.xhtml";
	}

	public void listar() {
		try {
			listaFirmas = fService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(FirmaConsultora firma) {
		try {
			fService.eliminar(firma.getIdFirma());
			listar();
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede eliminar";
		}
	}

	public String ModificarFirma(FirmaConsultora firma) {
		this.setFirma(firma);
		return "modificarfirma.xhtml";
	}

	public void modificar() {
		try {
			fService.modificar(this.firma);
			limpiarFirma();
			this.listar();

		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede modificar";
		}
	}

	public void limpiarFirma() {
		this.init();
	}

	public IFirmaConsultoraService getfService() {
		return fService;
	}

	public void setfService(IFirmaConsultoraService fService) {
		this.fService = fService;
	}

	public FirmaConsultora getFirma() {
		return firma;
	}

	public void setFirma(FirmaConsultora firma) {
		this.firma = firma;
	}

	public List<FirmaConsultora> getListaFirmas() {
		return listaFirmas;
	}

	public void setListaFirmas(List<FirmaConsultora> listaFirmas) {
		this.listaFirmas = listaFirmas;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
