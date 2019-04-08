import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public String leerLinea()
	{
		String linea = "";
		try {
			linea = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linea;
	}
	
	public List<String> volcarFicheroArray()
	{
		String linea;
		List<String> lista = new ArrayList<>();
		
		while((linea = leerLinea()) != null)
		{
			String[] as = linea.split(" ");
			for(int i = 0; i < as.length;i++)
			{
				lista.add(as[i]);
			}
		}
		return lista;
		
		
		
	}
	
	

}
