package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

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

	@NotEmpty(message = "Ingresa el tema principal")
	@Column(name = "temaPrincipal", nullable = false, length = 100)
	private String temaPrincipal;

	@NotEmpty(message = "Escriba una descripcion")
	@Column(name = "descripcionAuditoria", nullable = false, length = 500)
	private String descripcionAuditoria;

	@NotNull(message = "La fecha es obligatoria")
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaAuditoria")
	private Date fechaAuditoria;

	@Min(1)
	@Max(100)
	@Column(name = "trabajadoresAuditados", nullable = false)
	private int trabajadoresAuditados;

	@ManyToOne
	@JoinColumn(name = "idAuditor")
	private Auditor auditorAuditoria;

	@MapsId
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSala")
	private Sala salaAuditoria;

	@NotEmpty(message = "Escriba el estado")
	@Column(name = "estadoAuditoria", nullable = false, length = 20)
	private String estadoAuditoria;

	public Auditoria() {
		super();
	}

	public Auditoria(int idAuditoria, String temaPrincipal, String descripcionAuditoria, Date fechaAuditoria,
			int trabajadoresAuditados, Auditor auditorAuditoria, Sala salaAuditoria, String estadoAuditoria) {
		super();
		this.idAuditoria = idAuditoria;
		this.temaPrincipal = temaPrincipal;
		this.descripcionAuditoria = descripcionAuditoria;
		this.fechaAuditoria = fechaAuditoria;
		this.trabajadoresAuditados = trabajadoresAuditados;
		this.auditorAuditoria = auditorAuditoria;
		this.salaAuditoria = salaAuditoria;
		this.estadoAuditoria = estadoAuditoria;
	}

	public int getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getTemaPrincipal() {
		return temaPrincipal;
	}

	public void setTemaPrincipal(String temaPrincipal) {
		this.temaPrincipal = temaPrincipal;
	}

	public String getDescripcionAuditoria() {
		return descripcionAuditoria;
	}

	public void setDescripcionAuditoria(String descripcionAuditoria) {
		this.descripcionAuditoria = descripcionAuditoria;
	}

	public Date getFechaAuditoria() {
		return fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public int getTrabajadoresAuditados() {
		return trabajadoresAuditados;
	}

	public void setTrabajadoresAuditados(int trabajadoresAuditados) {
		this.trabajadoresAuditados = trabajadoresAuditados;
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

	public String getEstadoAuditoria() {
		return estadoAuditoria;
	}

	public void setEstadoAuditoria(String estadoAuditoria) {
		this.estadoAuditoria = estadoAuditoria;
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
