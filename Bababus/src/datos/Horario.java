package datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Horario database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h"),
@NamedQuery(name="HorarioLinea", query= "SELECT h FROM Horario h" )
})
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idHorario;

	private String hora;

	//bi-directional many-to-one association to LineaHorario
	@OneToMany(mappedBy="horario")
	private List<LineaHorario> lineaHorarios;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="horario")
	private List<Usuario> usuarios;

	public Horario() {
	}

	public int getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<LineaHorario> getLineaHorarios() {
		return this.lineaHorarios;
	}

	public void setLineaHorarios(List<LineaHorario> lineaHorarios) {
		this.lineaHorarios = lineaHorarios;
	}

	public LineaHorario addLineaHorario(LineaHorario lineaHorario) {
		getLineaHorarios().add(lineaHorario);
		lineaHorario.setHorario(this);

		return lineaHorario;
	}

	public LineaHorario removeLineaHorario(LineaHorario lineaHorario) {
		getLineaHorarios().remove(lineaHorario);
		lineaHorario.setHorario(null);

		return lineaHorario;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setHorario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setHorario(null);

		return usuario;
	}

}