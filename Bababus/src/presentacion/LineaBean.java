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
import datos.Usuario;
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
	private String email;
	private boolean entra=false;
	private int numPlazasMax=80;
	private String parada;
	private int id=-5;
	private boolean verReserva = false;
	private boolean correcto = true;
	private boolean verParada=false;



	@EJB
	private Servicios negocio;
	
	
	
	public boolean isVerParada() {
		return verParada;
	}

	public void setVerParada(boolean verParada) {
		this.verParada = verParada;
	}
	public int getTiempoAviso() {
		return tiempoAviso;
	}

	public void setTiempoAviso(int tiempoAviso) {
		this.tiempoAviso = tiempoAviso;
	}
	
	public boolean isVerReserva() {
		return verReserva;
	}

	public void setVerReserva(boolean verReserva) {
		this.verReserva = verReserva;
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
		//parada=negocio.buscarParadaNombre(lineaparadas.get(indice2).getIdLineaParadas());
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		verReserva = false;
		verParada=false;
		//ver=false;
		
		return "home.xhtml";
	}
	
	public String cambiarPagina2(){
		entity.setOrigenDestino(lineas.get(indice1).getOrigenDestino());
		ver=false;
		verReserva=false;
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
	
	public String solicitaParada() {
		
		ver=false;
		verParada=true;
		
		
		return "El bababús se parará en " + negocio.buscarParadaNombre(entity2.getIdLineaParadas());
	}
	
	
	public String calcularTiempo(){
		
		verParada=false;
		ver=true;
		
		//String tiempo=negocio.calcularTiempo(entity.getIdLinea(),entity2.getIdLineaParadas());
		//String tiempo=negocio.calcularTiempo(1,1);
		

		if(entra == true){
			if (id == -5){
				
				id=entity2.getIdLineaParadas();
				parada=negocio.buscarParadaNombre(id);
			}
			String tiempo=negocio.calcularTiempo(entity.getIdLinea(), id);
			entra=false;
			return tiempo;
		}
		id=entity2.getIdLineaParadas();
		parada=negocio.buscarParadaNombre(id);
		
		
		String tiempo=negocio.calcularTiempo(entity.getIdLinea(),entity2.getIdLineaParadas());

		/*if (tiempo.equals("xxx1")){
			
			tiempo="ERROR: el de tiempo de aviso debe ser mayor que el tiempo de llegada del bababús";
			
			return tiempo;
		}
		*/
		
		
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
	

	
	public String anadirUsuario(){
		
		correcto = true;
		verReserva=false;
		//negocio.anadirUsuarioDB(entity2.getIdLineaParadas(), entity3.getIdLineaHorarios(), String.valueOf(tiempoAviso), email);
		
		entity.setOrigenDestino(negocio.buscarLineaNombre(entity.getIdLinea()));
		
		entra=true;
		String tiempoRestante=calcularTiempo();
		//entra=true;
		
		
		String body="Se ha completado la reserva de plaza en el bababús " + entity.getOrigenDestino() + " correctamente."
				+ "\nLe avisaremos " + tiempoAviso + " minutos antes de su llegada."
						+ ""
						+ "\nSituación actual:"
						+ "\n-Linea: " + entity.getOrigenDestino() + ""
						+ "\n-Hora de salida: " + negocio.buscarHorarioNombre(entity3.getIdLineaHorarios()) + ""
						+ "\n-Plazas libres: " + String.valueOf(numPlazasMax - negocio.numPlazas(entity.getIdLinea(), negocio.buscarHorarioId(entity3.getIdLineaHorarios()))) +""
						//+ "\n-Parada: " + negocio.buscarParadaNombre(entity2.getIdLineaParadas()) + ""
						+ "\n-Parada: " + parada + ""
						+ "\n-Tiempo restante para la llegada (h:min): " + tiempoRestante +""
						+ "\n-Incidencias: " + mensajeIncidencias() +""
						+ "\n\n\n\nAtentamente,\n\nBababús corporation";
		String subject="Reserva correcta: " + String.valueOf(negocio.numReserva());		
		
		if ( tiempoRestante.equals("xxx")){
			
			verReserva = true;
			
			return "ERROR: el bababús ya ha pasado por esta parada";
		}
		else{
			comprobar(tiempoAviso, tiempoRestante);
			if( correcto == true){
				negocio.anadirUsuarioDB(entity2.getIdLineaParadas(), entity3.getIdLineaHorarios(), String.valueOf(tiempoAviso), email);
				send_email(body, subject, email);
				notificar(tiempoAviso, tiempoRestante);
				
				return "reserva realizada correctamente";
			}
			
			verReserva = true;
			if (correcto == true){
				
				return "reserva realizada correctamente";
			}
			else{
				return "ERROR: el tiempo de aviso debe ser menor que el tiempo de llegada del bababús";
			}
			
		}
		
		
	}
	
	public String mensajeIncidencias(){
		
		String mensaje ="xxx";
		List<Usuario> usuarios = negocio.getListUsuarioLineaHorario(entity.getIdLinea(), negocio.buscarHorarioId(entity3.getIdLineaHorarios()));
		
		for (Usuario u : usuarios){
			
			if (u.getReserva().equals("true")){
				
				mensaje = "Posible retención, puede que el bababús se retrase";
				
				return mensaje;
			}
			else{
				
				mensaje = "No";
			}
		}
		
		if(mensaje.equals("xxx")){
			
			mensaje="ERROR: el de tiempo de aviso debe ser mayor que el tiempo de llegada del bababús";
		}
		
		return mensaje;
	}
	


	public void comprobar(int tiempoAntes, String tiempoRestante){
		
		
		String[] tiempos=tiempoRestante.split(":");
		int horas= Integer.valueOf(tiempos[0]);
		int minutos= Integer.valueOf(tiempos[1]);
		
		long tiempo=((horas*60)+minutos)*60*1000;

		long restante= tiempo - (tiempoAntes*60*1000);
		
		if ( restante < 0){
			
			correcto = false;
			
		}
		else{
			
			
		}
		
		
		
	}
	public void notificar(int tiempoAntes, String tiempoRestante){
		
		
		String[] tiempos=tiempoRestante.split(":");
		int horas= Integer.valueOf(tiempos[0]);
		int minutos= Integer.valueOf(tiempos[1]);
		
		long tiempo=((horas*60)+minutos)*60*1000;

		long restante= tiempo - (tiempoAntes*60*1000);
		
		if ( restante < 0){
			
			correcto = false;
			
		}
		else{
			
			String subject = "CORRE!";
			String body="corre que pierdes el bababús";
			long t1= System.currentTimeMillis();
			long t2= System.currentTimeMillis();
			boolean salir=false;
			
			while (salir == false){
				
				if (t2-t1 > restante){
					send_email(body, subject, email);
					salir=true;
				}
				else{
					t2= System.currentTimeMillis();
				}
				
			}
		}
		
		
		
	}
	

	 public static void send_email(String body, String subject, String toEmail1){  //String toEmail, 
		//authentication info
			final String username = "babcorreo@gmail.com";
			final String password = "babapassword";
			String fromEmail = "babcorreo@gmail.com";
			String toEmail = "babcorreo@gmail.com";
			
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