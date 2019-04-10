
public class Main {

	public static void main(String[] args) {
		FicheroTextoLectura ftl = new FicheroTextoLectura("prueba.txt");
		ftl.abrirFichero();
		int tam = (int) ftl.getTamanio();
		Array a = new Array(tam);
		a = ftl.volcarFicheroArray(tam);
		a.visualizarArray();
		FicheroTextoEscritura fte = new FicheroTextoEscritura("salida.txt");
		fte.abrirFichero();
		fte.volvarArrayFichero(a);
		ftl.cerrarFichero();
		fte.cerrarFichero();
		

	}

}
