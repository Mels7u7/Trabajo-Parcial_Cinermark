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
@Table(name = "sala")
public class Sala implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSala;

	@NotEmpty(message = "Ingresa el tipo de sala")
	@Column(name = "tipoSala", nullable = false, length = 50)
	private String tipoSala;

	@Min(1)
	@Max(100)
	@Column(name = "capacidadSala", nullable = false)
	private int capacidadSala;

	@ManyToOne
	@JoinColumn(name = "idSede")
	private Sede sedeSala;

	public Sala() {
		super();
	}

	public Sala(int idSala, String tipoSala, int capacidadSala, Sede sedeSala) {
		super();
		this.idSala = idSala;
		this.tipoSala = tipoSala;
		this.capacidadSala = capacidadSala;
		this.sedeSala = sedeSala;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getCapacidadSala() {
		return capacidadSala;
	}

	public void setCapacidadSala(int capacidadSala) {
		this.capacidadSala = capacidadSala;
	}

	public Sede getSedeSala() {
		return sedeSala;
	}

	public void setSedeSala(Sede sedeSala) {
		this.sedeSala = sedeSala;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSala;
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
		Sala other = (Sala) obj;
		if (idSala != other.idSala)
			return false;
		return true;
	}
}
