package it.jac.javadb.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.entity.Persona;
//import it.jac.javadb.esercitazione.entity.Documento;


public class PersonaService {
	
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

	public void creaPersona(Persona per) {

		per.setCreationTime(new Date());
		per.setCreationUser("system");

		dao.creaPersona(per);
	}

	public void eliminaPersona(Persona per) {

		dao.eliminaPersona(per);
	}


}
