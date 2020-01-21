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

import it.jac.javadb.entity.Malattia;
import it.jac.javadb.entity.Persona;
import it.jac.javadb.util.HibernateUtil;

public class MalattiaDao {
	


	private static final Logger log = LogManager.getLogger(MalattiaDao.class);

	/*Trova Persona tramite Id*/
	public Malattia findPersonaById (int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.find(Malattia.class, id);
		}
	} 
	
	public void save(Malattia malattia) {

		log.debug("try to save item " + malattia);

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.save(malattia);
			log.debug("malattia saved");
		}

	}
	
	
	public void updateMalattia(Malattia malattia) {//Metodo Update per updatePersona in PersonaService
		/*
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		*/
		log.debug("try to update malattia " + malattia);
		

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			try {
				
				session.update(malattia);
				tx.commit();
				log.debug("persona updated");

			} catch(Exception e) {
				log.error("Error updating persona", e);
				tx.rollback();
			}
		}
	}
	
	
	public void eliminaMalattia(int id) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.delete(id);

			tx.commit();
		}
	}

	/*Trova tutte le malattie*/
	public List<Malattia> findAll() {

		log.debug("try to find all entities");

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			NativeQuery<Malattia> query = session.createNativeQuery("select * from malattia", Malattia.class);

			List<Malattia> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;
		}
	}	
}
