package fr.dawan.formationjpa.presentation;

import java.time.LocalDate;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;
import fr.dawan.formationjpa.entities.SessionFormation;

public class App5 {

	public static void main(String[] args) {
		
		Formation formationScrum = new Formation();
		formationScrum.setCode("FOR-DEV004");
		formationScrum.setDuree(2);
		formationScrum.setNom("Agile-Scrum");
		formationScrum.setPrix(800);
		
		SessionFormation sessionJuin = new SessionFormation();
		sessionJuin.setDate(LocalDate.of(2022, 06, 06));
		sessionJuin.setNbPlaceMaxi(12);
		sessionJuin.setNbPlace(10);
		sessionJuin.setLieu("Bordeaux");
		sessionJuin.setFormation(formationScrum);
		
		SessionFormation sessionSeptembre = new SessionFormation();
		sessionSeptembre.setDate(LocalDate.of(2022, 9, 05));
		sessionSeptembre.setNbPlaceMaxi(15);
		sessionSeptembre.setNbPlace(12);
		sessionSeptembre.setLieu("Toulouse");
		sessionSeptembre.setFormation(formationScrum);
		
		
		//************************************************
		//DEUXIEME TENTATIVE AVEC CASCADE PERSIST
		//*************************************************
		
		//On va sauvegarder la formation et va laisser les cascades créer 
		//les sessions	
		formationScrum.addSession(sessionSeptembre);
		formationScrum.addSession(sessionJuin);
		
		GenericDAO.create(formationScrum);
		
		//GenericDAO.create(sessionJuin);
		//GenericDAO.create(sessionSeptembre);
		
		//connaitre le nombre de session à partir de l'objet formation en memoire 
		System.out.println("Nombre de sessions dans la formation Scrum : " + formationScrum.getSessions().size());
		
		//Connaitre l'ID de la formation 
		System.out.println("id de la formation " + formationScrum.getId());
		
		
		//Recuperation de la formation correspondante en base de données
		Formation formationBDD = GenericDAO.findById(Formation.class, formationScrum.getId());
		
		
		//Connaitre le nombre de session à partir de l'objet formation provenant 
		//de la base de données
		System.out.println("Nombre de sessions dans la formation Scrum provenant de la base de données : "
				+ formationBDD.getSessions().size());
		
	}

}
