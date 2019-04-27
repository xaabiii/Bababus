import java.util.List;

public class Main {

	public static void main(String[] args) {
		FicheroTextoLectura ftl = new FicheroTextoLectura("VitoriaLeioa.txt");
		ftl.abrirFichero();
		List<String> lista = ftl.volcarFicheroArray();
		ftl.cerrarFichero();
		FicheroTextoEscritura fte1 = new FicheroTextoEscritura("VitoriaLeioaTodoLatLong.txt");
		fte1.abrirFichero();
		//FicheroTextoEscritura fte2 = new FicheroTextoEscritura("SarrikoDeustoLongitudes.txt");
		//fte2.abrirFichero();
		fte1.volcarArrayFichero(lista);
		fte1.cerrarFichero();
		//fte2.volvarArrayFicheroLongitudes(lista);
		//fte2.cerrarFichero();
		
		
		

	}

}
