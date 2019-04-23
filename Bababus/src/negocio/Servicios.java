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


	@Schedule(second="*", minute="39", hour="10", persistent=false)
	public void AutobusBV(){
	    
		long t1= System.currentTimeMillis();
		long t2= System.currentTimeMillis();
		System.out.println("holaaa");
		boolean salir=false;
		while(salir == false){
			
			
			//System.out.println("NO");
			t2= System.currentTimeMillis();
			//System.out.println(t1);
			//System.out.println(t2);
			
			
			if((t2-t1) < 10000){
				
				//System.out.println("NO");
			}
			else{
				
				System.out.println("SSSSSSSSSSSSSSSIIIIIIIIIIIIIIIIIIIIIIIIII");
				System.out.println("han pasado 10 segssssssssssssssssssssssssssss");
				System.out.println(t2-t1);
				


		        int numlinea=-1;
		        indice=indice+1;
		        try (BufferedReader br = new BufferedReader(new FileReader("/home/danel/Escritorio/coordenadas.txt"))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		               // process the line.
		            	//System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
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
		                    System.out.println("coordenadas en la base de datos:");
		                    System.out.println(a.getCoordenadas());
		                    a.setCoordenadas(line);
		                    em.persist(a);
		                    
		                    
		                    
		                    String[] coords = line.split(",");
		                    
		                    
		                    PrintWriter writer = new PrintWriter("/home/danel/workspace/Bababus/WebContent/coordenadas.txt", "UTF-8");
		                    writer.println(coords[0]);
		                    System.out.println("longitud:");
		                    System.out.println(coords[0]);
		                    System.out.println("latitud:");
		                    System.out.println(coords[1]);
		                    writer.println(coords[1]);
		                    writer.close();
		                    

		                }
		            }
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		        t1= System.currentTimeMillis();
				t2= System.currentTimeMillis();
				System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
				System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
				System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
				System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
				
				System.out.println(t1);
				System.out.println(t2);

		}
		
		
		
		
	}
		
	

}
		

}
