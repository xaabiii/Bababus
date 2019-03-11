package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Parada database table.
 * 
 */
@Entity
@NamedQuery(name="Parada.findAll", query="SELECT p FROM Parada p")
public class Parada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idParada;

	private String coordenadas;

	private String nombreParada;

	public Parada() {
	}

	public int getIdParada() {
		return this.idParada;
	}

	public void setIdParada(int idParada) {
		this.idParada = idParada;
	}

	public String getCoordenadas() {
		return this.coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getNombreParada() {
		return this.nombreParada;
	}

	public void setNombreParada(String nombreParada) {
		this.nombreParada = nombreParada;
	}

}