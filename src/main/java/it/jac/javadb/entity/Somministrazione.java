package it.jac.javadb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="somministrazione")
public class Somministrazione implements Serializable{
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
		result = prime * result + idpersona;
		result = prime * result + idvaccinazione;
		result = prime * result + idvaccino;
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Somministrazione other = (Somministrazione) obj;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (creationUser == null) {
			if (other.creationUser != null)
				return false;
		} else if (!creationUser.equals(other.creationUser))
			return false;
		if (idpersona != other.idpersona)
			return false;
		if (idvaccinazione != other.idvaccinazione)
			return false;
		if (idvaccino != other.idvaccino)
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;
		return true;
	}
}
