package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAuditoria;

	@NotEmpty(message = "Ingresar el tema principal de la auditoria")
	@Column(name = "temaPrincipalAuditoria", nullable = false, length = 40)
	private String temaPrincipalAuditoria;

	@NotEmpty(message = "Ingresar una descripcion detallada de la auditoria")
	@Column(name = "descripcionAuditoria", nullable = false, length = 100)
	private String descripcionAuditoria;

	private String fechaAuditoria;

	@Min(1)
	@Max(100)
	@Column(name = "participantesAuditoria", nullable = false)
	private int participantesAuditoria;

	@NotEmpty(message = "Ingresar un estado de la auditoria")
	@Column(name = "estadoAuditoria", nullable = false, length = 100)
	private String estadoAuditoria;

	@ManyToOne
	@JoinColumn(name = "idAuditor")
	private Auditor auditorAuditoria;

	@ManyToOne
	@JoinColumn(name = "idSala")
	private Sala salaAuditoria;

	public Auditoria() {
		super();
	}

	public Auditoria(int idAuditoria, String temaPrincipalAuditoria, String descripcionAuditoria, String fechaAuditoria,
			int participantesAuditoria, String estadoAuditoria, Auditor auditorAuditoria, Sala salaAuditoria) {
		super();
		this.idAuditoria = idAuditoria;
		this.temaPrincipalAuditoria = temaPrincipalAuditoria;
		this.descripcionAuditoria = descripcionAuditoria;
		this.fechaAuditoria = fechaAuditoria;
		this.participantesAuditoria = participantesAuditoria;
		this.estadoAuditoria = estadoAuditoria;
		this.auditorAuditoria = auditorAuditoria;
		this.salaAuditoria = salaAuditoria;
	}

	public int getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getTemaPrincipalAuditoria() {
		return temaPrincipalAuditoria;
	}

	public void setTemaPrincipalAuditoria(String temaPrincipalAuditoria) {
		this.temaPrincipalAuditoria = temaPrincipalAuditoria;
	}

	public String getDescripcionAuditoria() {
		return descripcionAuditoria;
	}

	public void setDescripcionAuditoria(String descripcionAuditoria) {
		this.descripcionAuditoria = descripcionAuditoria;
	}

	public String getFechaAuditoria() {
		return fechaAuditoria;
	}

	public void setFechaAuditoria(String fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public int getParticipantesAuditoria() {
		return participantesAuditoria;
	}

	public void setParticipantesAuditoria(int participantesAuditoria) {
		this.participantesAuditoria = participantesAuditoria;
	}

	public String getEstadoAuditoria() {
		return estadoAuditoria;
	}

	public void setEstadoAuditoria(String estadoAuditoria) {
		this.estadoAuditoria = estadoAuditoria;
	}

	public Auditor getAuditorAuditoria() {
		return auditorAuditoria;
	}

	public void setAuditorAuditoria(Auditor auditorAuditoria) {
		this.auditorAuditoria = auditorAuditoria;
	}

	public Sala getSalaAuditoria() {
		return salaAuditoria;
	}

	public void setSalaAuditoria(Sala salaAuditoria) {
		this.salaAuditoria = salaAuditoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAuditoria;
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
		Auditoria other = (Auditoria) obj;
		if (idAuditoria != other.idAuditoria)
			return false;
		return true;
	}
}
