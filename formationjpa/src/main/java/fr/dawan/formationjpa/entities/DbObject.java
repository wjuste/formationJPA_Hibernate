package fr.dawan.formationjpa.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
 * @MappedSuperclass: Dans ce cas la classe n'est pas une entit� 
 * 					JPA, mais ses champs seront enregistr�s en base 
 */
@MappedSuperclass
public class DbObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7520362790367202728L;
	
	/*
	 * L'annotation @Id permet de specifier que l'attribut id 
	 * sera la cl� primaire. 
	 * Si on veut que la cl� soit autog�n�r�, auto-increment�, on utilise
	 * l'annotation @GeneratedValue. 
	 * Cette annotation indique que la cl� primaire est g�n�r� de fa�on 
	 * automatique lors de l'insertion en base.
	 * Sans cette annotation, la valeur de l'identifiant de la cl� primaire
	 * doit �tre affect� avant l'insertion en base
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}
	
}
