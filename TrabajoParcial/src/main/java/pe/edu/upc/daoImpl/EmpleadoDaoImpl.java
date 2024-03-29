package pe.edu.upc.daoImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
    	try
		{
			em.persist(empleado);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
    
    @Transactional
	@Override
	public void eliminar(int idEmpleado) {
		// TODO Auto-generated method stub
		Empleado emp = new Empleado();
		try {
			emp = em.getReference(Empleado.class, idEmpleado);
			em.remove(emp);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> listar() {
		// TODO Auto-generated method stub
		List<Empleado> lista = new ArrayList<Empleado>();
		try
		{
			Query q = em.createQuery("Select h from Empleado h");
			lista = (List<Empleado>) q.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
	
	@Transactional
	@Override
	public void modificar(Empleado empleado) {
		try {
			em.merge(empleado);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
