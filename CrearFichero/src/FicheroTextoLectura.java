import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicheroTextoLectura extends Fichero {

	private FileReader fr;
	private BufferedReader br;
	
	public FicheroTextoLectura(String nombre) {
		super(nombre);
		fr = null;
		br = null;
		
	}
	
	public void abrirFichero()
	{
		try {
			fr = new FileReader(getF());
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cerrarFichero()
	{
		if(br != null)
		{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(fr != null)
		{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Array volcarFicheroArray(int tam)
	{
		String linea = null;
		Array a = new Array(tam);
		ArrayString as = null;
		int cont = 0;
		try {
			linea = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(linea != null)
		{
			as = new ArrayString(linea);
			for(int i = 0; i < as.getNumE();i++)
			{
				a.setValor(cont,Float.parseFloat(as.getValor(i)));
				cont++;
				a.setNumE(cont);
			}
			try {
				linea = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return a;
	}
	
	

}
