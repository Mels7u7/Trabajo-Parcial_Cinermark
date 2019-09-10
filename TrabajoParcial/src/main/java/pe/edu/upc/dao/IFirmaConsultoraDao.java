package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.FirmaConsultora;

public interface IFirmaConsultoraDao {

	public void insertar(FirmaConsultora firma);
	public void eliminar(int idFirma);
	public List<FirmaConsultora> listar();
}
