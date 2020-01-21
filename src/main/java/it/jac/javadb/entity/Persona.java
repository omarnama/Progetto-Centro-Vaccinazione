package it.jac.javadb.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/*
 * import it.jac.javadb.lezione1b.entity.Malattia;
import it.jac.javadb.lezione1b.entity.Vaccinazione;
import it.jac.javadb.lezione1b.entity.Vaccino;
 */

/* Classe Entita si occupa di dichiarare la tabella ele sue relazioni con le altre e i suoi campi, GET e SET, il metodo toString
 * e metodo hashCode ecc... vedi ....  */

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
	
	/*
	// 1Data da fpormattare bene
	@Column(name = "data_nascita")
	private java.sql.Date data_nascita;
	*/
	@Column(name = "data_nascita")
	private Date data_nascita;

	@Column(name = "recapito_telefonico", length = 20)
	private String recapito_telefonico;

	@Column(name = "indirizzo_residenza", length = 40)
	private String indirizzo_residenza;

/*
	@Column(name = "validTo")
	private Date validTo;
*/
	@Column(name = "creation_time")
	private Date creation_time;

	
	@Column(name = "creation_user", length = 20)
	private String creation_user;

	
	@Column(name = "update_user", length = 20)
	private String update_user;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRecapito_telefonico() {
		return recapito_telefonico;
	}

	public void setRecapito_telefonico(String recapitoTelefonico) {
		this.recapito_telefonico = recapitoTelefonico;
	}

	public String getIndirizzo_residenza() {
		return indirizzo_residenza;
	}

	public void setIndirizzo_residenza(String indirizzoResidenza) {
		this.indirizzo_residenza = indirizzoResidenza;
	}

	public Date getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(Date creationTime) {
		this.creation_time = creationTime;
	}

	public String getCreation_user() {
		return creation_user;
	}

	public void setCreation_user(String creationUser) {
		this.creation_user = creationUser;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String updateUser) {
		this.update_user = updateUser;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date updateTime) {
		this.update_time = updateTime;
	}
	/*
	public void setDataNascita(java.sql.Date data_nascita) {
		this.dataNascita = data_nascita;
	}
	*/
	
	

	/*Costruttore Set persona parameters*/
	public Persona(int id, String nome, String cognome, String dataNascita, String recapitoTelefonico, String indirizzoResidenza) throws ParseException {
		
		this.setId(id);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setDataNascita(dataNascita);//this.setDataNascita(data_nascita); 4 Data da fpormattare bene
		this.setRecapito_telefonico(recapitoTelefonico);
		this.setIndirizzo_residenza(indirizzoResidenza);
		 
		
		
	}
	
	public Date getData_nascita() {
		return data_nascita;
	}

	public String setDataNascita(String dataNascita) throws ParseException {
		return dataNascita;
	}
	
	
	
	
	/*from S Persona - diviso in 2 parti metà sotto metodo Persona (usato per creare persona in PersonaDao) e meta infondo*/
	/*
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRecapitoTelefonico() {
		return recapito_telefonico;
	}

	public void setRecapitoTelefonico(String recapito_telefonico) {
		this.recapitoTelefonico = recapito_telefonico;
	}

	public String getIndirizzoResidenza() {
		return indirizzo_residenza;
	}

	public void setIndirizzoResidenza(String indirizzo_residenza) {
		this.indirizzoResidenza = indirizzo_residenza;
	}

	public java.sql.Date getDataNascita() {
		return data_nascita;
	}

	public void setDataNascita(String data_nascita) throws ParseException {
		this.dataNascita = java.sql.Date.valueOf(data_nascita);
	}
	*/
	
	
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	//da rivedere, dovrebbe andare bene Ven 17/01 15:48 on IoT Lesson
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita= " + data_nascita
				+ ", recapito_telefonico=" + recapito_telefonico + ",  +  indirizzo_residenza=" + indirizzo_residenza
				+ ", creation_user=" + creation_user + ", creation_time=" + creation_time + ", update_user=" + update_user
				+ ", update_time=" + update_time + "]";
	}

	public Date setData_nascita(Date dataNascita) {
		// TODO Auto-generated method stub
		return dataNascita;
	}
	
	



}
