package it.jac.javadb.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import it.jac.javadb.entity.Persona;
import it.jac.javadb.entity.Vaccino;

@Entity
@Table(name="vaccinazione")
public class Vaccinazione {
	
	 @ManyToMany(fetch=FetchType.EAGER)
	    @JoinTable(
	        name = "vaccinato",
	        joinColumns = { @JoinColumn(name = "idvaccinazione", referencedColumnName = "id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idpersona", referencedColumnName = "id") }
	    )
	 private Set<Persona> persone = new HashSet<Persona>();
	 
	 @ManyToMany(fetch=FetchType.LAZY)
	 @JoinTable(
		        name = "somministrazione",
		        joinColumns = { @JoinColumn(name = "idvaccinazione", referencedColumnName = "id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "idvaccino", referencedColumnName = "id") }
		    )
	 private Set<Vaccino> vaccini = new HashSet<Vaccino>();
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	/*Data da controlalre 1*/
	@Column(name = "data")
	private java.sql.Date data;;
	
	@Column(name = "creation_time")
	private Date creationTime;
	
	@Column(name = "update_time")
	private Date updateTime;
	
	@Column(name = "creation_user", length = 20)
	private String creationUser;
	
	@Column(name = "update_user", length = 20)
	private String updateUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/*Data da controlalre 2*/
	public java.sql.Date getData() {
		return data;
	}
	
	/*Data da controlalre 3*/
	public void setData(java.sql.Date data) {
		this.data = data;
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
	
	
	
	@Override
	public String toString() {
		return "id: " + id + ", data: " + data + ", creation time: " + creationTime + ", update time: "
				+ updateTime + ", creation user: " + creationUser + ", update user: " + updateUser + " ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + id;
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
		Vaccinazione other = (Vaccinazione) obj;
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
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
