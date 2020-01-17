package it.jac.javadb.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


import it.jac.javadb.entity.Persona;
import it.jac.javadb.dao.PersonaDao;

public class Utils {

	public static List<Persona> persone = new ArrayList<Persona>();
		
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
		
}
		/*
		StringBuilder sb = new StringBuilder();
		
		sb.append("-----------------------------------------------------------\n");//per sintassi vedi Utils di javadbOrm 05 12
		for(Persona bean : list) {

			sb
			.append("|")
			.append(StringUtils.rightPad(bean.getId(), 15))
			.append("|")
			.append(StringUtils.rightPad(bean.getName(), 30))
			.append("|")
			.append(StringUtils.rightPad(bean.getDescription(), 50));
			sb.append("\n");
		}
		sb.append("-----------------------------------------------------------");	
		System.out.println(sb.toString());
		*/
		
	


