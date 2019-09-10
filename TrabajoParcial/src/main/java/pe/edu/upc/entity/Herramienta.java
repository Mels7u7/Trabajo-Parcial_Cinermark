package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "herramienta")
public class Herramienta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHerramienta;

	@NotEmpty(message = "Ingresa el nombre de la herramienta")
	@Column(name = "nombreHerramienta", nullable = false, length = 50)
	private String nombreHerramienta;

	@Min(1)
	@Max(500)
	@Column(name = "stockHerramienta", nullable = false)
	private int stockHerramienta;

	@NotEmpty(message = "Ingresa las unidades")
	@Column(name = "unidadHerramienta", nullable = false, length = 50)
	private String unidadHerramienta;

	public Herramienta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Herramienta(int idHerramienta, String nombreHerramienta, int stockHerramienta, String unidadHerramienta) {
		this.idHerramienta = idHerramienta;
		this.nombreHerramienta = nombreHerramienta;
		this.stockHerramienta = stockHerramienta;
		this.unidadHerramienta = unidadHerramienta;
	}

	public int getIdHerramienta() {
		return idHerramienta;
	}

	public void setIdHerramienta(int idHerramienta) {
		this.idHerramienta = idHerramienta;
	}

	public String getNombreHerramienta() {
		return nombreHerramienta;
	}

	public void setNombreHerramienta(String nombreHerramienta) {
		this.nombreHerramienta = nombreHerramienta;
	}

	public int getStockHerramienta() {
		return stockHerramienta;
	}

	public void setStockHerramienta(int stockHerramienta) {
		this.stockHerramienta = stockHerramienta;
	}

	public String getUnidadHerramienta() {
		return unidadHerramienta;
	}

	public void setUnidadHerramienta(String unidadHerramienta) {
		this.unidadHerramienta = unidadHerramienta;
	}
}
