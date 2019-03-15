package pl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import bl.LogicaDB;
import dl.Linea;

@Named
@RequestScoped
public class LineaMB implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Linea l = new Linea();
	private List<Linea> listaN;
	private List<SelectItem> items;
	private int i;
	@EJB
	private LogicaDB miejb;
	
	public LineaMB()
	{
		listaN =new ArrayList<>();
	}
	
	//LISTAR 
	public void preparaNombresLineas()
	{
		listaN = miejb.getNombresLineasDB();
		items = new ArrayList<SelectItem>(listaN.size());
		for(Linea l : listaN)
		{
			items.add(new SelectItem(i++, l.getOrigenDestino()));
			i=0;
		}
	}

	public List<Linea> getListaN() {
		return listaN;
	}

	public void setListaN(List<Linea> listaN) {
		this.listaN = listaN;
	}

	public List<SelectItem> getItems() {
		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}

	public Linea getL() {
		return l;
	}

	public void setL(Linea l) {
		this.l = l;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
		setL(listaN.get(i));
	}

	

	
}
