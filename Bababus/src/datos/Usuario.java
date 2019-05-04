package datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="UsuarioIdLineaIdHorario", query="SELECT u FROM Usuario u WHERE u.linea.idLinea=:idLinea AND u.horario.idHorario=:idHorario")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;

	private String email;

	private String incidencia;

	private String tiempoAviso;

	//uni-directional many-to-one association to Horario
	@ManyToOne
	@JoinColumn(name="Horario_idHorario")
	private Horario horario;

	//uni-directional many-to-one association to Linea
	@ManyToOne
	@JoinColumn(name="Linea_idLinea")
	private Linea linea;

	//uni-directional many-to-one association to Parada
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

	public String getIncidencia() {
		return this.incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
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