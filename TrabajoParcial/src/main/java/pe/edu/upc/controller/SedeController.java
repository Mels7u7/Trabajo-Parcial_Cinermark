package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Sede;
import pe.edu.upc.service.ISedeService;

@Named
@RequestScoped
public class SedeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ISedeService sService;
	private Sede sede;
	List<Sede>listaSedes;
	
	@PostConstruct
	public void init() {
		this.listaSedes = new ArrayList<Sede>();
		this.sede = new Sede();
		this.listar();
	}
	
	public String nuevoSede() {
		this.setSede(new Sede());
		return "sede.xhtml";
	}
	
	public void insertar() {
		try {
			sService.insertar(sede);
			limpiarSede();
			} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listar() {
		try {
			listaSedes = sService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void eliminar(Sede sede) {
		try {
			sService.eliminar(sede.getIdSede());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarSede() {
		this.init();
	}

	public ISedeService getsService() {
		return sService;
	}

	public void setsService(ISedeService sService) {
		this.sService = sService;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public List<Sede> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(List<Sede> listaSedes) {
		this.listaSedes = listaSedes;
	}
	
}
