package datos;

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
	private int idLinea;

	private String origenDestino;

	//bi-directional many-to-one association to Autobus
	@ManyToOne
	@JoinColumn(name="Autobus_idAutobus")
	private Autobus autobus;

	//bi-directional many-to-one association to LineaHorario
	@OneToMany(mappedBy="linea")
	private List<LineaHorario> lineaHorarios;

	//bi-directional many-to-one association to LineaParada
	@OneToMany(mappedBy="linea")
	private List<LineaParada> lineaParadas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="linea")
	private List<Usuario> usuarios;

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

	public List<LineaHorario> getLineaHorarios() {
		return this.lineaHorarios;
	}

	public void setLineaHorarios(List<LineaHorario> lineaHorarios) {
		this.lineaHorarios = lineaHorarios;
	}

	public LineaHorario addLineaHorario(LineaHorario lineaHorario) {
		getLineaHorarios().add(lineaHorario);
		lineaHorario.setLinea(this);

		return lineaHorario;
	}

	public LineaHorario removeLineaHorario(LineaHorario lineaHorario) {
		getLineaHorarios().remove(lineaHorario);
		lineaHorario.setLinea(null);

		return lineaHorario;
	}

	public List<LineaParada> getLineaParadas() {
		return this.lineaParadas;
	}

	public void setLineaParadas(List<LineaParada> lineaParadas) {
		this.lineaParadas = lineaParadas;
	}

	public LineaParada addLineaParada(LineaParada lineaParada) {
		getLineaParadas().add(lineaParada);
		lineaParada.setLinea(this);

		return lineaParada;
	}

	public LineaParada removeLineaParada(LineaParada lineaParada) {
		getLineaParadas().remove(lineaParada);
		lineaParada.setLinea(null);

		return lineaParada;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setLinea(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setLinea(null);

		return usuario;
	}

}