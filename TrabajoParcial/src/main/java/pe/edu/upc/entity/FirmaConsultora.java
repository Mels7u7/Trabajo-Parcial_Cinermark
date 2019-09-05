package pe.edu.upc.entity;

public class FirmaConsultora {

	private int idFirma;
	private String nombreFirma;
	private String direccionFirma;
	private String contactoFirma;
	private String numeroFirma;
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
}
