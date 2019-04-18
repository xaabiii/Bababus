package negocio;

import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import datos.Autobus;
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
	private String PATH="/home/gloria/Bababus/Bababus/SarrikoDeustoNuevo.txt";
	private static final long serialVersionUID = 1L;
	
	private int indice=0;
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
	
	@Schedule(second="*/10", minute="*", hour="*", persistent=false)
    public void AutobusBV(){
       

        int numlinea=-1;
        indice=indice+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               
                numlinea=numlinea+1;
               
                if(numlinea == indice){
               
                    System.out.println("linea:");
                    System.out.println(line);
                    System.out.println("numlinea:");
                    System.out.println(numlinea);
                    System.out.println("indice:");
                    System.out.println(indice);
                    Autobus a = new Autobus();
                    a=em.find(Autobus.class, 1);
                    a.setCoordenadas(line);
                    em.persist(a);
                    

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
	
	@Schedule(second="*/10", minute="*", hour="*", persistent=false)
    public void AutobusVB(){
       

        int numlinea=-1;
        indice=indice+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               
                numlinea=numlinea+1;
               
                if(numlinea == indice){
               
                    Autobus a = new Autobus();
                    a=em.find(Autobus.class, 2);
                    a.setCoordenadas(line);
                    em.persist(a);
                    

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
	@Schedule(second="*/10", minute="*", hour="*", persistent=false)
    public void AutobusVL(){
       

        int numlinea=-1;
        indice=indice+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               
                numlinea=numlinea+1;
               
                if(numlinea == indice){
               
                    Autobus a = new Autobus();
                    a=em.find(Autobus.class, 3);
                    a.setCoordenadas(line);
                    em.persist(a);
                    

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
	@Schedule(second="*/10", minute="*", hour="*", persistent=false)
    public void AutobusLV(){
       

        int numlinea=-1;
        indice=indice+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               
                numlinea=numlinea+1;
               
                if(numlinea == indice){
               
                    Autobus a = new Autobus();
                    a=em.find(Autobus.class, 4);
                    a.setCoordenadas(line);
                    em.persist(a);
                    

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
	
	public String getCoordenadaDB(int idAutobus)
	{
		Autobus autob = new Autobus();
		autob = (Autobus) em.createNamedQuery("Autobus.findAuto").setParameter("idAutobus", idAutobus).getSingleResult();
		return autob.getCoordenadas();
	}
		

}
