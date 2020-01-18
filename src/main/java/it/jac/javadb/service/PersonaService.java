package it.jac.javadb.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.entity.Persona;
//import it.jac.javadb.esercitazione.entity.Documento;

/* Classe Service dove si diachiara la logica della tabella, test connesione al db, inserimento modifica, cancellazione 
 * e aggiornamento rifacendosi alla classe DAO */

public class PersonaService {//implements Iterator <Persona>
	
	private static final Logger log = LogManager.getLogger(PersonaService.class);
	private PersonaDao dao = new PersonaDao();

	/* JDBC
	public void testConnessione() {

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



	public void savePersona(Persona persona) {
		//Da controllare
		/*persona.setValidFrom(new Date());
		  persona.setValidTo(DateUtils.addDays(new Date(), 100));

		 */

		persona.setCreationUser("system");
		persona.setCreationTime(new Date());

		dao.save(persona);
	}

	public void updatePersona(Persona persona) {

		persona.setUpdateUser("system");
		persona.setUpdateTime(new Date());

		dao.update(persona);
	}

	//Parte presa da javadbOrm 28 11 ItemService
	public Persona findPersonaById(int id) {
		return dao.findPersonaById(id);
	}


	//Parte presada DOcumentoService da esercitazione COrretta usa Hoibernate per mettere i 3 metodi sotto
	public List<Persona> findAll() {
		return this.dao.findAll();
	}

	public Persona creaPersona(Scanner s, int id) {//Persona per
		
		String nome, cognome, dataNascita, recapitoTelefonico, indirizzoResidenza;
		
		System.out.println("Crea persona");

		System.out.println("Inserisci il nome:");
		nome = s.nextLine();
		
		System.out.println("Inserisci il cognome:");
		cognome = s.nextLine();
		
		System.out.println("Inserisci la data di nascita:");
		dataNascita = s.nextLine();
		
		System.out.println("Inserisci il recapito telefonico:");
		recapitoTelefonico = s.nextLine();
		
		System.out.println("Inserisci l'indirizzo di residenza:");
		indirizzoResidenza = s.nextLine();
		
		Persona persona = new Persona();//si collega a metodo Set Persona parameters
		persona.setNome(nome);
		persona.setCognome(cognome);
		persona.setDataNascita(dataNascita);//da rivedere in Persona entity ecc...
		persona.setTel(recapitoTelefonico);
		persona.setIndirizzo(indirizzoResidenza);
		persona.setId(6);
		persona.setCreationTime(new Date());
		persona.setCreationUser("admin");
		
		dao.creaPersona(persona);
		
		return persona;	
		
		
		/*mio*/
		/*
		System.out.println("Inseerisci nome Persona:");
		//s.nextLine();
		
		per.setNome(s.nextLine());
		
		per.setCreationTime(new Date());
		per.setCreationUser("system");

		dao.creaPersona(per);
		*/
	}

	public void eliminaPersona(Persona per) {

		dao.eliminaPersona(per);
	}


}
