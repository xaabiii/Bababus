
public class Array {
	private float []a;
	private int numE;
	
	public Array(int tam)
	{
		a = new float[tam];
		numE = 0;
	}

	public float[] getA() {
		return a;
	}

	public void setA(float[] a) {
		this.a = a;
	}

	public int getNumE() {
		return numE;
	}

	public void setNumE(int nE) {
		numE = nE;
	}
	
	public float getValor(int pos)
	{
		return a[pos];
	}
	
	public void setValor(int pos,float valor)
	{
		a[pos] = valor;
	}
	
	public void visualizarArray()
	{
		for(int i = 0; i < getNumE();i++)
		{
			System.out.print(a[i]+ " ");
		}
	}
	
	

}
