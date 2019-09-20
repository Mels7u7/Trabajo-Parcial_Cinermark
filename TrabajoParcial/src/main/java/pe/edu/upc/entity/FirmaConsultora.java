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
@Table(name = "firma")
public class FirmaConsultora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFirma;

	@NotEmpty(message = "Ingresar el nombre de la firma consultora")
	@Column(name = "nombreFirma", nullable = false, length = 30)
	private String nombreFirma;

	@NotEmpty(message = "Ingresar la direccion de la sede principal de la firma consultora")
	@Column(name = "direccionFirma", nullable = false, length = 70)
	private String direccionFirma;

	@NotEmpty(message = "Ingresa el nombre de contacto de la dirma consultora")
	@Column(name = "contactoFirma", nullable = false, length = 30)
	private String contactoFirma;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingresar el numero de contacto de la firma consultora")
	@Column(name = "numeroFirma", nullable = false, length = 45, unique = true)
	private String numeroFirma;

	@NotEmpty(message = "Ingrese el nivel de prestigio que tiene la firma consultora")
	@Column(name = "prestigioFirma", nullable = false, length = 20)
	private String prestigioFirma;

	public FirmaConsultora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FirmaConsultora(int idFirma, String nombreFirma, String direccionFirma, String contactoFirma,
			String numeroFirma, String prestigioFirma) {
		this.idFirma = idFirma;
		this.nombreFirma = nombreFirma;
		this.direccionFirma = direccionFirma;
		this.contactoFirma = contactoFirma;
		this.numeroFirma = numeroFirma;
		this.prestigioFirma = prestigioFirma;
	}

	public int getIdFirma() {
		return idFirma;
	}

	public void setIdFirma(int idFirma) {
		this.idFirma = idFirma;
	}

	public String getNombreFirma() {
		return nombreFirma;
	}

	public void setNombreFirma(String nombreFirma) {
		this.nombreFirma = nombreFirma;
	}

	public String getDireccionFirma() {
		return direccionFirma;
	}

	public void setDireccionFirma(String direccionFirma) {
		this.direccionFirma = direccionFirma;
	}

	public String getContactoFirma() {
		return contactoFirma;
	}

	public void setContactoFirma(String contactoFirma) {
		this.contactoFirma = contactoFirma;
	}

	public String getNumeroFirma() {
		return numeroFirma;
	}

	public void setNumeroFirma(String numeroFirma) {
		this.numeroFirma = numeroFirma;
	}

	public String getPrestigioFirma() {
		return prestigioFirma;
	}

	public void setPrestigioFirma(String prestigioFirma) {
		this.prestigioFirma = prestigioFirma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFirma;
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
		FirmaConsultora other = (FirmaConsultora) obj;
		if (idFirma != other.idFirma)
			return false;
		return true;
	}
}
