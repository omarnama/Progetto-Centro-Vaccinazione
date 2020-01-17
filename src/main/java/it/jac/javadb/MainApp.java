package it.jac.javadb;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.entity.Persona;
import it.jac.javadb.service.PersonaService;
import it.jac.javadb.util.HibernateUtil;
import it.jac.javadb.util.Utils;

public class MainApp {

	private static final Logger log = LogManager.getLogger(MainApp.class);
	
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
}
