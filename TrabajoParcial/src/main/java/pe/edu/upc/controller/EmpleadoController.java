package pe.edu.upc.controller;

import java.io.Serializable;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Empleado;
import pe.edu.upc.service.IEmpleadoService;

@Named
@RequestScoped

public class EmpleadoController implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Inject
	private IEmpleadoService eService;
	private Empleado empleado; 
	
	List<Empleado> listaEmpleados; 
	
	private String mensaje ="";
	
	@PostConstruct
	public void init() {
		listaEmpleados = new ArrayList<Empleado>();
		empleado = new Empleado();
		this.listar();
	}
	
	
	public String nuevoEmpleado() {
		this.setEmpleado(new Empleado());
		return "empleado.xhtml";
	}
	
	public String Modifempleado(Empleado _emp) {
		this.setEmpleado(_emp);
		return "modifEmpleado.xhtml";
		
	}
	
	public String detalleEmpleado(Empleado _emp) {
		this.setEmpleado(_emp);
		
		return "detalleEmpleado.xhtml";
	}
	
	
	public void insertar() {
		try {
			eService.insertar(empleado);
			limpiarEmpleado();
			} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listar() {
		try {
			listaEmpleados = eService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void eliminar(Empleado empleado) {
		try {
			eService.eliminar(empleado.getIdEmpleado());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void modificar() {
		try {
			eService.modificar(this.empleado);
			limpiarEmpleado();
			this.listar();
			
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se puede modificar";
		}
	}
	
	public void limpiarEmpleado() {
		this.init();
	}


	public IEmpleadoService geteService() {
		return eService;
	}


	public void seteService(IEmpleadoService eService) {
		this.eService = eService;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}


	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
	
	
	
	

}

