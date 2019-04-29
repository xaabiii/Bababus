package datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LineaHorarios database table.
 * 
 */
@Entity
@Table(name="LineaHorarios")
@NamedQueries({
@NamedQuery(name="LineaHorario.findAll", query="SELECT l FROM LineaHorario l"),
@NamedQuery(name="LineaHorarioIdLinea", query="SELECT l FROM LineaHorario l WHERE l.linea.idLinea=:idLinea")
})
public class LineaHorario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLineaHorarios;

	//uni-directional many-to-one association to Horario
	@ManyToOne
	@JoinColumn(name="Horario_idHorario")
	private Horario horario;

	//uni-directional many-to-one association to Linea
	@ManyToOne
	@JoinColumn(name="Linea_idLinea")
	private Linea linea;

	public LineaHorario() {
	}

	public int getIdLineaHorarios() {
		return this.idLineaHorarios;
	}

	public void setIdLineaHorarios(int idLineaHorarios) {
		this.idLineaHorarios = idLineaHorarios;
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

}