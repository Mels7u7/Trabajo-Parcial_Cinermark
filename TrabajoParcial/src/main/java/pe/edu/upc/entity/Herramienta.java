package pe.edu.upc.entity;

public class Herramienta {

	private int idHerramienta;
	private String nombreHerramienta;
	private int stockHerramienta;
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
