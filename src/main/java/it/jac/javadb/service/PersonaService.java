package it.jac.javadb.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import it.jac.javadb.dao.ItemDao;
import it.jac.javadb.entity.Item;

public class PersonaService {

	private PersonaDao dao = new PersonaDao();
	
	public List<Persona> findAll() {
		return dao.findAll();
	}

	public void saveItem(Persona persona) {
		
		persona.setValidFrom(new Date());
		persona.setValidTo(DateUtils.addDays(new Date(), 100));
		
		persona.setCreationUser("system");
		persona.setCreationTime(new Date());
		
		dao.save(persona);
	}

}
