package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idEmpleado;
	
	@Column(name="nombreEmpleado",nullable = false,length=20)
	private String nombreEmpleado;
	
	@Column(name="apellidoEmpleado",nullable = false,length=20)
	private String apellidoEmpleado;
	
	
	private int dniEmpleado;
	
	@Column(name="puestolaboralEmpleado",nullable = false, length=20)
	private String puestolaboralEmpleado;
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, int dniEmpleado,
			String puestolaboralEmpleado) {
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.dniEmpleado = dniEmpleado;
		this.puestolaboralEmpleado = puestolaboralEmpleado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public int getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(int dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getPuestolaboralEmpleado() {
		return puestolaboralEmpleado;
	}

	public void setPuestolaboralEmpleado(String puestolaboralEmpleado) {
		this.puestolaboralEmpleado = puestolaboralEmpleado;
	}
	
}
