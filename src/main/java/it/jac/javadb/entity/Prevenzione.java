/* CONTROLLA SE DA USARE IN BASE A PPTX */

package it.jac.javadb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="prevenzione")
public class Prevenzione implements Serializable{
	
	@Id
	@Column(name="idmalattia")
	private int idmalattia;
	
	@Id
	@Column(name="idvaccino")
	private int idvaccino;
	
	@Column(name = "creation_user", length = 20)
	private String creationUser;
	
	@Column(name = "update_user", length = 20)
	private String updateUser;
	
	@Column(name = "creation_time")
	private Date creationTime;
	
	@Column(name = "update_time")
	private Date updateTime;

	public int getIdmalattia() {
		return idmalattia;
	}

	public void setIdmalattia(int idmalattia) {
		this.idmalattia = idmalattia;
	}

	public int getIdvaccino() {
		return idvaccino;
	}

	public void setIdvaccino(int idvaccino) {
		this.idvaccino = idvaccino;
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
		return "Prevenzione [idmalattia=" + idmalattia + ", idvaccino=" + idvaccino + ", creationUser=" + creationUser
				+ ", updateUser=" + updateUser + ", creationTime=" + creationTime + ", updateTime=" + updateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
		result = prime * result + idmalattia;
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
		Prevenzione other = (Prevenzione) obj;
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
		if (idmalattia != other.idmalattia)
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
