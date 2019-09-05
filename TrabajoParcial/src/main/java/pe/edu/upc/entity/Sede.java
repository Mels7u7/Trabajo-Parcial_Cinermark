package pe.edu.upc.entity;

public class Sede {

	private int idSede;
	private String direccionSede;
	
	public Sede() {
		super();
	}

	public Sede(int idSede, String direccionSede) {
		super();
		this.idSede = idSede;
		this.direccionSede = direccionSede;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public String getDireccionSede() {
		return direccionSede;
	}

	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
	}
}
