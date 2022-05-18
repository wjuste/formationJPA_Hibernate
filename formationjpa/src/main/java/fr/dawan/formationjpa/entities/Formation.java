package fr.dawan.formationjpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @Entity : Pour specifier que la classe Formation correspond à une table
 * 			on utilise l'annotation @Entity (Obligatoire)
 * @Table : Si on veut specifier le nom de la classe correspondant à cette 
 * 			table on utilise l'annotation @table  
 * 			ex: @Table(name="FORMATIONS")
 */
@Entity
//@Table(name="FORMATIONS")
public class Formation extends DbObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1832667860799661774L;
	
	private String nom;
	
	/*
	 * On peut specifier le nom de colonne de la table qui correspond à 
	 * l'attrbut code 
	 * On utilise l'annotation @Column(name="C_DE")
	 */
	//@Column(name="C_DE")
	private String code;
		
	@Column(precision = 2)
	private double prix;
	
	private int duree;
	
	//1 Formation appartient à plusieurs SessionFormation
	// 1 -> n (OneToMany)    ----- 	n = plusieurs 
	//One : Formation 
	//Many : Session
	/*
	 * La classe formation est l'entité l'esclave. 
	 * Dans l'entité esclave on doit referencer l'attribut qui porte 
	 * la relation coté propriétaire (maitre)
	 * Ainsi, on relie cette entité à l'autre entité via la clé 
	 * étrangère
	 * 
	 * mappedBy nous permet de lier la table ne contenant pas la 
	 * contrainte de clé étrangère vers l'autre table
	 * 
	 * Sans l'annotation mappedBy, Hibernate va créer une table 
	 * de relation , permettant de relier les deux tables
	 */
	@OneToMany(mappedBy = "formation", cascade = CascadeType.PERSIST)
	List<SessionFormation> sessions = new ArrayList<SessionFormation>();
	
	/*
	 * n -> n 
	 * ManyToMany
	 * formateursCompetentsId
	 */
	@ManyToMany(mappedBy = "competences")
	List<Formateur> formateursCompetents = new ArrayList<Formateur>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public List<SessionFormation> getSessions() {
		return sessions;
	}
	
	public void addSession(SessionFormation session) {
		if(!this.sessions.contains(session) && session != null) {
			this.sessions.add(session);
		}
	}
	

	public void setSessions(List<SessionFormation> sessions) {
		this.sessions = sessions;
	}

	public List<Formateur> getFormateursCompetents() {
		return formateursCompetents;
	}

	public void setFormateursCompetents(List<Formateur> formateursCompetents) {
		this.formateursCompetents = formateursCompetents;
	}

	@Override
	public String toString() {
		return "Formation [nom=" + nom + ", code=" + code + ", prix=" + prix + ", duree=" + duree + ", getId()="
				+ getId() + "]";
	}
	

}
