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
@Table(name = "detalle")
public class DetalleAuditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;

	@ManyToOne
	@JoinColumn(name = "idHerramienta")
	private Herramienta herramientaDetalle;

	@ManyToOne
	@JoinColumn(name = "idAuditoria")
	private Auditoria auditoriaHerramienta;

	public DetalleAuditoria() {
		super();

	}

	public DetalleAuditoria(int idDetalle, Herramienta herramientaDetalle, Auditoria auditoriaHerramienta) {
		super();
		this.idDetalle = idDetalle;
		this.herramientaDetalle = herramientaDetalle;
		this.auditoriaHerramienta = auditoriaHerramienta;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Herramienta getHerramientaDetalle() {
		return herramientaDetalle;
	}

	public void setHerramientaDetalle(Herramienta herramientaDetalle) {
		this.herramientaDetalle = herramientaDetalle;
	}

	public Auditoria getAuditoriaHerramienta() {
		return auditoriaHerramienta;
	}

	public void setAuditoriaHerramienta(Auditoria auditoriaHerramienta) {
		this.auditoriaHerramienta = auditoriaHerramienta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDetalle;
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
		DetalleAuditoria other = (DetalleAuditoria) obj;
		if (idDetalle != other.idDetalle)
			return false;
		return true;
	}
}
