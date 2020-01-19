package it.jac.javadb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*import it.jac.javadb.dao.PersonaDao;
import it.jac.javadb.dao.VaccinatoDao;
import it.jac.javadb.dao.VaccinazioneDao;*/

@Entity
@Table (name="vaccinato")
public class Vaccinato {
	
	/*
	private static final PersonaDao perdao = new PersonaDao();
	private static final VaccinazioneDao vaccdao = new VaccinazioneDao();
	private static final VaccinatoDao vacctodao = new VaccinatoDao();
	*/
	
	@Id
	@Column(name="idpersona")
	private int idpersona;
	
	@Id
	@Column(name="idvaccinazione")
	private int idvaccinazione;
	
	@Column(name = "creation_user", length = 20)
	private String creationUser;
	
	@Column(name = "update_user", length = 20)
	private String updateUser;
	
	@Column(name = "creation_time")
	private Date creationTime;
	
	@Column(name = "update_time")
	private Date updateTime;

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public int getIdvaccinazione() {
		return idvaccinazione;
	}

	public void setIdvaccinazione(int idvaccinazione) {
		this.idvaccinazione = idvaccinazione;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Vaccinato [idpersona=" + idpersona + ", idvaccinazione=" + idvaccinazione + ", creationUser="
				+ creationUser + ", updateUser=" + updateUser + ", creationTime=" + creationTime + ", updateTime="
				+ updateTime + "]";
	}
	
}
