package fr.dawan.yourbank.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8137999751458279163L;

	public Versement() {
		super();
	}

	public Versement(LocalDate dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
	}

	
	
}
