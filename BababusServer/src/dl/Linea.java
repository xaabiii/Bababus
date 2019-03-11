package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//uni-directional many-to-many association to Horario
	@ManyToMany
	@JoinTable(
		name="LineaHorario"
		, joinColumns={
			@JoinColumn(name="Linea_idLinea")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Horario_idHorario")
			}
		)
	private List<Horario> horarios;

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

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

}