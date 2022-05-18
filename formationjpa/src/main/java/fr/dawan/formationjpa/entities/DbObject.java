package fr.dawan.formationjpa.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
 * @MappedSuperclass: Dans ce cas la classe n'est pas une entité 
 * 					JPA, mais ses champs seront enregistrés en base 
 */
@MappedSuperclass
public class DbObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7520362790367202728L;
	
	/*
	 * L'annotation @Id permet de specifier que l'attribut id 
	 * sera la clé primaire. 
	 * Si on veut que la clé soit autogénéré, auto-incrementé, on utilise
	 * l'annotation @GeneratedValue. 
	 * Cette annotation indique que la clé primaire est généré de façon 
	 * automatique lors de l'insertion en base.
	 * Sans cette annotation, la valeur de l'identifiant de la clé primaire
	 * doit être affecté avant l'insertion en base
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}
	
}
