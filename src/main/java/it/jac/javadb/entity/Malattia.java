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
		
		//metodo int hashCode
		
		
		//bollean equals

		
		//ricontrolla secondo tabella e file word
		@Override
		public String toString() {
			return "id: " + id + ", nome: " + nome + ", tipo: " + tipo + ", creation time: " + creationTime +
		}

/* da completare */

}
