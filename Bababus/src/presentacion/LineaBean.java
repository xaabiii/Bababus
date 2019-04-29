package presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;

import datos.Horario;
import datos.Linea;
import datos.LineaHorario;
import datos.LineaParada;
import datos.Parada;
import negocio.Servicios;




import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



@Named
@SessionScoped
//@RequestScoped
public class LineaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Linea> lineas;
	private List<LineaParada> lineaparadas;
	private List<LineaHorario> lineahorarios;
	private List<SelectItem> items1;
	private List<SelectItem> items2;
	private List<SelectItem> items3;
	private int indice1;
	private int indice2;
	private int indice3;
	private final Linea entity=new Linea();
	private final LineaParada entity2=new LineaParada();
	private final LineaHorario entity3=new LineaHorario();
	private boolean ver= false;
	private int tiempoAviso;
	
	
	@EJB
	private Servicios negocio;
	
	
	public int getTiempoAviso() {
		return tiempoAviso;
	}

	public void setTiempoAviso(int tiempoAviso) {
		this.tiempoAviso = tiempoAviso;
	}

	public List<SelectItem> getItems3() {
		
		
		
		lineahorarios=negocio.getListLineaHorarioDB(entity.getIdLinea());
		items3=new ArrayList<>(lineahorarios.size());
		
		for( LineaHorario lh : lineahorarios){
			items3.add(new SelectItem(indice3++, lh.getHorario().getHora()));
		}
		indice3=0;
		
		
		
		return items3;
	}

	public void setItems3(List<SelectItem> items3) {
		this.items3 = items3;
	}

	public int getIndice3() {
		return indice3;
	}

	public void setIndice3(int indice3) {
		this.indice3 = indice3;
		entity3.setIdLineaHorarios(lineahorarios.get(indice3).getIdLineaHorarios());
	}
	
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
		entity2.setIdLineaParadas(lineaparadas.get(indice2).getIdLineaParadas());
	}
	
	public boolean isVer() {
		return ver;
	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}


	
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
		
		return "pagina1.xhtml";
	}
	
	public String cambiarPagina2(){
		
		ver=false;
		return "pagina2.xhtml";
	}
	public String cambiarPagina3(){
		//HttpSession sesion=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);//para que deaparezca el texto que hemos
		//sesion.invalidate();
		
		return "pagina3.xhtml";
	}
	public String verMapa(){
		//HttpSession sesion=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);//para que deaparezca el texto que hemos
		//sesion.invalidate();
		
		if (entity.getIdLinea() == 1){
			return "MapboxBV.html";
		}
		else if (entity.getIdLinea() == 2){
			return "MapboxVB.html";
		}
		else if (entity.getIdLinea() == 3){
			return "MapboxVL.html";
		}
		else {
			return "MapboxLV.html";
		}
		
		
	}


	public List<LineaParada> getListLineaParada(){
		
		
		return negocio.getListLineaParadaDB(entity.getIdLinea());
		
	}
	
	
	public String calcularTiempo(){
		
		ver=true;
		
		String tiempo=negocio.calcularTiempo(entity.getIdLinea(),entity2.getIdLineaParadas());
		//String tiempo=negocio.calcularTiempo(1,1);
		
		if(tiempo.equals("xxx")){
			
			tiempo="El bababús ya ha pasado por la parada "  + negocio.buscarParadaNombre(entity2.getIdLineaParadas());
			
		}
		else{
			tiempo="El siguiente bababús llegará en: " + tiempo + " a la parada " + negocio.buscarParadaNombre(entity2.getIdLineaParadas());
			
		}
		
		return tiempo;
		
	}
	
	public void visualiza(){
		
		ver = true;
		//HttpSession sesion=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);//para que deaparezca el texto que hemos
		//sesion.invalidate();
				
		//return "pagina2.xhtml";
		//return ver;
	}
	
	
	public void getListHorario(){
		
		
		lineahorarios=negocio.getListLineaHorarioDB(entity.getIdLinea());
		items3=new ArrayList<>(lineahorarios.size());
		
		for( LineaHorario lh : lineahorarios){
			items3.add(new SelectItem(indice3++, lh.getHorario().getHora()));
		}
		indice3=0;
		
		
		//return negocio.getListLineaHorarioDB(entity.getIdLinea());
		
	}
	

	
	public void anadirUsuario(){
		
		
		negocio.anadirUsuarioDB(entity2.getIdLineaParadas(), entity3.getIdLineaHorarios(), String.valueOf(tiempoAviso));
		
		entity.setOrigenDestino(negocio.buscarLineaNombre(entity.getIdLinea()));
		
		
		
		
		
		String body="Se ha completado la reserva de plaza en el bababús " + entity.getOrigenDestino() + " correctamente."
				+ "\nLe avisaremos " + tiempoAviso + " minutos antes de su llegada."
						+ ""
						+ "\nSituacion actual:"
						+ "\n-Linea: " + entity.getOrigenDestino() + ""
						+ "\n-Hora de salida: " + negocio.buscarHorarioNombre(entity3.getIdLineaHorarios()) + ""//solo podremos reservar el bus actual
						+ "\n-Plazas libres: 32" + ""
						+ "\n-Parada: " + negocio.buscarParadaNombre(entity2.getIdLineaParadas()) + ""
						+ "\n-Tiempo restante para la llegada: " + calcularTiempo() +""
						+ "\n\n\n\nAtentamente,\n\nBababús corporation";
		String subject="Reserva correcta: 87392837";		
		
		send_email(body, subject);
		notificar(tiempoAviso);
		
	}
	

	
	public void notificar(int tiempo){
		
		long restante= tiempo*60*1000;
		String subject = "CORRE!";
		String body="corre que pierdes el bababús";
		long t1= System.currentTimeMillis();
		long t2= System.currentTimeMillis();
		boolean salir=false;
		
		while (salir == false){
			
			if (t2-t1 > restante){
				send_email(body, subject);
				salir=true;
			}
			else{
				t2= System.currentTimeMillis();
			}
			
		}
		
		
	}
	

	 public static void send_email(String body, String subject){  //String toEmail, 
		//authentication info
			final String username = "prueba77sarenet@gmail.com";
			final String password = "Ejemplo11";
			String fromEmail = "prueba77sarenet@gmail.com";
			String toEmail = "prueba77sarenet@gmail.com";
			
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});
			//Start our mail message
			MimeMessage msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(fromEmail));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				msg.setSubject(subject);
				msg.setText(body);
				Transport.send(msg);
				System.out.println("Sent message");
			} catch (MessagingException e) {
				e.printStackTrace();
			}

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
	

	
}