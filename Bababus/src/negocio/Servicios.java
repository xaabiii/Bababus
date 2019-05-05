package negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import datos.Autobus;
import datos.Horario;
import datos.Linea;
import datos.LineaHorario;
import datos.LineaParada;
import datos.Parada;
import datos.Usuario;



@LocalBean
//@Stateless
@Singleton
public class Servicios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String PATHBV= "/home/danel/Escritorio/github/Bababus/ficheros1/BilbaoVitoria.txt";
	private String PATHVB= "/home/danel/Escritorio/github/Bababus/ficheros1/VitoriaBilbao.txt";
	private String PATHVL= "/home/danel/Escritorio/github/Bababus/ficheros1/VitoriaLeioa.txt";
	private String PATHLV= "/home/danel/Escritorio/github/Bababus/ficheros1/LeioaVitoria.txt";
	private int indice=0;
	private int indice2=0;
	private int indice3=0;
	private int indice4=0;
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
	
	public String buscarLineaNombre(int id){
		
		Linea l =new Linea();
		l=em.find(Linea.class, id);
		
		return l.getOrigenDestino();
	}
	
	public String buscarParadaNombre(int id){
		
		LineaParada lp = new LineaParada();
		lp = em.find(LineaParada.class, id);
		
		
		return lp.getParada().getNombreParada();
		
	}
	
	public String buscarHorarioNombre(int id){
		
		LineaHorario lh =new LineaHorario();
		lh = em.find(LineaHorario.class, id);
		
		return lh.getHorario().getHora();
	}
	public int buscarHorarioId(int id){
		
		LineaHorario lh =new LineaHorario();
		lh = em.find(LineaHorario.class, id);
		
		return lh.getHorario().getIdHorario();
	}
	
	public String calcularTiempo(int idLinea, int id){
		
		String tiempo="xxx";
		
		if(idLinea == 1){
			tiempo=tiempoRestante(id, PATHBV);
			
		}
		else if(idLinea == 2){
			tiempo=tiempoRestante(id, PATHVB);
		}
		else if(idLinea == 3){
			tiempo=tiempoRestante(id, PATHVL);
		}
		else if(idLinea == 4){
			tiempo=tiempoRestante(id, PATHLV);
		}
		
		return tiempo;
		
	}

	
	public String tiempoRestante(int id, String path){
		
		LineaParada lp = new LineaParada();
		lp=em.find(LineaParada.class, id);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(id);
		
		String tiempo="xxx1";
		int horas=0;
		int minutos=0;
		int segundos=0;
		String bus_coordenadas;
		String parada_coordenadas;
		bus_coordenadas=lp.getLinea().getAutobus().getCoordenadas();
		parada_coordenadas=lp.getParada().getCoordenadas();
		
		int numlineas=-1;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    boolean salir=false;
		    boolean contar=false;
		    System.out.println(bus_coordenadas);
		    while ((line = br.readLine()) != null && salir == false) {
		       // process the line.
		    	if(line.equals(bus_coordenadas)){
		    		System.out.println("prueba1111111111111111111111111111111111");
		    		contar=true;
		    	}
		    	if(contar==true){
		    		
		    		numlineas=numlineas+1;
			    	System.out.println("empezamos a contar:");
			    	System.out.println("linea:");
			    	System.out.println(line);
			    	System.out.println("parada_coordenadas:");
			    	System.out.println(parada_coordenadas);
			    	System.out.println("numero de lineas:");
			    	System.out.println(numlineas);
			    	
			    	if(line.equals(parada_coordenadas)){
			    	
			    		System.out.println("ACERTAMOS:");
				    	System.out.println("linea:");
				    	System.out.println(line);
				    	System.out.println("parada_coordenadas:");
				    	System.out.println(parada_coordenadas);
				    	salir = true;
				    	
				    	segundos=numlineas * 40;
				    	
				    	horas=(segundos / 3600);
				    	minutos = (segundos % 3600) / 60;
				    	tiempo = String.format("%02d:%02d", horas, minutos);
				    	
			    	}
			    	else{
			    		
			    		tiempo="xxx";
			    	}
		    	

		    	}
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		
		
		return tiempo;
		
		
		
	}
	
	public void anadirUsuarioDB (int idLineaParada, int idLineaHorario, String TiempoAviso, String email){
		
		LineaHorario lh= new LineaHorario();
		lh = em.find(LineaHorario.class, idLineaHorario);
		LineaParada lp = new LineaParada();
		lp=em.find(LineaParada.class, idLineaParada);
		
		Usuario u =new Usuario();
		u.setLinea(lh.getLinea());
		u.setHorario(lh.getHorario());
		u.setParada(lp.getParada());
		
		Random rand = new Random();
		if (rand.nextInt(100) < 5){
			u.setIncidencia("true");
		}
		else{
			u.setIncidencia("false");
		}
		
		
		u.setEmail(email);
		u.setTiempoAviso(TiempoAviso);
		em.persist(u);
		
		//actualizamos las plazas libres del bus
		Autobus a= new Autobus();
		a=em.find(Autobus.class, lh.getLinea().getAutobus().getIdAutobus());
		a.setPlazas(a.getPlazas()-1);
		em.persist(a);
		

	}
	
	@SuppressWarnings("unchecked")
	public int numReserva(){
		
		List<Usuario> usuarios = (List<Usuario>) em.createNamedQuery("Usuario.findAll").getResultList();
		
		return usuarios.size();
		
	}
	@SuppressWarnings("unchecked")
	public int numPlazas(int idLinea, int idHorario){
		
		List<Usuario> usuarios = (List<Usuario>) em.createNamedQuery("UsuarioIdLineaIdHorario").setParameter("idLinea", idLinea).setParameter("idHorario", idHorario ).getResultList();
		
		
		return usuarios.size();
		
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> getListUsuarioLineaHorario(int idLinea, int idHorario){
		
		List<Usuario> usuarios = (List<Usuario>) em.createNamedQuery("UsuarioIdLineaIdHorario").setParameter("idLinea", idLinea).setParameter("idHorario", idHorario ).getResultList();
		
		
		return usuarios;
		
	}
	
	public void solicitarParadaDB(int idLineaParada){
		
		LineaParada lp =new LineaParada();
		lp=em.find(LineaParada.class, idLineaParada);
		lp.setParadaSolicitada("true");
		em.persist(lp);
	}
	
	
	
	@Schedule(second="*/1", minute="*", hour="*", persistent=false)
	public void AutobusBV(){
	       

        int numlinea=-1;
        indice=indice+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATHBV))) {
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
	
	@Schedule(second="*/1", minute="*", hour="*", persistent=false)
	public void AutobusVB(){
	       

        int numlinea=-1;
        indice2=indice2+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATHVB))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               
                numlinea=numlinea+1;
               
                if(numlinea == indice2){
               
                    System.out.println("linea:");
                    System.out.println(line);
                    System.out.println("numlinea:");
                    System.out.println(numlinea);
                    System.out.println("indice:");
                    System.out.println(indice);
                    Autobus a = new Autobus();
                    a=em.find(Autobus.class, 2);
                    a.setCoordenadas(line);
                    em.persist(a);
                    
                    /*String[] coords = line.split(",");
                    
                    
                    PrintWriter writer = new PrintWriter("/home/danel/workspace/Bababus/WebContent/coordenadas.txt", "UTF-8");
                    writer.println(coords[0]);
                    System.out.println("longitud:");
                    System.out.println(coords[0]);
                    System.out.println("latitud:");
                    System.out.println(coords[1]);
                    writer.println(coords[1]);
                    writer.close();*/
                    

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
	
	@Schedule(second="*/1", minute="*", hour="*", persistent=false)
	public void AutobusVL(){
	       

        int numlinea=-1;
        indice3=indice3+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATHVL))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               
                numlinea=numlinea+1;
               
                if(numlinea == indice3){
               
                    System.out.println("linea:");
                    System.out.println(line);
                    System.out.println("numlinea:");
                    System.out.println(numlinea);
                    System.out.println("indice:");
                    System.out.println(indice);
                    Autobus a = new Autobus();
                    a=em.find(Autobus.class, 3);
                    a.setCoordenadas(line);
                    em.persist(a);
                    
                    /*String[] coords = line.split(",");
                    
                    
                    PrintWriter writer = new PrintWriter("/home/danel/workspace/Bababus/WebContent/coordenadas.txt", "UTF-8");
                    writer.println(coords[0]);
                    System.out.println("longitud:");
                    System.out.println(coords[0]);
                    System.out.println("latitud:");
                    System.out.println(coords[1]);
                    writer.println(coords[1]);
                    writer.close();*/
                    

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
	@Schedule(second="*/1", minute="*", hour="*", persistent=false)
	public void AutobusLV(){
	       

        int numlinea=-1;
        indice4=indice4+1;
        try (BufferedReader br = new BufferedReader(new FileReader(PATHLV))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               
                numlinea=numlinea+1;
               
                if(numlinea == indice4){
               
                    System.out.println("linea:");
                    System.out.println(line);
                    System.out.println("numlinea:");
                    System.out.println(numlinea);
                    System.out.println("indice:");
                    System.out.println(indice);
                    Autobus a = new Autobus();
                    a=em.find(Autobus.class, 4);
                    a.setCoordenadas(line);
                    em.persist(a);
                    
                    /*String[] coords = line.split(",");
                    
                    
                    PrintWriter writer = new PrintWriter("/home/danel/workspace/Bababus/WebContent/coordenadas.txt", "UTF-8");
                    writer.println(coords[0]);
                    System.out.println("longitud:");
                    System.out.println(coords[0]);
                    System.out.println("latitud:");
                    System.out.println(coords[1]);
                    writer.println(coords[1]);
                    writer.close();*/
                    

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
	/*
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
	*/

}