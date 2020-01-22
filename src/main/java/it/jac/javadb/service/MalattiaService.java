package it.jac.javadb.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import it.jac.javadb.dao.MalattiaDao;
import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.entity.Malattia;

public class MalattiaService {
	private static final Logger log = LogManager.getLogger(MalattiaService.class);
	private static MalattiaDao dao = new MalattiaDao();
	
	Scanner s = new Scanner (System.in);
	
	public Malattia findMalattiaById(int id) {
		return dao.findMalattiaById(id);
	}

	public List<Malattia> findAll() {
		return this.dao.findAll();
	}
	
	
	private Malattia createMalattiaFromUserInput(Scanner scanner) {
		
		Malattia malattia = new Malattia();

		Scanner in = new Scanner(System.in);
		
		System.out.print("Inserire nome della malattia: ");
		malattia.setNome(in.nextLine());

		System.out.print("Inserire il tipo della malattia: ");
		malattia.setTipo(in.nextLine());
		
		malattia.creation_user("Amministratore");
		malattia.setCreation_time(new Date());
		
		dao.save(malattia);
		return malattia;
	}
	
	public Malattia modificaMalattia (Scanner s, int id) throws ParseException {
		String nome, tipo;
		
		System.out.println("Inserisci l'id della malattia da modifcare: " + id);
		
		System.out.println("Inserisci il nome della malattia:");
		nome=s.next();
		
		System.out.println("Inserisci il tipo della malattia:");
		tipo=s.next();
		
		
		Malattia malattia = new Malattia();
		malattia.setNome(nome);
		malattia.setTipo(tipo);
		malattia.setId(id);
		malattia.creation_user("Amministratore");
		malattia.setCreation_time(new Date());
		
		dao.updateMalattia(malattia);
		
		return malattia;
		
		
	}
	
	public void savePersona(Malattia malattia) {

		malattia.creation_user("Amministratore");
		malattia.setCreation_time(new Date());

		dao.save(malattia);
	}
	
	public void removeMalattia(int id, List<Malattia> malattie) {
		Scanner scanner = new Scanner(System.in);
		MalattiaService ps = new MalattiaService();
		ps.eliminaMalttia(id);
		Malattia p = ps.findMalattiaById(id);
	
		for(Malattia malattia: malattie)
		{
			if(malattia.equals(p))
			{
				malattie.remove(malattia);
			}
		}
		
		 Malattia dao = new Malattia();
		    dao.setId(id);
		    Object sessionFactory;
			Session  session=((Object) sessionFactory).getCurrentSession();
				session.delete(dao);
	}
	
	

	public void eliminaMalattia(int id) {

		System.out.println("Elimina malattia n° " + id);

		dao.eliminaMalattia(id);
	}
	

	public void creaMalattia(List<Malattia> malattie) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		MalattiaService ms = new MalattiaService();
		Malattia malattia = ms.createMalattiaFromUserInput(scanner);
		malattie.add(malattia);
		
	}

}
