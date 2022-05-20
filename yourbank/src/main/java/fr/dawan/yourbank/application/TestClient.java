package fr.dawan.yourbank.application;

import java.time.LocalDate;

import fr.dawan.yourbank.dao.ClientRepositoryImpl;
import fr.dawan.yourbank.dao.IClientRepository;
import fr.dawan.yourbank.entities.Client;
import fr.dawan.yourbank.entities.Compte;
import fr.dawan.yourbank.entities.CompteCourant;
import fr.dawan.yourbank.entities.CompteEpargne;

public class TestClient {

	static IClientRepository repository = new ClientRepositoryImpl();
	
	public static void main(String[] args) {
		
		//testSaveClient();
		//testDeleteMethod();
		testSaveClientWithComptes();
		
	}

	private static void testSaveClient() {
		Client c1 = new Client("Helene", "helene@gmail.com");
		Client c2 = new Client("Aurelien", "aurelien@gmail.com");
		Client c3 = new Client("Soumia", "soumia@gmail.com");
		
		repository.saveClient(c1);
		repository.saveClient(c2);
		repository.saveClient(c3);
	}
	
	
	//Quand on supprime un client , on veut qu'il supprime 
	//tous les comptes du client
	private static void testDeleteMethod() {
		repository.deleteClient(2); 
		Client clientBDD = repository.getClient(2);
		System.out.println(clientBDD == null);
	}
	
	private static void testSaveClientWithComptes() {
		Client c1 = new Client("Oumar", "oumar@gmail.com");
		Client c2 = new Client("Ayyoub", "ayyoub@gmail.com");
		Client c3 = new Client("Thomas", "thomas@gmail.com");
		
		Compte cb1 = new CompteCourant("aaa88sscs", LocalDate.now(), 5000, c1, 400);
		Compte cb2 = new CompteCourant("875sd22", LocalDate.now(), 15000, c2, 1000);
		Compte cb3 = new CompteCourant("ttt5454ssd", LocalDate.now(), 30000, c1, 1000);
		Compte cb4 = new CompteEpargne("ppssd665ds", LocalDate.now(), 35000, c3, 5.5);
		Compte cb5 = new CompteEpargne("df998ffd", LocalDate.now(), 98520, c2, 5.5);

		
		//On va sauvegarder le client et laisser les cascades créer les comptes 
		c1.addComptes(cb1);
		c2.addComptes(cb2);
		c1.addComptes(cb3);
		c2.addComptes(cb5);
		c3.addComptes(cb4);
		
		repository.saveClient(c1);
		repository.saveClient(c2);
		repository.saveClient(c3);

		
	
	
	}
	

}
