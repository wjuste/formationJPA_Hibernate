package fr.dawan.yourbank.application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App0 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("yourbank");
		factory.close();
	}

}
