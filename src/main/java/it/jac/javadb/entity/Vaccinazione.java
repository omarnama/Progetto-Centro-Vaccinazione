package it.jac.javadb.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="vaccinazione")
public class Vaccinazione {
	
	@ManyToMany
	
}
