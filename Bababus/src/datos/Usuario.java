package datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsuario;

	private String email;

	private String reserva;

	private String tiempoAviso;

	//bi-directional many-to-one association to Horario
	@ManyToOne
	@JoinColumn(name="Horario_idHorario")
	private Horario horario;

	//bi-directional many-to-one association to Linea
	@ManyToOne
	@JoinColumn(name="Linea_idLinea")
	private Linea linea;

	//bi-directional many-to-one association to Parada
	@ManyToOne
	@JoinColumn(name="Parada_idParadas")
	private Parada parada;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReserva() {
		return this.reserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}

	public String getTiempoAviso() {
		return this.tiempoAviso;
	}

	public void setTiempoAviso(String tiempoAviso) {
		this.tiempoAviso = tiempoAviso;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Parada getParada() {
		return this.parada;
	}

	public void setParada(Parada parada) {
		this.parada = parada;
	}

}