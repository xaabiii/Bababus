import java.io.File;

public class Fichero {
	private File f;
	
	public Fichero(String nombre)
	{
		f = new File(nombre);
	}
	
	public boolean existeFichero()
	{
		return f.exists();
	}
	
	public long getTamanio()
	{
		return f.length();
	}
	
	public File getF()
	{
		return f;
	}
	
	public String getNombre()
	{
		return f.getName();
	}

}
