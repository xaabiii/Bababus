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
	
	public void volvarArrayFicheroLatitudes(List<String> lista)
	{
		for(int i = 0; i <lista.size();i = i+2)
		{
			pw.println(lista.get(i));
			
		}
	}
	public void volvarArrayFicheroLongitudes(List<String> lista)
	{
		for(int i = 1; i <lista.size();i = i+2)
		{
			pw.println(lista.get(i));
			
		}
	}
	

}
