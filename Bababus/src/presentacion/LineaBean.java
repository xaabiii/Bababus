package presentacion;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import datos.Linea;
import datos.LineaHorario;
import datos.LineaParada;
import datos.Parada;
import negocio.Servicios;



@Named
@SessionScoped
//@RequestScoped
public class LineaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Linea> lineas;
	private List<LineaParada> lineaparadas;
	private List<SelectItem> items1;
	private List<SelectItem> items2;
	private int indice1;
	private int indice2;
	private final Linea entity=new Linea();
	private final LineaParada entity2=new LineaParada();
	
	@EJB
	private Servicios negocio;
	//Set and get datos miembro
	public List<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}

	public List<SelectItem> getItems1() {
		return items1;
	}

	public void setItems1(List<SelectItem> items1) {
		this.items1 = items1;
	}

	public int getIndice1() {
		return indice1;
	}

	public void setIndice1(int indice1) {
		this.indice1 = indice1;
		entity.setIdLinea(lineas.get(indice1).getIdLinea());
	}

	public List<SelectItem> getItems2() {
		return items2;
	}

	public void setItems2(List<SelectItem> items2) {
		this.items2 = items2;
	}

	public int getIndice2() {
		return indice2;
	}

	public void setIndice2(int indice2) {
		this.indice2 = indice2;
		
	}

	//metodos
	public Linea getEntity() {
		return entity;
	}	
	public List<LineaHorario> getListLineaHorario(){
		
		
		lineaparadas=negocio.getListLineaParadaDB(entity.getIdLinea());
		items2=new ArrayList<>(lineaparadas.size());
		
		for( LineaParada p : lineaparadas){
			items2.add(new SelectItem(indice2++, p.getParada().getNombreParada()));
		}
		indice2=0;
		
		
		return negocio.getListLineaHorarioDB(entity.getIdLinea());
		
	}
	
	public String cambiarPagina1(){
		//HttpSession sesion=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);//para que deaparezca el texto que hemos
		//sesion.invalidate();
		
		return "home.xhtml";
	}
	
	public String cambiarPagina2(){
		entity.setOrigenDestino(lineas.get(indice1).getOrigenDestino());
		return "pag2.xhtml";
	}

	

	public List<LineaParada> getListLineaParada(){
		return negocio.getListLineaParadaDB(entity.getIdLinea());		
	}

	@PostConstruct
	public void prepararItems(){
		
		lineas=negocio.getListLineaDB();
		items1=new ArrayList<>(lineas.size());
		
		for( Linea l  : lineas){
			items1.add(new SelectItem(indice1++, l.getOrigenDestino()));
		}
		indice1=0;
		
		
	}

public String calcularTiempo(){
		
		ver=true;
		
		return negocio.calcularTiempo(entity2.getIdLineaParadas());
		
	}
	

	
}
