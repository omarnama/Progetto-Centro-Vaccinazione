package it.jac.javadb.entity;

import java.io.Serializable;
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

import it.jac.javadb.lezione1b.entity.Malattia;
import it.jac.javadb.lezione1b.entity.Vaccinazione;
import it.jac.javadb.lezione1b.entity.Vaccino;

@Entity
@Table(name = "persona")
public class Persona implements Serializable{

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "vaccinato", 
			joinColumns = { @JoinColumn(name = "idpersona", referencedColumnName = "id") }, 
			inverseJoinColumns = { @JoinColumn(name = "idvaccinazione", referencedColumnName = "id") }
			)
	private Set<Vaccinazione> vaccinazioni = new HashSet<Vaccinazione>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "somministrazione", 
			joinColumns = { @JoinColumn(name = "idpersona", referencedColumnName = "id") }, 
			inverseJoinColumns = { @JoinColumn(name = "idvaccinazione", referencedColumnName = "id") }
			)
	private Set<Vaccinazione> vaccinations = new HashSet<Vaccinazione>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "somministrazione", 
			joinColumns = { @JoinColumn(name = "idpersona", referencedColumnName = "id") }, 
			inverseJoinColumns = { @JoinColumn(name = "idvaccino", referencedColumnName = "id") }
			)
	private Set<Vaccino> vaccines = new HashSet<Vaccino>();

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "ammalato",
			joinColumns = { @JoinColumn(name = "idpersona", referencedColumnName="id") }, 
			inverseJoinColumns = { @JoinColumn(name = "idmalattia", referencedColumnName="id") }
			)
	private Set<Malattia> malattie = new HashSet<Malattia>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome", length = 15)
	private String nome;

	@Column(name = "cognome", length = 30)
	private String cognome;

	@Column(name = "data_nascita")
	private Date data_nascita;

	@Column(name = "recapito_telefonico", length = 20)
	private String recapito_telefonico;

	@Column(name = "indirizzo_residenza", length = 40)
	private String indirizzo_residenza;


	@Column(name = "validTo")
	private Date validTo;

	@Column(name = "creation_user", length = 20)
	private String creationUser;

	@Column(name = "creation_time")
	private Date creationTime;

	@Column(name = "update_user", length = 20)
	private String updateUser;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getNascita() {
		return data_nascita;
	}

	public void setNascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getTel() {
		return recapito_telefonico;
	}

	public void setTel(String recapito_telefonico) {
		this.recapito_telefonico = recapito_telefonico;
	}

	public String getIndirizzo() {
		return indirizzo_residenza;
	}

	public void setIndirizzo(String indirizzo_residenza) {
		this.indirizzo_residenza = indirizzo_residenza;
	}

	/*	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}*/

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita= " + data_nascita
				+ ", recapito_telefonico=" + recapito_telefonico + ",  +  indirizzo_residenza=" + indirizzo_residenza
				+ ", creationUser=" + creationUser + ", creationTime=" + creationTime + ", updateUser=" + updateUser
				+ ", updateTime=" + updateTime + "]";
	}

}
