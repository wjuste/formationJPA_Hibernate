package fr.dawan.formationjpa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Trainer")
public class Formateur extends DbObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2562091617464968845L;

	//unique : permet d'empecher les doublons sur cet attribut
	@Column(name="t_matricule", unique = true)
	private String matricule;
	
	@Column(name="t_lastname", length = 100, nullable = false)
	private String nom;
	
	@Column(name= "t_firstname")
	private String prenom;
	
	@Column(name="t_isDawan")
	private boolean estInterne;
	
	/*
	 * n -> n
	 * ManyToMany
	 */
	@ManyToMany
	private Set<Formation> competences = new HashSet<Formation>();

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean isEstInterne() {
		return estInterne;
	}

	public void setEstInterne(boolean estInterne) {
		this.estInterne = estInterne;
	}

	@Override
	public String toString() {
		return "Formateur [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", estInterne="
				+ estInterne + ", getId()=" + getId() + "]";
	} 
	
}
