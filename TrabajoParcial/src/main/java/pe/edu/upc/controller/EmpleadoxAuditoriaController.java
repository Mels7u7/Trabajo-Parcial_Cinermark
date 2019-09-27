package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Auditoria;
import pe.edu.upc.entity.Empleado;
import pe.edu.upc.entity.EmpleadoxAuditoria;
import pe.edu.upc.service.IAuditoriaService;
import pe.edu.upc.service.IEmpleadoService;
import pe.edu.upc.service.IEmpleadoxAuditoriaService;

@Named
@RequestScoped
public class EmpleadoxAuditoriaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IEmpleadoxAuditoriaService eService;

	@Inject
	private IEmpleadoService emService;

	@Inject
	private IAuditoriaService aService;

	private EmpleadoxAuditoria empleadoxAuditoria;
	private Empleado empleado;
	private Auditoria auditoria;

	List<EmpleadoxAuditoria> listaEmpleadosxAuditoria;
	List<Empleado> listaEmpleados;
	List<Auditoria> listaAuditorias;

	private String mensaje = "";

	@PostConstruct
	public void init() {
		listaEmpleadosxAuditoria = new ArrayList<EmpleadoxAuditoria>();
		listaEmpleados = new ArrayList<Empleado>();
		listaAuditorias = new ArrayList<Auditoria>();

		empleadoxAuditoria = new EmpleadoxAuditoria();
		empleado = new Empleado();
		auditoria = new Auditoria();

		this.listEmpleadoxAuditoria();
		this.listAuditoria();
		this.listEmpleado();

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

	public void listEmpleadoxAuditoria() {
		try {
			listaEmpleadosxAuditoria = eService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listAuditoria() {
		try {
			listaAuditorias = aService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listEmpleado() {
		try {
			listaEmpleados = emService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(EmpleadoxAuditoria empleadoxAuditoria) {
		try {
			eService.eliminar(empleadoxAuditoria.getIdEmpleadoxAuditoria());
			listEmpleadoxAuditoria();
		} catch (Exception e) {
			e.getMessage();
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public List<Auditoria> getListaAuditorias() {
		return listaAuditorias;
	}

	public void setListaAuditorias(List<Auditoria> listaAuditorias) {
		this.listaAuditorias = listaAuditorias;
	}

}
