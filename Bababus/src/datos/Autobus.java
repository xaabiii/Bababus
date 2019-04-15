package datos;

import java.io.Serializable; 
import javax.persistence.*;


/**
 * The persistent class for the Autobus database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Autobus.findAll", query="SELECT a FROM Autobus a"),
	@NamedQuery(name="Autobus.findAuto", query="SELECT a FROM Autobus a WHERE a.idAutobus=:idAutobus")
})
public class Autobus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAutobus;

	private String coordenadas;

	private int plazas;

	public Autobus() {
	}

	public int getIdAutobus() {
		return this.idAutobus;
	}

	public void setIdAutobus(int idAutobus) {
		this.idAutobus = idAutobus;
	}

	public String getCoordenadas() {
		return this.coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public int getPlazas() {
		return this.plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

}