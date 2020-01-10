package it.jac.javadb.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import it.jac.javadb.dao.ItemDao;
import it.jac.javadb.entity.Item;

public class ItemService {

	private ItemDao dao = new ItemDao();
	
	public List<Item> findAll() {
		return dao.findAll();
	}

	public void saveItem(Item item) {
		
		item.setValidFrom(new Date());
		item.setValidTo(DateUtils.addDays(new Date(), 100));
		
		item.setCreationUser("system");
		item.setCreationTime(new Date());
		
		dao.save(item);
	}

}
