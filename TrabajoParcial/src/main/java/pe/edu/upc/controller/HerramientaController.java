package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Herramienta;
import pe.edu.upc.service.IHerramientaService;

@Named
@RequestScoped
public class HerramientaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IHerramientaService hService;
	private Herramienta herramienta;
	List<Herramienta>listaHerramientas;
	
	@PostConstruct
	public void init() {
		this.listaHerramientas = new ArrayList<Herramienta>();
		this.herramienta = new Herramienta();
		this.listar();
	}
	public String nuevoHerramienta() {
		this.setHerramienta(new Herramienta());
		return "herramienta.xhtml";
	}
	public void insertar() {
		try {
			hService.insertar(herramienta);
			limpiarHerramienta();
			} catch (Exception e) {
			e.getMessage();
		}
	}
	public void listar() {
		try {
			listaHerramientas = hService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void eliminar(Herramienta herramienta) {
		try {
			hService.eliminar(herramienta.getIdHerramienta());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void limpiarHerramienta() {
		this.init();
	}
	public IHerramientaService gethService() {
		return hService;
	}
	public void sethService(IHerramientaService hService) {
		this.hService = hService;
	}
	public Herramienta getHerramienta() {
		return herramienta;
	}
	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}
	public List<Herramienta> getListaHerramientas() {
		return listaHerramientas;
	}
	public void setListaHerramientas(List<Herramienta> listaHerramientas) {
		this.listaHerramientas = listaHerramientas;
	}
	
}
