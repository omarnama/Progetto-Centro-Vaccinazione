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

import it.jac.javadb.entity.Malattia;
import it.jac.javadb.entity.Persona;
import it.jac.javadb.entity.Vaccinazione;
import it.jac.javadb.entity.Vaccino;

@Entity
@Table(name = "vaccino")
public class Vaccino {
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		        name = "somministrazione",
		        joinColumns = { @JoinColumn(name = "idvaccino", referencedColumnName = "id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "idvaccinazione", referencedColumnName = "id") }
		    )
	private Set<Vaccinazione> vaccinaz = new HashSet<Vaccinazione>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		        name = "somministrazione",
		        joinColumns = { @JoinColumn(name = "idvaccino", referencedColumnName = "id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "idpersona", referencedColumnName = "id") }
		    )
	private Set<Persona> persone = new HashSet<Persona>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		        name = "prevenzione",
		        joinColumns = { @JoinColumn(name = "idvaccino", referencedColumnName = "id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "idmalattia", referencedColumnName = "id") }
		    )
	private Set<Malattia> malattie = new HashSet<Malattia>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; 
	
	@Column(name = "livello_rischio")
	private int livelloRischio;
	
	@Column(name = "anno")
	private int anno;
	
	@Column(name = "malattie_prevenute", length = 150)
	private String malattiePrevenute;
	
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
	
	public int getLivelloRischio() {
		return livelloRischio;
	}
	
	public void setLivelloRischio(int livelloRischio) {
		this.livelloRischio = livelloRischio;
	}
	
	public int getAnno() {
		return anno;
	}
	
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	public String getMalattiePrevenute() {
		return malattiePrevenute;
	}
	
	public void setMalattiePrevenute(String malattiePrevenute) {
		this.malattiePrevenute = malattiePrevenute;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((String.valueOf(livelloRischio) == null) ? 0 : String.valueOf(livelloRischio).hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
		result = prime * result + ((String.valueOf(anno) == null) ? 0 : String.valueOf(anno).hashCode());
		result = prime * result + id;
		result = prime * result + ((malattiePrevenute == null) ? 0 : malattiePrevenute.hashCode());
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
		Vaccino other = (Vaccino) obj;
		if (String.valueOf(livelloRischio) == null) {
			if (String.valueOf(other.livelloRischio) != null)
				return false;
		} else if (!(livelloRischio == other.livelloRischio))
			return false;
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
		if (String.valueOf(anno) == null) {
			if (String.valueOf(other.anno) != null)
				return false;
		} else if (!(anno == other.anno))
			return false;
		if (id != other.id)
			return false;
		if (malattiePrevenute == null) {
			if (other.malattiePrevenute != null)
				return false;
		} 
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

	@Override
	public String toString() {
		return "id: " + id + ", livello rischio: " + livelloRischio + ", anno: " + anno + ", malattie prevenibili: "
				+ malattiePrevenute + ", creation time: " + creationTime + ", update time: " + updateTime
				+ ", creation user: " + creationUser + ", update user: " + updateUser + " ";
	}
}
