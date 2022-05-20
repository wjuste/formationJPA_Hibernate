package fr.dawan.yourbank.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7024112593019306018L;

	public Retrait() {
		super();
	}

	public Retrait(LocalDate dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
	}
	

}
