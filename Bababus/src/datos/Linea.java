package datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Linea database table.
 * 
 */
@Entity
@NamedQuery(name="Linea.findAll", query="SELECT l FROM Linea l")
public class Linea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLinea;

	private String origenDestino;

	//uni-directional many-to-one association to Autobus
	@ManyToOne
	@JoinColumn(name="Autobus_idAutobus")
	private Autobus autobus;

	public Linea() {
	}

	public int getIdLinea() {
		return this.idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public String getOrigenDestino() {
		return this.origenDestino;
	}

	public void setOrigenDestino(String origenDestino) {
		this.origenDestino = origenDestino;
	}

	public Autobus getAutobus() {
		return this.autobus;
	}

	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}

}