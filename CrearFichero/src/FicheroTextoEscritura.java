import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
	
	public void volvarArrayFichero(Array a)
	{
		for(int i = 0,j = 1; i < a.getNumE();i = i+2,j = j+2)
		{
			pw.println(a.getValor(i)+" "+a.getValor(j));
			
		}
	}
	

}
