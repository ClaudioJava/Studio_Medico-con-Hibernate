
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MedicoRepository {

    // Creazione di una classe Singleton per garantire un'unica istanza di MedicoRepository

    private static MedicoRepository istanza = null; // Dichiarazione dell'istanza statica della classe

    private MedicoRepository() {} // Costruttore privato per impedire la creazione di istanze esterne

    // Metodo per ottenere l'istanza dell'oggetto MedicoRepository in modo sincronizzato
    public static synchronized MedicoRepository getMedicoRepository() {
        if (istanza == null) {
            istanza = new MedicoRepository();
        }
        return istanza;
    }
    
    // Dichiarazione della SessionFactory per la gestione delle operazioni di persistenza con Hibernate
    protected static SessionFactory sf;

    // Metodo per configurare Hibernate e aprire la connessione al database
    public void setup() {
        System.out.println("apro la connessione");
        Configuration cfg = new Configuration(); // Creazione di un'istanza di Configuration di Hibernate
        cfg.addAnnotatedClass(Medico.class); // Aggiunta della classe Medico come entità annotata
        cfg.addAnnotatedClass(Paziente.class); // Aggiunta della classe Paziente come entità annotata
        cfg.addAnnotatedClass(Visita.class); // Aggiunta della classe Visita come entità annotata
        sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory(); // Configurazione e creazione della SessionFactory
    }

    // Metodo per creare un nuovo medico nel database
    public void create(Medico medico) {
        Session sessione = sf.openSession(); // Apertura di una nuova sessione Hibernate
        sessione.beginTransaction(); // Inizio di una transazione
        sessione.persist(medico); // Salvataggio del medico
        sessione.getTransaction().commit(); // Conferma della transazione
        sessione.close(); // Chiusura della sessione
    }

    // Metodo per leggere un medico dal database dato il suo id
    public void read(int id) {
        Session sessione = sf.openSession(); // Apertura di una nuova sessione Hibernate
        Medico medico = sessione.get(Medico.class, id); // Recupero del medico dal database
        System.out.println(medico.toString()); // Stampa del medico recuperato
        sessione.close(); // Chiusura della sessione
    }

    // Metodo per leggere un medico dal database dato il suo id e restituirlo
    public Medico readMedico(int idMedico) {
        Session sessione = sf.openSession(); // Apertura di una nuova sessione Hibernate
        Medico medico = sessione.get(Medico.class, idMedico); // Recupero del medico dal database
        sessione.close(); // Chiusura della sessione
        return medico; // Restituzione del medico recuperato
    }

    // Metodo per aggiornare le informazioni di un medico nel database
    public void update(Medico medico) {
        Session sessione = sf.openSession(); // Apertura di una nuova sessione Hibernate
        sessione.beginTransaction(); // Inizio di una transazione
        sessione.merge(medico); // Aggiornamento del medico
        sessione.getTransaction().commit(); // Conferma della transazione
        sessione.close(); // Chiusura della sessione
    }

    // Metodo per eliminare un medico dal database
    public void delete(Medico medico) {
        Session sessione = sf.openSession(); // Apertura di una nuova sessione Hibernate
        sessione.beginTransaction(); // Inizio di una transazione
        sessione.remove(medico); // Rimozione del medico
        sessione.getTransaction().commit(); // Conferma della transazione
        sessione.close(); // Chiusura della sessione
    }
}

