package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Sala;
import pe.edu.upc.service.ISalaService;


@Named
@RequestScoped
public class SalaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ISalaService sService;
	private Sala sala;
	List<Sala>listarSalas;
	
	@PostConstruct
	public void init()
	{
		this.listarSalas=new ArrayList<Sala>();
		this.sala =new Sala();
		this.listar();	
	}
	public String nuevoSala()
	{
		this.setSala(new Sala());
		return "sala.xhtml";
	}
	
	public void insertar()
	{
		try {
			listarSalas = sService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listar()
	{
		try {
			listarSalas =sService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void eliminar(Sala sala)
	{
		try {
			sService.eliminar(sala.getIdSala());
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void limpiarSala()
	{
		this.init();
	}
	public ISalaService getsService() {
		return sService;
	}
	public void setsService(ISalaService sService) {
		this.sService = sService;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public List<Sala> getListarSalas() {
		return listarSalas;
	}
	public void setListarSalas(List<Sala> listarSalas) {
		this.listarSalas = listarSalas;
	}

	
	
	

}