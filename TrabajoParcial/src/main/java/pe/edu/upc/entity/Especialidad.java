package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "especialidad")
public class Especialidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspecialidad;

	@NotEmpty(message = "Ingresa el nombre de la especialidad")
	@Column(name = "nombreEspecialidad", nullable = false, length = 30)
	private String nombreEspecialidad;

	@NotEmpty(message = "Ingresa la certificadora")
	@Column(name = "certificadoraEspecialidad", nullable = false, length = 30)
	private String certificadoraEspecialidad;

	public Especialidad() {
		super();
	}

	public Especialidad(int idEspecialidad, String nombreEspecialidad, String certificadoraEspecialidad) {
		this.idEspecialidad = idEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
		this.certificadoraEspecialidad = certificadoraEspecialidad;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public String getCertificadoraEspecialidad() {
		return certificadoraEspecialidad;
	}

	public void setCertificadoraEspecialidad(String certificadoraEspecialidad) {
		this.certificadoraEspecialidad = certificadoraEspecialidad;
	}
}
