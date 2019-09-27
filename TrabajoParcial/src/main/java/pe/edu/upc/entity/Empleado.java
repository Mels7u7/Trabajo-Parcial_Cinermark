package pe.edu.upc.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;

	@NotEmpty(message = "Ingrese los nombres del empleado")
	@Column(name = "nombreEmpleado", nullable = false, length = 50)
	private String nombreEmpleado;
	

	@NotEmpty(message = "Ingrese los apellidos del empleado")
	@Column(name = "apellidoEmpleado", nullable = false, length = 50)
	private String apellidoEmpleado;
    
	@Size(min = 8, max = 8)
	@NotEmpty(message = "Ingrese el DNI del empleado")
	@Column(name = "dniEmpleado", nullable = false, length = 8)
	private String dniEmpleado;

	@NotEmpty(message = "Ingrese el puesto laboral del empleado")
	@Column(name = "puestolaboralEmpleado", nullable = false, length = 30)
	private String puestolaboralEmpleado;
	
	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingrese el numero de celular del empleado")
	@Column(name = "celularEmpleado", nullable = false, length = 9)
	private String celularEmpleado;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int idEmpleado, @NotEmpty(message = "Ingrese los nombres del empleado") String nombreEmpleado,
			@NotEmpty(message = "Ingrese los apellidos del empleado") String apellidoEmpleado,
			@NotEmpty(message = "Ingrese el DNI del empleado") String dniEmpleado,
			@NotEmpty(message = "Ingrese el puesto laboral del empleado") String puestolaboralEmpleado,
			@NotEmpty(message = "Ingrese el numero de celular del empleado") String celularEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.dniEmpleado = dniEmpleado;
		this.puestolaboralEmpleado = puestolaboralEmpleado;
		this.celularEmpleado = celularEmpleado;
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

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getPuestolaboralEmpleado() {
		return puestolaboralEmpleado;
	}

	public void setPuestolaboralEmpleado(String puestolaboralEmpleado) {
		this.puestolaboralEmpleado = puestolaboralEmpleado;
	}

	public String getCelularEmpleado() {
		return celularEmpleado;
	}

	public void setCelularEmpleado(String celularEmpleado) {
		this.celularEmpleado = celularEmpleado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpleado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (idEmpleado != other.idEmpleado)
			return false;
		return true;
	}
}
