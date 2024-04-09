


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VisitaRepository{

	//CREAZIONE CLASSE SINGLENTON
		private static VisitaRepository istanza = null;
		
		private VisitaRepository() {}

		public static synchronized VisitaRepository getVisitaRepository() {
			if (istanza == null) {
			istanza = new VisitaRepository();
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


		public void create(Visita visita) {
			Session sessione = sf.openSession();
			sessione.beginTransaction();
			sessione.persist(visita);
			sessione.getTransaction().commit();;
			sessione.close();				
		}

		
		public void read(int id) {
			Session sessione = sf.openSession();
			Visita visita = sessione.get(Visita.class, id);
			System.out.println(visita.toString());
			sessione.close();				
		}

		
		public void update(Visita visita) {
			Session sessione = sf.openSession();
			sessione.beginTransaction();
			sessione.merge(visita);
			sessione.getTransaction().commit();
			sessione.close();	
			
		}
		
		public void delete(Visita visita) {
			Session sessione = sf.openSession();
			sessione.beginTransaction();
			sessione.remove(visita);
			sessione.getTransaction().commit();
			sessione.close();
		}
		
		public List<Visita> readALLl() {
			Session sessione = sf.openSession();
			String hql = "FROM Visita";//passaggio di classe Visita
			Query<Visita> query = sessione.createQuery(hql,Visita.class);//import otg.hibernate
			return query.list();
		}
		
		
}

