package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.EmpleadoxAuditoria;
import pe.edu.upc.service.IEmpleadoxAuditoriaService;

@Named
@RequestScoped
public class EmpleadoxAuditoriaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEmpleadoxAuditoriaService eService;
	private EmpleadoxAuditoria empleadoxAuditoria;
	
	List<EmpleadoxAuditoria> listaEmpleadosxAuditoria;
	
	private String mensaje ="";
	
	@PostConstruct
	
	public void init() {
		listaEmpleadosxAuditoria = new ArrayList<EmpleadoxAuditoria>();
		empleadoxAuditoria = new EmpleadoxAuditoria();
		this.listar();
	}
	
	public String nuevoEmpleadoxAuditoria() {
		this.setEmpleadoxAuditoria(new EmpleadoxAuditoria());
		return "empleadoxAuditoria.xhtml";
	}
	
	public String Modifempleado(EmpleadoxAuditoria _emp) {
		this.setEmpleadoxAuditoria(_emp);
		return "modifEmpleadoxAuditoria.xhtml";
		
	}
	
	public void insertar() {
		try {
			eService.insertar(empleadoxAuditoria);
			limpiarEmpleadoxAuditoria();
			} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listar() {
		try {
			listaEmpleadosxAuditoria = eService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void eliminar(EmpleadoxAuditoria empleadoxAuditoria) {
		try {
			eService.eliminar(empleadoxAuditoria.getIdEmpleadoxAuditoria());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void modificar() {
		try {
			eService.modificar(this.empleadoxAuditoria);
			limpiarEmpleadoxAuditoria();
			this.listar();
			
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede modificar";
		}
	}
	
	public void limpiarEmpleadoxAuditoria() {
		this.init();
	}

	public EmpleadoxAuditoria getEmpleadoxAuditoria() {
		return empleadoxAuditoria;
	}

	public void setEmpleadoxAuditoria(EmpleadoxAuditoria empleadoxAuditoria) {
		this.empleadoxAuditoria = empleadoxAuditoria;
	}

	public List<EmpleadoxAuditoria> getListaEmpleadosxAuditoria() {
		return listaEmpleadosxAuditoria;
	}

	public void setListaEmpleadosxAuditoria(List<EmpleadoxAuditoria> listaEmpleadosxAuditoria) {
		this.listaEmpleadosxAuditoria = listaEmpleadosxAuditoria;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
	
	

	
	
	
}
