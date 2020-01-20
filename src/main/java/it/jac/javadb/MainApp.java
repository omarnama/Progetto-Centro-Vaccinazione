package it.jac.javadb;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.entity.Persona;
import it.jac.javadb.lezione1b.MainApp2;
import it.jac.javadb.lezione1b.dao.AmmalatoDao;
import it.jac.javadb.lezione1b.entity.Malattia;
import it.jac.javadb.lezione1b.entity.Vaccinazione;
import it.jac.javadb.lezione1b.entity.Vaccino;
import it.jac.javadb.lezione1b.service.MalattiaService;
import it.jac.javadb.lezione1b.service.VaccinatoService;
import it.jac.javadb.lezione1b.service.VaccinoService;
import it.jac.javadb.service.PersonaService;
import it.jac.javadb.util.HibernateUtil;
import it.jac.javadb.util.Utils;

public class MainApp {

	private static final Logger log = LogManager.getLogger(MainApp.class);
	
	public static MainApp mn = new MainApp();

	public static final int ESCI = 0;

	public static final int STAMPALISTA = 1;

	public static final int AGGIUNGI = 2;

	public static final int MODIFICA = 3;

	public static final int ELIMINA = 4;

	public static final int CERCA = 5;
	public static String s;

	public static int position = -1;

	public static PersonaDao pd = new PersonaDao();

	public static PersonaService ps = new PersonaService();

	public static List<Persona> persone = new ArrayList<Persona>(10);
	/*public static List<Malattia> malattie = new ArrayList<Malattia>(10);
	public static List<Vaccino> vaccini = new ArrayList<Vaccino>(10);
	public static List<Vaccinazione> vaccinazioni = new ArrayList<Vaccinazione>(10);*/
	static final private Scanner in = new Scanner(System.in);
	
	/*Parte progetto SF*/
	
	public static void main(String[] args) throws ParseException, InputMismatchException {
		System.out.println("App Started");
		Scanner scanner = new Scanner(System.in);
		PersonaService ps = new PersonaService();

		gestisciScelta();
		VaccinatoService vs = new VaccinatoService();
		vs.getVaccinazioni();
		scanner.nextLine();
		AmmalatoDao dao = new AmmalatoDao();
		dao.getMediaPersoneAmmalate();
		scanner.nextLine();
		VaccinoService vcs = new VaccinoService();
		vcs.getMalattiePrevenute();
		scanner.nextLine();
		vcs.getVaccinazioniEffettuate();
		scanner.nextLine();
		MalattiaService ms = new MalattiaService();
		ms.getPersoneAmmalate();
		
	}

	public static boolean hasNext(List<?> list) {
		return position < list.size();
	}

	public void remove() {

	}

	private static int getChoice() {
		printMenu();
		return in.nextInt();
	}

	public static void gestisciScelta() throws ParseException {
		System.out.println("Inserisci la categoria di dati che vuoi gestire: ");
		String s = in.nextLine();
		Scanner in = new Scanner(System.in);
		int scelta = 0;
		Utils u = new Utils();

		if (s.equals("persone")) {

			do {
				scelta = getChoice();

				PersonaService ps = new PersonaService();
				PersonaDao dao = new PersonaDao();

				switch (scelta) {
				case STAMPALISTA: {
					persone = dao.findAll();

					for (int i = -1; i < persone.size() - 1; i++) {
						if (hasNext(persone)) {
							MainApp mn = new MainApp();
							System.out.println(mn.next(persone));
						} else {
							System.out.println("Lista terminata");
						}
					}

					break;
				}

				case AGGIUNGI: {
					ps.creaPersona(persone);
					break;
				}

				case MODIFICA: {
					persone = pd.findAll();
					System.out.println("Inserisci l'id della persona da modificare: ");
					int id = in.nextInt();
					Persona p = ps.modificaPersona(in, id);
					persone.set(id - 1, p);
					break;
				}

				case ELIMINA: {
					System.out.println("Inserisci l'id della persona da eliminare: ");
					int id = in.nextInt();
					ps.removePerson(id, persone);
					break;
				}

				case CERCA: {
					System.out.println("Inserisci l'id della persona da cercare: ");
					int id = in.nextInt();
					Persona p = ps.findPersonById(id);
					System.out.println(p);
					break;
				}

				default: {
					System.out.println("Scelta non valida ");
					break;
				}
				}
			}
	
	
	
	
			public Object next(List<?> list) {
				position++;
				Object o = list.get(position);
				return o != null ? o : null;
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*mio mainapp progetto archsoft data 20 01 2020*/
	public static void main(String[] args) {
		
		log.info("App Started");

		HibernateUtil.getSessionFactory();
		
		do {

			System.out.println("Scegliere la funzione: ");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			
			PersonaService dao = new PersonaService();
			PersonaDao dao1 = new PersonaDao();
			
			switch (s) {
			case "1": {

				System.out.println("Test connessione");
				
				
				boolean test = dao1.testConnessione();
				if (test) {
				
					log.info("Test OK");
				}
				
				break;
			}
			case "2": {

				System.out.println("Stampa lista");

				PersonaService service = new PersonaService();
				List<Persona> list = service.findAll();
				
				Utils.stampaLista(list);
				break;
			}
			case "3": {

				System.out.println("Aggiungi articolo alla lista");

				Item item = createItemFromUserInput();
				
				ItemService service = new ItemService();
				service.saveItem(item);
				
				break;
			}
			case "4": {

				System.out.println("Modifica articolo alla lista");
				
// 				TODO implementare
				
				break;
			}
			case "5": {

				System.out.println("Elimina articolo alla lista");

// 				TODO implementare
				
				break;
			}
			default: {

				System.out.println("Scelta non gestita, l'applicazione termina");

				log.info("App finished");
				return;
			}
			}

		} while (true);

	}

	
	/*
	private static Item createItemFromUserInput() {

		Item item = new Item();

		Scanner in = new Scanner(System.in);
		
		System.out.print("Inserire codice articolo: ");
		item.setCode(in.nextLine());

		System.out.print("Inserire nome articolo: ");
		item.setName(in.nextLine());

		System.out.print("Inserire descrizione articolo: ");
		item.setDescription(in.nextLine());

		System.out.print("Inserire descrizione articolo (estesa): ");
		item.setLongDescription(in.nextLine());

		return item;
	}
	*/
}
