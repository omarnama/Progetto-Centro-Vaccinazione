package it.jac.javadb.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import it.jac.javadb.entity.Item;
import it.jac.javadb.util.HibernateUtil;

public class PersonaDao {

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

	public List<Persona> findAll() {

		log.debug("try to find all entities");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			NativeQuery<Persona> query = session.createNativeQuery("select * from persona", Persona.class);
	
			List<Persona> list = query.list();
			
			log.debug("found [" + list.size() + "] entities");
			
			return list;
		}
	}

	public void save(Persona persona) {

		log.debug("try to save item " + persona);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.save(persona);
			log.debug("persona saved");
		}
		
	}
	
	public void updateItem(Persona persona) {

		log.debug("try to update persona " + persona);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();
			session.update(persona);
		}
		
	}

}
