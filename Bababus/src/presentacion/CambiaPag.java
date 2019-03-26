package presentacion;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
//@SessionScoped
@RequestScoped
public class CambiaPag implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String cambiarPagina1(){
		HttpSession sesion=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);//para que deaparezca el texto que hemos
		sesion.invalidate();
		
		return "pagina1.xhtml?faces-redirect=true";
	}

}
