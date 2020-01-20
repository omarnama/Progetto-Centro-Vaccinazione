package it.jac.javadb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="somministrazione")
public class Somministrazione {
	
	@Id
	@Column(name="idvaccinazione")
	private int idvaccinazione;
	
	@Id
	@Column(name="idvaccino")
	private int idvaccino;
	
	@Id
	@Column(name="idpersona")
	private int idpersona;
	
	@Column(name = "creation_time")
	private Date creationTime;
	
	@Column(name = "creation_user", length = 20)
	private String creationUser;
	
	@Column(name = "update_time")
	private Date updateTime;
	
	@Column(name = "update_user", length = 20)
	private String updateUser;

	public int getIdvaccinazione() {
		return idvaccinazione;
	}

	public void setIdvaccinazione(int idvaccinazione) {
		this.idvaccinazione = idvaccinazione;
	}

	public int getIdvaccino() {
		return idvaccino;
	}

	public void setIdvaccino(int idvaccino) {
		this.idvaccino = idvaccino;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "somministrazione [idvaccinazione=" + idvaccinazione + ", idvaccino=" + idvaccino + ", idpersona="
				+ idpersona + ", creationTime=" + creationTime + ", creationUser=" + creationUser + ", updateTime="
				+ updateTime + ", updateUser=" + updateUser + "]";
	}
}
