package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.FirmaConsultora;

public interface IFirmaConsultoraService {
	
	public void insertar(FirmaConsultora firma);
	public void eliminar(int idFirma);
	public List<FirmaConsultora> listar();


}
