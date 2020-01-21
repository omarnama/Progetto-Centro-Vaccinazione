package it.jac.javadb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.entity.Persona;
import it.jac.javadb.service.PersonaService;
import it.jac.javadb.util.DaoFactory;

/* Classe Service dove si diachiara la logica della tabella, test connesione al db, inserimento modifica, cancellazione 
 * e aggiornamento rifacendosi alla classe DAO */

public class PersonaService {//implements Iterator <Persona>
	
	private static final Logger log = LogManager.getLogger(PersonaService.class);
	private static PersonaDao dao = new PersonaDao();
	
	//private PersonaDao dao1 = DaoFactory.createPersonaHQLDao();

	/*
	// JDBC
	public void testConnection() {

		log.info("Test connessione");

		boolean test = dao.testConnessione();
		if (test) {

			log.info("Test OK");
		}
	}
	*/
	 
	
	Scanner s = new Scanner (System.in);
	
	/* Prova Hibernate Test Connessione*/
	public void testConnessione() {

		log.info("Test connessione");

		boolean test = dao.testConnessione();
		if (test) {

			log.info("Test OK");
		}
	}


	//Parte presa da javadbOrm 28 11 ItemService
	public Persona findPersonaById(int id) {
		return dao.findPersonaById(id);
	}

	public List<Persona> findAll() {
		return this.dao.findAll();
	}
	
	
	private static Persona createPersonaFromUserInput(Scanner scanner) {
		
		Persona persona = new Persona();

		Scanner in = new Scanner(System.in);
		
		System.out.print("Inserire nome della persona: ");
		persona.setNome(in.nextLine());

		System.out.print("Inserire cognome della persona: ");
		persona.setCognome(in.nextLine());
		
		System.out.println("Inserisci numero telefonico");
		persona.setRecapito_telefonico(in.nextLine());
		
		System.out.println("Inserisci indirizzo di residenza");
		persona.setIndirizzo_residenza(in.nextLine());
		
		dao.save(persona);
		return persona;
	}
	
	public Persona modificaPersona (Scanner s, int id) throws ParseException {
		String nome, cognome, dataNascita, recapitoTelefonico, indirizzoResidenza;
		
		System.out.println("Inserisci l'id della persona da modifcare: " + id);
		
		System.out.println("Inserisci il nome:");
		nome=s.next();
		
		System.out.println("Inserisci il cognome");
		cognome=s.next();
		
		System.out.println("Inserisci data di nascita");
		dataNascita = s.next();
		
		System.out.println("Inserisci numero telefonico");
		recapitoTelefonico = s.next();
		
		System.out.println("Inserisci indirizzo di residenza");
		indirizzoResidenza = s.nextLine();
		
		Persona persona = new Persona();
		persona.setNome(nome);
		persona.setCognome(cognome);
		persona.setDataNascita(dataNascita);
		persona.setRecapito_telefonico(recapitoTelefonico);
		persona.setIndirizzo_residenza(indirizzoResidenza);
		persona.setId(id);
		persona.setCreation_user("Amministratore");
		persona.setCreation_time(new Date());
		
		dao.updatePersona(persona);
		
		return persona;
		
		
	}
	
	public void savePersona(Persona persona) {

		persona.setCreation_user("system");
		persona.setCreation_time(new Date());

		dao.save(persona);
	}
	
	public void removePerson(int id, List<Persona> persone) {
		Scanner scanner = new Scanner(System.in);
		PersonaService ps = new PersonaService();
		ps.eliminaPersona(id);
		Persona p = ps.findPersonaById(id);
	
		for(Persona persona: persone)
		{
			if(persona.equals(p))
			{
				persone.remove(persona);
			}
		}
		
		 Persona dao = new Persona();
		    dao.setId(id);
		    Object sessionFactory;
			Session  session=((Object) sessionFactory).getCurrentSession();
				session.delete(dao);
	}
	
	public void eliminaPersona(int id) {

		System.out.println("Elimina persona n° " + id);

		dao.eliminaPersona(id);
	}
	
	/*Metodo stampaLista che si collega a Utils (stampa lista persone arraylist) */
	public void stampaPersona(int idPer) {

		System.out.println("Stampa lista persone (ArrayList) ");

		Persona persona = dao.findPersonaById(idPer);
		
		it.jac.javadb.util.Utils u = new it.jac.javadb.util.Utils();
		
		//u.stampaListaPersone(Arrays.asList(persona)); vedi util in fondo
	}





	public void creaPersona(List<Persona> persone) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		PersonaService ps = new PersonaService();
		Persona persona = ps.createPersonaFromUserInput(scanner);
		persone.add(persona);
		
	}

}
