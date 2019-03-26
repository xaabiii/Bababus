package negocio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import datos.Linea;
import datos.LineaHorario;
import datos.LineaParada;
import datos.Parada;



@LocalBean
@Stateless
public class Servicios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Linea> getListLineaDB(){
		
		List<Linea> lineas= (List<Linea>)em.createNamedQuery("Linea.findAll").getResultList();
	
		return lineas;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<LineaHorario> getListLineaHorarioDB(int id){
		
		List<LineaHorario> lineaHorarios = (List<LineaHorario>) em.createNamedQuery("LineaHorarioIdLinea").setParameter("idLinea", id).getResultList();
		
		return lineaHorarios;
		
	}
	@SuppressWarnings("unchecked")
	public List<Parada> getListParadaDB(){
		
		List<Parada> paradas = (List<Parada>) em.createNamedQuery("Parada.findAll").getResultList();
		
		return paradas;
	}
	@SuppressWarnings("unchecked")
	public List<LineaParada> getListLineaParadaDB(int id){
		
		List<LineaParada> LineaParadas = (List<LineaParada>) em.createNamedQuery("LineaParadaIdLinea").setParameter("idLinea", id).getResultList();
		
		return LineaParadas;
	}
		
		
	

}
