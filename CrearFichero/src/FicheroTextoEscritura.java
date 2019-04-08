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
	
	public void volvarArrayFichero(List<String> lista)
	{
		for(int i = 0,j = 1; i <lista.size() && j < lista.size();i = i+2,j = j+2)
		{
			pw.println(lista.get(i)+" "+lista.get(j));
			
		}
	}
	

}
