package fr.dawan.yourbank.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2167265006631890102L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	private String nom;
	
	@Column(unique = true)
	private String email;
	
	//L'entité esclave doit avoir une attribut mappedBy qui doit 
	//referencer le champs/attribut qui porte la relation côté maitre
	@OneToMany(mappedBy = "client", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Compte> comptes; //null

	public Client() {
		super();
		comptes = new ArrayList<Compte>();
	}

	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
		comptes = new ArrayList<Compte>();

	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public void addComptes(Compte compte) {
		if(!comptes.contains(compte) && compte != null) {
			this.comptes.add(compte);
		}
	}
	
}
