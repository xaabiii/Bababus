package datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LineaParadas database table.
 * 
 */
@Entity
@Table(name="LineaParadas")
@NamedQueries({
@NamedQuery(name="LineaParada.findAll", query="SELECT l FROM LineaParada l"),
@NamedQuery(name="LineaParadaIdLinea", query="SELECT l FROM LineaParada l WHERE l.linea.idLinea=:idLinea")
})
public class LineaParada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLineaParadas;

	private String paradaSolicitada;

	//uni-directional many-to-one association to Linea
	@ManyToOne
	@JoinColumn(name="Linea_idLinea")
	private Linea linea;

	//uni-directional many-to-one association to Parada
	@ManyToOne
	@JoinColumn(name="Parada_idParada")
	private Parada parada;

	public LineaParada() {
	}

	public int getIdLineaParadas() {
		return this.idLineaParadas;
	}

	public void setIdLineaParadas(int idLineaParadas) {
		this.idLineaParadas = idLineaParadas;
	}

	public String getParadaSolicitada() {
		return this.paradaSolicitada;
	}

	public void setParadaSolicitada(String paradaSolicitada) {
		this.paradaSolicitada = paradaSolicitada;
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