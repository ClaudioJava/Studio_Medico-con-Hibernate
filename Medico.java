
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Indica che questa classe è un'entità JPA
@Table(name = "medico") // Specifica il nome della tabella nel database
public class Medico {

    @Id // Indica che idMedico è la chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che idMedico è generato automaticamente dal database
    @Column(name = "idMedico") // Specifica il nome della colonna nel database
    private int idMedico; // Campo che rappresenta l'identificatore del medico

    @Column(name = "nome") // Specifica il nome della colonna nel database
    private String nome; // Campo che rappresenta il nome del medico

    @Column(name = "cognome") // Specifica il nome della colonna nel database
    private String cognome; // Campo che rappresenta il cognome del medico

    @Column(name = "specializzazione") // Specifica il nome della colonna nel database
    private String specializzazione; // Campo che rappresenta la specializzazione del medico

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL) // Indica una relazione uno-a-molti con l'entità Visita
    Set<Visita> visite = new HashSet<>(); // Campo che rappresenta un insieme di visite associate al medico

    // Costruttore con tutti i campi
    public Medico(int idMedico, String nome, String cognome, String specializzazione) {
        this.idMedico = idMedico;
        this.nome = nome;
        this.cognome = cognome;
        this.specializzazione = specializzazione;
    }
    
    // Costruttore senza idMedico (usato quando il medico è nuovo e l'id sarà generato automaticamente)
    public Medico(String nome, String cognome, String specializzazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.specializzazione = specializzazione;
    }
    
    // Costruttore vuoto
    public Medico() {
        
    }

    // Metodi getter e setter per tutti i campi
    // Questi metodi permettono di accedere e modificare i valori dei campi della classe

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public Set<Visita> getVisite() {
		return visite;
	}

	public void setVisite(Set<Visita> visite) {
		this.visite = visite;
	}

    // Sovrascrive il metodo toString() per fornire una rappresentazione testuale dell'oggetto Medico
	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nome=" + nome + ", cognome=" + cognome + ", specializzazione="
				+ specializzazione  + "]";
	}
    


}