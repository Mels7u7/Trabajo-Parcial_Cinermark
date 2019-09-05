package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "herramienta")
public class Herramienta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* gaaaaaaaaaaaaaaaaa */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHerramienta;

	@Column(name = "nombreHerramienta", nullable = false, length = 50)
	private String nombreHerramienta;

	private int stockHerramienta;

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
