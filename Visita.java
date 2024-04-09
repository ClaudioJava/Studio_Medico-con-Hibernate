import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVisita")
    private int idVisita;

    @Column(name = "tipoVisita")
    private String tipoVisita;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idPaziente")
    private Paziente paziente;
    
	public Visita(int idVisita, String tipoVisita, Medico medico, Paziente paziente) {
		this.idVisita = idVisita;
		this.tipoVisita = tipoVisita;
		this.medico = medico;
		this.paziente = paziente;
	}
	
	public Visita(String tipoVisita, Medico medico, Paziente paziente) {
		this.tipoVisita = tipoVisita;
		this.medico = medico;
		this.paziente = paziente;
	}
	
	public Visita() {
		
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public String getTipoVisita() {
		return tipoVisita;
	}

	public void setTipoVisita(String tipoVisita) {
		this.tipoVisita = tipoVisita;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	@Override
	public String toString() {
		return "Visita [idVisita=" + idVisita + ", tipoVisita=" + tipoVisita + ", medico=" + medico + ", paziente="
				+ paziente + "]";
	}
    
    

    
}