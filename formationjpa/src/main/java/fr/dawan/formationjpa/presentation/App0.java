package fr.dawan.formationjpa.presentation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Verification de la connexion vers la base de données
 */
public class App0 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory =   Persistence.createEntityManagerFactory("formationJPA");
		factory.close();

	}

}
