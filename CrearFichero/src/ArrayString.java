
public class ArrayString {
	
	private String []a;
	private int numE;
	
	public ArrayString(int tam) {
		a = new String[tam];
		numE = 0;
	}
	public ArrayString(String linea) {
		a = linea.split(" ");
		numE = a.length;
	}
	public String[] getA() {
		return a;
	}
	public void setA(String[] a) {
		this.a = a;
	}
	public int getNumE() {
		return numE;
	}
	public void setNumE(int nE) {
		numE = nE;
	}
	public int getTam() {
		return a.length;
	}
	public String getValor(int pos) {
		return a[pos];
	}
	public void setValor(int pos,String valor) {
		a[pos] = valor;
	}
	public void visualizarArray()
	{
		for(int i = 0; i<getNumE();i++)
		{
			System.out.print(a[i]+ " ");
		}
	}
	
	

}
