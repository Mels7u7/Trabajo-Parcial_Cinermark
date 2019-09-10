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
@Table(name = "auditor")
public class Auditor implements Serializable {

	/**
	 * 
	 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAuditor;

	@NotEmpty(message = "Ingresa el nombre del Auditor")
	@Column(name = "nombreAuditor", nullable = false, length = 20)
	private String nombreAuditor;

	@NotEmpty(message = "Ingresa el tema principal")
	@Column(name = "numeroAuditor", nullable = false, length = 9)
	private String numeroAuditor;

	@Min(1)
	@Max(20)
	@Column(name = "tiempoExpAuditor", nullable = false)
	private int tiempoExpAuditor;

	@ManyToOne
	@JoinColumn(name = "idEspecialidad")
	private Especialidad especialidadAuditor;

	@ManyToOne
	@JoinColumn(name = "idFirma")
	private FirmaConsultora firmaAuditor;

	public Auditor() {
		super();
	}

	public Auditor(int idAuditor, String nombreAuditor, String numeroAuditor, int tiempoExpAuditor,
			Especialidad especialidadAuditor, FirmaConsultora firmaAuditor) {
		super();
		this.idAuditor = idAuditor;
		this.nombreAuditor = nombreAuditor;
		this.numeroAuditor = numeroAuditor;
		this.tiempoExpAuditor = tiempoExpAuditor;
		this.especialidadAuditor = especialidadAuditor;
		this.firmaAuditor = firmaAuditor;
	}

	public int getIdAuditor() {
		return idAuditor;
	}

	public void setIdAuditor(int idAuditor) {
		this.idAuditor = idAuditor;
	}

	public String getNombreAuditor() {
		return nombreAuditor;
	}

	public void setNombreAuditor(String nombreAuditor) {
		this.nombreAuditor = nombreAuditor;
	}

	public String getNumeroAuditor() {
		return numeroAuditor;
	}

	public void setNumeroAuditor(String numeroAuditor) {
		this.numeroAuditor = numeroAuditor;
	}

	public int getTiempoExpAuditor() {
		return tiempoExpAuditor;
	}

	public void setTiempoExpAuditor(int tiempoExpAuditor) {
		this.tiempoExpAuditor = tiempoExpAuditor;
	}

	public Especialidad getEspecialidadAuditor() {
		return especialidadAuditor;
	}

	public void setEspecialidadAuditor(Especialidad especialidadAuditor) {
		this.especialidadAuditor = especialidadAuditor;
	}

	public FirmaConsultora getFirmaAuditor() {
		return firmaAuditor;
	}

	public void setFirmaAuditor(FirmaConsultora firmaAuditor) {
		this.firmaAuditor = firmaAuditor;
	}

}
