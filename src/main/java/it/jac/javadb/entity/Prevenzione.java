/* CONTROLLA SE DA USARE IN BASE A PPTX */

package it.jac.javadb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="prevenzione")
public class Prevenzione {
	
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

}
