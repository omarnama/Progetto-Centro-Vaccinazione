package it.jac.javadb.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import it.jac.javadb.entity.Item;
import it.jac.javadb.util.HibernateUtil;

public class ItemDao {

	private static final Logger log = LogManager.getLogger(ItemDao.class);
	
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

	public List<Item> findAll() {

		log.debug("try to find all entities");
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			NativeQuery<Item> query = session.createNativeQuery("select * from item", Item.class);
	
			List<Item> list = query.list();
			
			log.debug("found [" + list.size() + "] entities");
			
			return list;
		}
	}

	public void save(Item item) {

		log.debug("try to save item " + item);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.save(item);
			log.debug("item saved");
		}
		
	}
	
	public void updateItem(Item item) {

		log.debug("try to update item " + item);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();
			session.update(item);
		}
		
	}

}
