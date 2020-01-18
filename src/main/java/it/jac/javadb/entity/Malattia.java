package it.jac.javadb.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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


@Entity
@Table(name = "malattia")
public class Malattia {
	@ManyToMany(cascade=CascadeType.ALL, targetEntity = Persona.class, fetch = FetchType.LAZY)
	@JoinTable(
			name = "ammalato",
			joinColumns = { @JoinColumn(name = "idmalattia", referencedColumnName = "id") },
			inverseJoinColumns = {@JoinColumn(name = "idpersona", referencedColumnName = "id") }
			)
	private Set<Persona> persone = new HashSet<Persona>();
	
		@ManyToMany(fetch=FetchType.LAZY)
		@JoinTable(
			        name = "prevenzione",
			        joinColumns = { @JoinColumn(name = "idmalattia", referencedColumnName = "id") }, 
			        inverseJoinColumns = { @JoinColumn(name = "idvaccino", referencedColumnName = "id") }
			    )
	private Set<Vaccino> vaccini = new HashSet<Vaccino>();

		
		//ricontrolla secondo tabella e file word
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		
		@Override
		public String toString() {
			return "[id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", creationUser=" + creationUser
					+ ", updateUser=" + updateUser + ", creationTime=" + creationTime + ", updateTime=" + updateTime
					+ "]";
		}

		@Column(name = "tipo", length = 30)
		private String tipo;
		
		@Column(name = "nome", length = 20)
		private String nome;
		
		@Column(name = "creation_user", length = 20)
		private String creationUser;
		
		@Column(name = "update_user", length = 20)
		private String updateUser;
		
		@Column(name = "creation_time")
		private Date creationTime;
		
		@Column(name = "update_time")
		private Date updateTime;
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getTipo() {
			return tipo;
		}
		
		public void setTipo(String tipo) {
			this.tipo = tipo;
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
		
		@ManyToMany(fetch = FetchType.LAZY, mappedBy = "malattia")
		public Set<Persona> getPersone() {
			return this.persone;
		}
		
		public void setPersone(Set<Persona> persone) {
			this.persone = persone;
		}
		
		//metodo int hashCode
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
			result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
			result = prime * result + id;
			result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
			result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
			result = prime * result + ((updateUser == null) ? 0 : updateUser.hashCode());
			return result;
		}
		
		//bollean equals
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Malattia other = (Malattia) obj;
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
			if (id != other.id)
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (tipo == null) {
				if (other.tipo != null)
					return false;
			} else if (!tipo.equals(other.tipo))
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
		
		

		
		//ricontrolla secondo tabella e file word


/* da completare */

}
