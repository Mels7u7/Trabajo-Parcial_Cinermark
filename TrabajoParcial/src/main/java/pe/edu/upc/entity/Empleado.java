package pe.edu.upc.entity;

public class Empleado {

	private int idEmpleado;
	private String nombreEmpleado;
	private String apellidoEmpleado;
	private int dniEmpleado;
	private String puestolaboralEmpleado;
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, int dniEmpleado,
			String puestolaboralEmpleado) {
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.dniEmpleado = dniEmpleado;
		this.puestolaboralEmpleado = puestolaboralEmpleado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public int getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(int dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getPuestolaboralEmpleado() {
		return puestolaboralEmpleado;
	}

	public void setPuestolaboralEmpleado(String puestolaboralEmpleado) {
		this.puestolaboralEmpleado = puestolaboralEmpleado;
	}
	
}
