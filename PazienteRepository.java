

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PazienteRepository{

	//CREAZIONE CLASSE SINGLENTON
		private static PazienteRepository istanza = null;
		
		private PazienteRepository() {}

		public static synchronized PazienteRepository getPazienteRepository() {
			if (istanza == null) {
			istanza = new PazienteRepository();
			}
		return istanza;
		}
		
		protected static SessionFactory sf; // importa hibernate
		
		public void setup() {
			System.out.println("apro la connessione");
			Configuration cfg = new Configuration();// importa hibernate
			cfg.addAnnotatedClass(Medico.class);
			cfg.addAnnotatedClass(Paziente.class);
			cfg.addAnnotatedClass(Visita.class);
			sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		}


		public void create(Paziente paziente) {
			Session sessione = sf.openSession();
			sessione.beginTransaction();
			sessione.persist(paziente);
			sessione.getTransaction().commit();;
			sessione.close();				
		}

		
		public void read(int id) {
			Session sessione = sf.openSession();
			Paziente paziente = sessione.get(Paziente.class, id);
			System.out.println(paziente.toString());
			sessione.close();				
		}
		
		//read però ritorna l'oggetto Paziente Per la gestione delle visite
		public Paziente readPaziente(int idPaziente) {
		    Session sessione = sf.openSession();
		    Paziente paziente = sessione.get(Paziente.class, idPaziente);
		    sessione.close();
		    return paziente;
		}


		
		public void update(Paziente paziente) {
			Session sessione = sf.openSession();
			sessione.beginTransaction();
			sessione.merge(paziente);
			sessione.getTransaction().commit();
			sessione.close();	
			
		}
		
		public void delete(Paziente paziente) {
			Session sessione = sf.openSession();
			sessione.beginTransaction();
			sessione.remove(paziente);
			sessione.getTransaction().commit();
			sessione.close();
		}
		
}

