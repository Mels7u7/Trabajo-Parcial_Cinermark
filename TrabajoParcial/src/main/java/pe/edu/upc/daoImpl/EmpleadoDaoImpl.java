package pe.edu.upc.daoImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEmpleadoDao;
import pe.edu.upc.entity.Empleado;

public class EmpleadoDaoImpl implements IEmpleadoDao, Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "TrabajoParcial")
	private EntityManager em;
	
	@Transactional	
	@Override
	public void insertar(Empleado empleado)
	{
		try
		{
			em.persist(empleado);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
