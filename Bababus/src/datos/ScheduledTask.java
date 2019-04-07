package datos;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;


public class ScheduledTask extends TimerTask
{
	private int i=0;

	
	public void run()
	{
		Date now;
		now = new Date();
		FicheroTextoLectura ftl = new FicheroTextoLectura("/home/gloria/Bababus/Bababus/coordenadas.txt");
		List<String> coordenadas = ftl.volcarFicheroArray();
		ftl.cerrarFichero();
		String c = coordenadas.get(i);
		System.out.println("Coordenada " + c + "enviada a las " + now);
		i++;

	}
	
	/*public List<String> cogeCoordenadas()
	{
		lista = sv.getCoordenadasFich();
		return lista;

	}*/
	
	
}
