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
	
	// 1Data da fpormattare bene
	@Column(name = "data_nascita")
	private String dataNascita;

	@Column(name = "recapito_telefonico", length = 20)
	private String recapitoTelefonico;

	@Column(name = "indirizzo_residenza", length = 40)
	private String indirizzoResidenza;

/*
	@Column(name = "validTo")
	private Date validTo;
*/
	
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
	
	// 2 Data da fpormattare bene
	public String getNascita() {
		return dataNascita;
	}
	
	// 3  Data da fpormattare bene
	public void setNascita(String data_nascita) {
		this.dataNascita = data_nascita;
	}

	public String getTel() {
		return recapitoTelefonico;
	}

	public void setTel(String recapito_telefonico) {
		this.recapitoTelefonico = recapito_telefonico;
	}

	public String getIndirizzo() {
		return indirizzoResidenza;
	}

	public void setIndirizzo(String indirizzo_residenza) {
		this.indirizzoResidenza = indirizzo_residenza;
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
	
	/*Costruttore Set persona parameters*/
	public Persona(int id, String nome, String cognome, String data_Nascita, String recapitoTelefonico, String indirizzoResidenza) {
		
		this.setId(id);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setNascita(data_Nascita);// 4 Data da fpormattare bene
		this.setTel(recapitoTelefonico);
		this.setIndirizzo(indirizzoResidenza);
		 
		
		
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
		return recapitoTelefonico;
	}

	public void setRecapitoTelefonico(String recapitoTelefonico) {
		this.recapitoTelefonico = recapitoTelefonico;
	}

	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}

	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}

	public java.sql.Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) throws ParseException {
		this.dataNascita = java.sql.Date.valueOf(dataNascita);
	}
	*/
	
	
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	// 5 Data da fpormattare bene
	public void setDataNascita(String data_nascita2) {
		
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		data_nascita2=formatter.format(data_nascita2);
	}

	@Override
	//da rivedere, dovrebbe andare bene Ven 17/01 15:48 on IoT Lesson
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data_nascita= " + dataNascita
				+ ", recapito_telefonico=" + recapitoTelefonico + ",  +  indirizzo_residenza=" + indirizzoResidenza
				+ ", creationUser=" + creationUser + ", creationTime=" + creationTime + ", updateUser=" + updateUser
				+ ", updateTime=" + updateTime + "]";
	}
	
	



}
