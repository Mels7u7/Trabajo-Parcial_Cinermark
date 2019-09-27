package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Sala;
import pe.edu.upc.entity.Sede;
import pe.edu.upc.service.ISalaService;
import pe.edu.upc.service.ISedeService;

@Named
@RequestScoped
public class SalaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ISalaService sService;

	@Inject
	private ISedeService seService;

	private Sala sala;
	private Sede sede;
	private String mensaje = "";

	List<Sala> listarSalas;
	List<Sede> listarSedes;

	@PostConstruct
	public void init() {
		listarSalas = new ArrayList<Sala>();
		listarSedes = new ArrayList<Sede>();

		sala = new Sala();
		sede = new Sede();

		this.listSala();
		this.listSede();
	}

	public String nuevoSala() {
		this.setSala(new Sala());
		return "sala.xhtml";
	}
	
	
	public String Modifsala(Sala _sala) {
		this.setSala(_sala);
		return "modifsala.xhtml";
		
	}
	public String detalleSala(Sala _sala) {
		this.setSala(_sala);
		
		return "detalleSala.xhtml";
	}

	public void insertar() {
		try {
			sService.insertar(sala);
			limpiarSala();
			mensaje = "Se registró correctamente";
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listSala() {
		try {
			listarSalas = sService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listSede() {
		try {
			listarSedes = seService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(Sala sala) {
		try {
			sService.eliminar(sala.getIdSala());
			listSala();
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede eliminar";
		}
	}
	
	public void modificar() {
		try {
			sService.modificar(this.sala);
			limpiarSala();
			this.listSala();
			this.listSede();
			
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede modificar";
		}
	}

	public void limpiarSala() {
		this.init();
	}

	// get y set

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public List<Sala> getListarSalas() {
		return listarSalas;
	}

	public void setListarSalas(List<Sala> listarSalas) {
		this.listarSalas = listarSalas;
	}

	public List<Sede> getListarSedes() {
		return listarSedes;
	}

	public void setListarSedes(List<Sede> listarSedes) {
		this.listarSedes = listarSedes;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}