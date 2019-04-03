package presentacion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import datos.Fichero;
import datos.FicheroTextoLectura;

public class TemporizadorMB implements Serializable
{
	private static final long serialVersionUID = 1L;

	private FicheroTextoLectura ftl = new FicheroTextoLectura("NOMBREDELFICHERO");
		
	Timer timer = new Timer(20000, new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    { 
	    	List coordenadas = volcarFicheroArray();
	    	
	    }
	    
	});


}
