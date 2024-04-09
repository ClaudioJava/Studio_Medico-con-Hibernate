import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {


		Scanner scann = new Scanner(System.in);//String
		Scanner scan = new Scanner(System.in);//int
		
		MedicoRepository medicoRepository = MedicoRepository.getMedicoRepository();//mi instanzio le classi Repository per medico, paziente e visita
		PazienteRepository pazienteRepository = PazienteRepository.getPazienteRepository();
		VisitaRepository visitaRepository = VisitaRepository.getVisitaRepository();
		
		//creazione variabili da utilizzare
		int scelta = 0;
		int idMedico = 0;
		int idPaziente = 0;
		int idVisita = 0;
		String nome = "";
		String cognome = "";
		String specializzazione = "";
		String tipoVisita= "";
		String dataNascita = "";
		
		do {
			System.out.println("MEDICO");
			System.out.println("1)Inserisci medico");
			System.out.println("2)Trova medico");
			System.out.println("3)Aggiorna medico");
			System.out.println("4)Elimina medico");
			System.out.println();
			System.out.println("PAZIENTE");
			System.out.println("5)Inserisci paziente");
			System.out.println("6)Trova paziente");
			System.out.println("7)Aggiorna paziente");
			System.out.println("8)Elimina paziente");
			System.out.println();
			System.out.println("VISITA");
			System.out.println("9)Inserisci visita");
			System.out.println("10)Trova visita");
			System.out.println("11)Aggiorna visita");
			System.out.println("12)Elimina visita");
			System.out.println();
			System.out.println("13)ABBANDONA L'APPLICAZIONE");
			System.out.println("******************************");
			scelta = scan.nextInt();
			
			if(scelta == 1) {//Inserimento del medico
				System.out.println("Inserisci nome del Medico:");
				nome = scann.nextLine();
				System.out.println("Inserisci cognome del Medico:");
				cognome = scann.nextLine();
				System.out.println("Inserisci specializzazione del Medico:");
				specializzazione = scann.nextLine();
				Medico m = new Medico(nome,cognome,specializzazione);
				medicoRepository.setup();
				medicoRepository.create(m);
			}if(scelta == 2) {//ricerca di un medico tramite id
				System.out.println("Inserisci id medico da cercare:");
				idMedico = scan.nextInt();
				medicoRepository.setup();
				medicoRepository.read(idMedico);
			}if(scelta == 3) {//update medico
				System.out.println("Inserisci id medico da aggiornare:");
				idMedico = scan.nextInt();
				System.out.println("Inserisci nome del medico:");
				nome = scann.nextLine();
				System.out.println("Inserisci cognome del medico:");
				cognome = scann.nextLine();
				System.out.println("Inserisci Specializzazione del medico:");
				specializzazione = scann.nextLine();
				Medico m = new Medico(idMedico,nome, cognome, specializzazione); //ricorda di mettere tutti i parametri quindi anche id || oppure modifica in modo da passare solo id
				medicoRepository.setup();
				medicoRepository.update(m);
			}if(scelta == 4) {//eliminazione medico
				System.out.println("Inserisci id medico da eliminare:");
				idMedico = scan.nextInt();
				System.out.println("Inserisci nome del medico:");
				nome = scann.nextLine();
				System.out.println("Inserisci cognome del medico:");
				cognome = scann.nextLine();
				System.out.println("Inserisci specializzazione del medico:");
				specializzazione = scan.nextLine();
				Medico m = new Medico(idMedico,nome, cognome,specializzazione);
				medicoRepository.setup();
				medicoRepository.delete(m);
			}if(scelta == 5) {
				System.out.println("Inserisci nome del paziente:");
				nome = scann.nextLine();
				System.out.println("Inserisci cognome del paziente:");
				cognome = scann.nextLine();
				System.out.println("Inserisci data di nascita del paziente:");
				dataNascita = scann.nextLine();
				Paziente p = new Paziente(nome,cognome,dataNascita);
				pazienteRepository.setup();
				pazienteRepository.create(p);
			}if(scelta == 6) {
				System.out.println("Inserisci id paziente da cercare:");
				idPaziente = scan.nextInt();
				pazienteRepository.setup();
				pazienteRepository.read(idPaziente);//ha bisogno dei costruttori vuoti nelle classi per cercare dati nel db e leggerli
			}if(scelta == 7) {
				System.out.println("Inserisci id paziente da aggiornare;");
				idPaziente = scan.nextInt();
				System.out.println("Inserisci nome del paziente:");
				nome = scann.nextLine();
				System.out.println("Inserisci cognome del paziente:");
				cognome = scann.nextLine();
				System.out.println("Inserisci data di nascita del paziente:");
				dataNascita= scann.nextLine();
				Paziente p = new Paziente(idPaziente,nome, cognome, dataNascita);
				pazienteRepository.setup();
				pazienteRepository.update(p);//ricorda di mettere tutti i parametri quindi anche id || oppure modifica in modo da passare solo id
			}if(scelta == 8) {
				System.out.println("Inserisci id paziente da eliminare:");
				idPaziente = scan.nextInt();
				System.out.println("Inserisci nome del paziente:");
				nome = scann.nextLine();
				System.out.println("Inserisci cognome del paziente:");
				cognome = scann.nextLine();
				System.out.println("Inserisci data di nascita del paziente:");
				dataNascita = scan.nextLine();
				Paziente p = new Paziente(idPaziente,nome, cognome,dataNascita);
				pazienteRepository.setup();
				pazienteRepository.delete(p);//ricorda di mettere tutti i parametri quindi anche id
			}if (scelta == 9) {
			    System.out.println("Inserisci tipo di visita:");
			    tipoVisita = scann.nextLine();

			    System.out.println("Inserisci id medico associato alla visita:");
			    idMedico = scan.nextInt();
			    medicoRepository.setup();
			    Medico medico = medicoRepository.readMedico(idMedico); //da riga 133 a riga 136 faccio in modo da leggere l'intero oggetto corrispondente all'id fornito

			    System.out.println("Inserisci id paziente associato alla visita:");
			    idPaziente = scan.nextInt();
			    pazienteRepository.setup();
			    Paziente paziente = pazienteRepository.readPaziente(idPaziente); // lo stesso qui però con il Paziente

			    Visita visita = new Visita(tipoVisita,medico,paziente);
			    visitaRepository.setup();
			    visitaRepository.create(visita);
			}if(scelta == 10) {
				System.out.println("Inserisci id visita da cercare:");
				idVisita = scan.nextInt();
				visitaRepository.setup();
				visitaRepository.read(idVisita);
			}if(scelta == 11) {
				System.out.println("inserisci id visita da modificare:");
				idVisita = scan.nextInt();
				System.out.println("Inserisci tipo di visita:");
			    tipoVisita = scann.nextLine();
			    System.out.println("Inserisci id medico associato alla visita:");
			    idMedico = scan.nextInt();
			    medicoRepository.setup();
			    Medico medico = medicoRepository.readMedico(idMedico);
			    
			    System.out.println("Inserisci id paziente associato alla visita:");
			    idPaziente = scan.nextInt();
			    pazienteRepository.setup();
			    Paziente paziente = pazienteRepository.readPaziente(idPaziente);
			    
			    Visita visita = new Visita(idVisita,tipoVisita,medico,paziente);
			    visitaRepository.setup();
			    visitaRepository.update(visita);
			}if(scelta == 12) {
				System.out.println("Inserisci id visita da eliminare:");
				idVisita = scan.nextInt();
				System.out.println("Inserisci la tipologia della visita:");
				tipoVisita = scann.nextLine();
				
				System.out.println("Inserisci id medico associato alla visita:");
			    idMedico = scan.nextInt();
			    medicoRepository.setup();
			    Medico medico = medicoRepository.readMedico(idMedico);
			    
			    System.out.println("Inserisci id paziente associato alla visita:");
			    idPaziente = scan.nextInt();
			    pazienteRepository.setup();
			    Paziente paziente = pazienteRepository.readPaziente(idPaziente);
			    
				Visita v = new Visita(idVisita,tipoVisita,medico,paziente);
				visitaRepository.setup();
				visitaRepository.delete(v);
			}if(scelta == 13) {
				visitaRepository.setup();
				List<Visita>visita=visitaRepository.readALLl();
				for(Visita visitaIterazione : visita) { 			//leggere tutti i libri presenti
					System.out.println(visitaIterazione);
				}
			}
			
		}while(scelta !=14 );
		
	}
}

