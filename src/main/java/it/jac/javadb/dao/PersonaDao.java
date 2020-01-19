package it.jac.javadb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import it.jac.javadb.entity.Persona;
//import it.jac.javadb.esercitazione.entity.Documento;
import it.jac.javadb.util.HibernateUtil;

/* Classe DAO si occupa di comunicare con la tabella, e inserimento record e collegamento con Service(dove c'è la logica) */

public class PersonaDao {


	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/progarchsoftware?serverTimezone=UTC", "root", "");
	}


	private static final Logger log = LogManager.getLogger(PersonaDao.class);

	public boolean testConnessione() {

		log.debug("try to open session");

		boolean result = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			if (session != null) {
				result = true;
			}
		}
		log.debug("result " + result);

		return result;
	}

	//Metodi ni riferimento a PersonaService

	/*Metodo crea Persona in Tabella DB da completare con Hibernate SQL*/
	public void creaPersona(Persona persona) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			
			Query<Persona> query = session
					.createQuery("INSERT INTO Persona", Persona.class);

			query.setParameter("Id", 1), query.setParameter(position, value);
			
			List<Persona> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;

			
			
			Transaction tx = session.beginTransaction();

			session.persist(persona);

			tx.commit();
		}
	}

	/*Trova Persona tramite Id*/
	public Persona findPersonaById (int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.find(Persona.class, id);
		}
	} 
	
	public void save(Persona persona) {

		log.debug("try to save item " + persona);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.save(persona);
			log.debug("persona saved");
		}

	}
	
	
	//RENDERE PERSISTENTI LE MODIFICHE E AVVIARE MODIFICA IN DB, (con tx commit forse)

	/*Dao update che viene richiamato da Service nel momento dell'update in db, di campi*/
	public void updatePersona(Persona persona) {//Metodo Update per updatePersona in PersonaService

		log.debug("try to update persona " + persona);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {

				session.update(persona);
				tx.commit();
				log.debug("persona updated");

			} catch(Exception e) {
				log.error("Error updating persona", e);
				tx.rollback();
			}
		}
	}
	
	
	/*da completare con query*/
	public void eliminaPersona(int idPer) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.delete(idPer);

			tx.commit();
		}
	}

	/*Trova tutte le persone*/
	public List<Persona> findAll() {

		log.debug("try to find all entities");

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			NativeQuery<Persona> query = session.createNativeQuery("select * from persona", Persona.class);

			List<Persona> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;
		}
	}



	


	//UPDATE PERSONA CON AGGIONRAMENRO CAMPI DA FARE QUI OPPURE
	//Modificare una persona che c'è già!!
	/*
	 * 
	public void updatePersona(Persona persona) {

		log.debug("try to update persona " + persona);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();
			session.update(persona);
		}

	}
	 */


	



	

}

