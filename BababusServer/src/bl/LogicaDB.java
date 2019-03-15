package bl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.Linea;

@LocalBean
@Stateless
public class LogicaDB implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	//LISTAR
	@SuppressWarnings("unchecked")
	public List<Linea> getNombresLineasDB()
	{
		List<Linea> listaN = new ArrayList<>();
		listaN = em.createNamedQuery("Linea.findAll").getResultList();
		return listaN;
	}
	
	
}
