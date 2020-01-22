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

		@Column(name = "tipo", length = 30)
		private String tipo;
		
		@Column(name = "nome", length = 20)
		private String nome;
		
		@Column(name = "creation_user", length = 20)
		private String creation_user;
		
		@Column(name = "update_user", length = 20)
		private String update_user;
		
		@Column(name = "creation_time")
		private Date creation_time;
		
		@Column(name = "update_time")
		private Date update_time;
		
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
			return creation_user;
		}
		
		public void creation_user(String creation_user) {
			this.creation_user = creation_user;
		}
		
		public String getUpdate_user() {
			return update_user;
		}
		
		public void setUpdate_user(String updateUser) {
			this.update_user = updateUser;
		}
		
		public Date getCreation_time() {
			return creation_time;
		}
		
		public void setCreation_time(Date creationTime) {
			this.creation_time = creationTime;
		}
		
		public Date getUpdate_time() {
			return update_time;
		}
		
		public void setUpdate_time(Date updateTime) {
			this.update_time = updateTime;
		}
		
		@ManyToMany(fetch = FetchType.LAZY, mappedBy = "malattia")
		public Set<Persona> getPersone() {
			return this.persone;
		}
		
		public void setPersone(Set<Persona> persone) {
			this.persone = persone;
		}
		
		@Override
		public String toString() {
			return "[id=" + id + ", tipo=" + tipo + ", nome=" + nome + ", creation_user=" + creation_user
					+ ", update_user=" + update_user + ", creation_time=" + creation_time + ", update_time=" + update_time
					+ "]";
		}
		
		//metodo int hashCode
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((creation_time == null) ? 0 : creation_time.hashCode());
			result = prime * result + ((creation_user == null) ? 0 : creation_user.hashCode());
			result = prime * result + id;
			result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
			result = prime * result + ((update_time == null) ? 0 : update_time.hashCode());
			result = prime * result + ((update_user == null) ? 0 : update_user.hashCode());
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
			if (creation_time == null) {
				if (other.creation_time != null)
					return false;
			} else if (!creation_time.equals(other.creation_time))
				return false;
			if (creation_user == null) {
				if (other.creation_user != null)
					return false;
			} else if (!creation_user.equals(other.creation_user))
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
			if (update_time == null) {
				if (other.update_time != null)
					return false;
			} else if (!update_time.equals(other.update_time))
				return false;
			if (update_user == null) {
				if (other.update_user != null)
					return false;
			} else if (!update_user.equals(other.update_user))
				return false;
			return true;
		}
		
		

		
		//ricontrolla secondo tabella e file word


/* da completare */

}
