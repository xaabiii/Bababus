package presentacion;

import java.io.Serializable; 
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import negocio.Servicios;


@Named
@SessionScoped
public class TemporizadorMB implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private float latitud;
	private float longitud;
	private boolean boton=false;
	
	public boolean isBoton() {
		return boton;
	}


	public void setBoton(boolean boton) {
		this.boton = boton;
	}


	@EJB
	private Servicios negocio;
	
	
	public float getLatitud() {
		return latitud;
	}


	public float getLongitud() {
		return longitud;
	}
	
	

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}


	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}


	public void preparaCoordenada1() 
	{
		String coordenada = negocio.getCoordenadaDB(1);
		String arrCor[] = coordenada.split(",");
		latitud = Float.parseFloat(arrCor[0]);
		longitud = Float.parseFloat(arrCor[1]);
	}
	public void preparaCoordenada2() 
	{
		String coordenada = negocio.getCoordenadaDB(2);
		String arrCor[] = coordenada.split(",");
		latitud = Float.parseFloat(arrCor[0]);
		longitud = Float.parseFloat(arrCor[1]);
	}
	public void preparaCoordenada3() 
	{
		String coordenada = negocio.getCoordenadaDB(3);
		String arrCor[] = coordenada.split(",");
		latitud = Float.parseFloat(arrCor[0]);
		longitud = Float.parseFloat(arrCor[1]);
	}
	public void preparaCoordenada4() 
	{
		String coordenada = negocio.getCoordenadaDB(4);
		String arrCor[] = coordenada.split(",");
		latitud = Float.parseFloat(arrCor[0]);
		longitud = Float.parseFloat(arrCor[1]);
	}


}


