package datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Parada database table.
 * 
 */
@Entity
@NamedQuery(name="Parada.findAll", query="SELECT p FROM Parada p")
public class Parada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idParada;

	private String coordenadas;

	private String nombreParada;

	//bi-directional many-to-one association to LineaParada
	@OneToMany(mappedBy="parada")
	private List<LineaParada> lineaParadas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="parada")
	private List<Usuario> usuarios;

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

	public List<LineaParada> getLineaParadas() {
		return this.lineaParadas;
	}

	public void setLineaParadas(List<LineaParada> lineaParadas) {
		this.lineaParadas = lineaParadas;
	}

	public LineaParada addLineaParada(LineaParada lineaParada) {
		getLineaParadas().add(lineaParada);
		lineaParada.setParada(this);

		return lineaParada;
	}

	public LineaParada removeLineaParada(LineaParada lineaParada) {
		getLineaParadas().remove(lineaParada);
		lineaParada.setParada(null);

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
		usuario.setParada(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setParada(null);

		return usuario;
	}

}