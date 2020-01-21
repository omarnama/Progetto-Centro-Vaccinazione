/* DA VEDERE FUNZIONAMENTO CON ALTRE CLASSI */
package it.jac.javadb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ammalato")
public class Ammalato implements Serializable{
	
	@Id
	@Column(name="idmalattia")
	private int idmalattia;
	
	@Column(name="idpersona")
	private int idpersona;
	
	@Column(name="creation_user")
	private String creationUser;
	
	@Column(name="update_user")
	private String updateUser;
	
	@Column(name="creation_time")
	private Date creationTime;
	
	@Column(name="update_time")
	private Date updateTime;

	public int getIdmalattia() {
		return idmalattia;
	}

	public void setIdmalattia(int idmalattia) {
		this.idmalattia = idmalattia;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
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
		return "Ammalato [idmalattia=" + idmalattia + ", idpersona=" + idpersona + ", creationUser=" + creationUser
				+ ", updateUser=" + updateUser + ", creationTime=" + creationTime + ", updateTime=" + updateTime + "]";
	}
}


