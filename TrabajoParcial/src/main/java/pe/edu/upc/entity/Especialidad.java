package pe.edu.upc.entity;

public class Especialidad {

	private int idEspecialidad;
	private String nombreEspecialidad;
	private String certificadoraEspecialidad;
	
	public Especialidad() {
		super();
	}

	public Especialidad(int idEspecialidad, String nombreEspecialidad, String certificadoraEspecialidad) {
		super();
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
