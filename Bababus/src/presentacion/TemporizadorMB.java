package presentacion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import datos.FicheroTextoLectura;
import datos.ScheduledTask;
import negocio.Servicios;


@Named
@SessionScoped
public class TemporizadorMB implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	
	public void probandoFecha()
	{
		Timer time = new Timer();
		ScheduledTask st = new ScheduledTask();
		time.schedule(st, 0, 5000);
	}

	@PostConstruct
	public void prepararEngine()
	{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("latitu");
		try {
			engine.eval(new FileReader("prueba.html"));
		} catch (FileNotFoundException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Invocable invocable = (Invocable)engine;
		try {
			invocable.invokeFunction("prueba", "Java Script1");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public String getCoordenadas() 
	{
		
		return coordenadas;
	}
}


