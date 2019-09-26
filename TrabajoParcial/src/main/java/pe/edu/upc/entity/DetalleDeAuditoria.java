package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Detalle de Auditoria")
public class DetalleDeAuditoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalledeAuditoria;

	@ManyToOne
	@JoinColumn(name = "Codigo Herramienta")
	private Herramienta idHerrameintaFK;

	public DetalleDeAuditoria() {
		super();
	}

	public DetalleDeAuditoria(int idDetalledeAuditoria, Herramienta idHerrameintaFK) {
		super();
		this.idDetalledeAuditoria = idDetalledeAuditoria;
		this.idHerrameintaFK = idHerrameintaFK;
	}

	public int getIdDetalledeAuditoria() {
		return idDetalledeAuditoria;
	}

	public void setIdDetalledeAuditoria(int idDetalledeAuditoria) {
		this.idDetalledeAuditoria = idDetalledeAuditoria;
	}

	public Herramienta getIdHerrameintaFK() {
		return idHerrameintaFK;
	}

	public void setIdHerrameintaFK(Herramienta idHerrameintaFK) {
		this.idHerrameintaFK = idHerrameintaFK;
	}

}
