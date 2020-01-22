package it.jac.javadb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import it.jac.javadb.entity.Malattia;
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


	
	/*
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
	*/
	
	/*FORSE DA ELIMINARE SE SALVA OGGETTO SU DB!!!

	//Metodi ni riferimento a PersonaService

	/*Metodo crea Persona in Tabella DB da completare con Hibernate SQL*/
	/*public Persona creaPersona(Persona persona) throws ParseException{
		Scanner n = new Scanner(System.in);
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		
		try  {
			
			tx = session.beginTransaction();
			//Persona persona = new Persona()
			
			Query<Persona> query = session
					.createQuery("INSERT INTO Persona", Persona.class);//id, nome, cognome, data_nascita, recapito_telefonico, indirizzo_residenza, creation_time, creation_user
			System.out.println("Inserisci id persona:");
			query.setParameter(0, persona.getId()); 
			//query.setParameter(position, value)
			System.out.println("Inserisci nome persona:");
			query.setParameter(1, persona.getNome());
			System.out.println("Inserisci cognome persona:");
			query.setParameter(2, persona.getCognome());
			System.out.println("Inserisci data di nascita persona:");
			query.setParameter(3, persona.getData_nascita());
			System.out.println("Inserisci numero di telefono della persona:");
			query.setParameter(4, persona.getRecapito_telefonico());
			System.out.println("Inserisci indirizzo di residenza della persona:");
			query.setParameter(5, persona.getIndirizzo_residenza());
			System.out.println("Inserimento automatico dell'ora alla creazione dell record");
			query.setParameter(6, new java.sql.Timestamp(persona.getCreation_time().getTime()));//.getTime()
			System.out.println("Inserimento automatico dell'utente alla creazione dell record");
			query.setParameter(7, persona.getCreation_user());
			
			//List<Persona> list = query.list();

			log.debug("found [" + query.list() + "] entities");//query.getQueryString()

			
			tx.commit();
			return (Persona) query.list();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return persona;
	      
	      
	      
	      
	   }*/
	

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
		/*
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		*/
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
	
	
	public void eliminaPersona(int id) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.delete(id);

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

