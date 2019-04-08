import java.util.List;

public class Main {

	public static void main(String[] args) {
		FicheroTextoLectura ftl = new FicheroTextoLectura("BilbaoVitoria.txt");
		ftl.abrirFichero();
		List<String> lista = ftl.volcarFicheroArray();
		ftl.cerrarFichero();
		FicheroTextoEscritura fte = new FicheroTextoEscritura("nuevo.txt");
		fte.abrirFichero();
		fte.volvarArrayFichero(lista);
		fte.cerrarFichero();
		
		
		

	}

}
