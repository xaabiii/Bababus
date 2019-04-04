package presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import datos.FicheroTextoLectura;
import datos.ScheduledTask;
import negocio.Servicios;


@Named
@SessionScoped
public class TemporizadorMB implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void probandoFecha()
	{
		Timer time = new Timer();
		ScheduledTask st = new ScheduledTask();
		time.schedule(st, 0, 5000);
	}

	
}


