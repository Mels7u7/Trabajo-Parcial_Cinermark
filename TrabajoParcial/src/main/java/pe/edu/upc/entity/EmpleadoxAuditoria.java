package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleadoxauditoria")
public class EmpleadoxAuditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleadoxAuditoria;

	@ManyToOne
	@JoinColumn(name = "idEmpleado")
	private Empleado empleadoEmpleadoxAuditoria;

	@ManyToOne
	@JoinColumn(name = "idAuditoria")
	private Auditoria auditoriaEmpleadoxAuditoria;

	public EmpleadoxAuditoria() {
		super();
	}

	public EmpleadoxAuditoria(int idEmpleadoxAuditoria, Empleado empleadoEmpleadoxAuditoria,
			Auditoria auditoriaEmpleadoxAuditoria) {
		super();
		this.idEmpleadoxAuditoria = idEmpleadoxAuditoria;
		this.empleadoEmpleadoxAuditoria = empleadoEmpleadoxAuditoria;
		this.auditoriaEmpleadoxAuditoria = auditoriaEmpleadoxAuditoria;
	}

	public int getIdEmpleadoxAuditoria() {
		return idEmpleadoxAuditoria;
	}

	public void setIdEmpleadoxAuditoria(int idEmpleadoxAuditoria) {
		this.idEmpleadoxAuditoria = idEmpleadoxAuditoria;
	}

	public Empleado getEmpleadoEmpleadoxAuditoria() {
		return empleadoEmpleadoxAuditoria;
	}

	public void setEmpleadoEmpleadoxAuditoria(Empleado empleadoEmpleadoxAuditoria) {
		this.empleadoEmpleadoxAuditoria = empleadoEmpleadoxAuditoria;
	}

	public Auditoria getAuditoriaEmpleadoxAuditoria() {
		return auditoriaEmpleadoxAuditoria;
	}

	public void setAuditoriaEmpleadoxAuditoria(Auditoria auditoriaEmpleadoxAuditoria) {
		this.auditoriaEmpleadoxAuditoria = auditoriaEmpleadoxAuditoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpleadoxAuditoria;
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
		EmpleadoxAuditoria other = (EmpleadoxAuditoria) obj;
		if (idEmpleadoxAuditoria != other.idEmpleadoxAuditoria)
			return false;
		return true;
	}
}
