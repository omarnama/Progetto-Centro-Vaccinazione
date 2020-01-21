package it.jac.javadb.util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.jac.javadb.entity.Persona;
import it.jac.javadb.dao.PersonaDao;

public class Utils {

	
	public static void stampaLista(List<Persona> list) {
		//List<Item> list
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("             \n");
		for(Persona bean : list) {

			sb
			//.append("|")
			//.append(StringUtils.rightPad(bean.getId(), 10))
			.append("|")
			.append(StringUtils.rightPad(bean.getNome(), 30))
			.append("|")
			.append(StringUtils.rightPad(bean.getTel(), 50))
			.append("|")
			.append(StringUtils.rightPad(bean.getIndirizzo(), 50));
			//.append("|")
			//.append(StringUtils.rightPad(bean.getCreationTime()))
			//.append("|")
			//.append(StringUtils.rightPad(bean.getCreationUser()))
			//.append("|")
			//.append(StringUtils.rightPad(bean.getUpdateTime()))
			//.append("|")
			//.append(StringUtils.rightPad(bean.getUpdateUser()));
			sb.append("\n");
		}
		sb.append("-----------------------------------------------------------");	
		System.out.println(sb.toString());
		
		
	
		
		
}
}

/*
 * 
 * public static List<Persona> persone = new ArrayList<Persona>();
public void stampaListaPersone(List<Persona> list)
{
	PersonaDao dao = new PersonaDao();
	list = dao.findAll();
	System.out.println(list.get(0));
	for(int i = 0; i < list.size() - 1; i++)
	{
		System.out.println(next());
	}
}

private char[] next() {
	// TODO Auto-generated method stub
	return null;
}
		*/

