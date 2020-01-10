package it.jac.javadb.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;


import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.entity.Persona;

public class PersonaService {

	private PersonaDao dao = new PersonaDao();
	
	public List<Persona> findAll() {
		return dao.findAll();
	}

	public void saveItem(Persona persona) {
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
	
	

}
