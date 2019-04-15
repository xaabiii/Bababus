import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FicheroTextoEscritura extends Fichero {

	private PrintWriter pw;
	
	public FicheroTextoEscritura(String nombre) {
		super(nombre);
		pw = null;
		
	}
	
	public void abrirFichero()
	{
		try {
			pw = new PrintWriter(getF());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cerrarFichero()
	{
		if(pw != null)
		{
			pw.flush();
		}
	}
	
	public void volarArrayFicheroLatitudes(List<String> lista)
	{
		for(int i = 0; i <lista.size();i = i+12)
		{
			pw.println(lista.get(i));
			
		}
	}
	public void volcarArrayFicheroLongitudes(List<String> lista)
	{
		for(int i = 1; i <lista.size();i = i+12)
		{
			pw.println(lista.get(i));
			
		}
	}
	public void volcarArrayFichero(List<String> lista)
	{
		for(int i = 0,j = 1; i < lista.size() && j < lista.size(); i = i + 16,j = j + 16)
		{
			pw.println(lista.get(i)+","+lista.get(j));
		}
	}
	
	

}
