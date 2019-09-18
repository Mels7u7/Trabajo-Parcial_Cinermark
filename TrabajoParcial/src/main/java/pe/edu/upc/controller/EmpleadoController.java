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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IEmpleadoService aService;
	private Empleado empleado;
	List<Empleado> listaEmpleados;

	@PostConstruct
	public void init() {
		this.listaEmpleados = new ArrayList<Empleado>();
		this.empleado = new Empleado();
		this.listar();
	}
	

	public String nuevoEmpleado() {
		this.setEmpleado(new Empleado());
		return "empleado.xhtml";
	}

	public void insertar() {
		try {
			aService.insertar(empleado);
			limpiarEmpleado();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listar() {
		try {
			listaEmpleados = aService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(Empleado empleado) {
		try {
			aService.eliminar(empleado.getIdEmpleado());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarEmpleado() {
		this.init();
	}

	public IEmpleadoService geteService() {
		return aService;
	}

	public void seteService(IEmpleadoService eService) {
		this.aService = eService;
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

}
