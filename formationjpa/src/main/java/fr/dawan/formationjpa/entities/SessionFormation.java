package fr.dawan.formationjpa.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SessionFormation extends DbObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003864591227262971L;
	
	private String lieu;
	private LocalDate date;
	private int nbPlaceMaxi;
	private int nbPlace;
	
	/*
	 * 1 sessionFormation appartient à 1 Formation 
	 * n (plusieurs) -> 1
	 * ManyToOne
	 * Many : SessionFormation 
	 * One : Formation
	 */
	
	/*
	 * L'entité qui est relié à une seule entité est l'entité 
	 * qui possedera la clé étrangère
	 * Elle est considéré comme l'entité propriétaire (maitre) 
	 * de la relation
	 * 
	 * On peut specifier le nom de la clé étrangère avec l'annotation 
	 * @JoinColumn
	 */
	//@ManyToOne (cascade = CascadeType.PERSIST)
	@ManyToOne
	@JoinColumn(name="id_formation")
	private Formation formation;
	
	/*
	 * 1 sessionFormation a 1 seul formateur
	 * n -> 1   
	 * ManyToOne
	 */
	@ManyToOne
	private Formateur formateur;
	
	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNbPlaceMaxi() {
		return nbPlaceMaxi;
	}

	public void setNbPlaceMaxi(int nbPlaceMaxi) {
		this.nbPlaceMaxi = nbPlaceMaxi;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
}
