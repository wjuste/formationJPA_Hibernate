package fr.dawan.formationjpa.presentation;

import java.time.LocalDate;
import java.util.UUID;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formateur;
import fr.dawan.formationjpa.entities.Formation;
import fr.dawan.formationjpa.entities.SessionFormation;

public class App6 {

	public static void main(String[] args) {

		Formation formationScrJavaScript = new Formation();
		formationScrJavaScript.setCode("FOR-DEV005");
		formationScrJavaScript.setDuree(2);
		formationScrJavaScript.setNom("JavaScript");
		formationScrJavaScript.setPrix(800);

		Formateur formateur = new Formateur();
		formateur.setEstInterne(true);
		formateur.setMatricule(UUID.randomUUID().toString());
		formateur.setNom("Bien");
		formateur.setPrenom("Jim");

		SessionFormation sessionJuin = new SessionFormation();
		sessionJuin.setDate(LocalDate.of(2022, 06, 06));
		sessionJuin.setNbPlaceMaxi(20);
		sessionJuin.setNbPlace(16);
		sessionJuin.setLieu("Nantes");
		sessionJuin.setFormation(formationScrJavaScript);

		SessionFormation sessionSeptembre = new SessionFormation();
		sessionSeptembre.setDate(LocalDate.of(2022, 9, 05));
		sessionSeptembre.setNbPlaceMaxi(10);
		sessionSeptembre.setNbPlace(8);
		sessionSeptembre.setLieu("Paris");
		sessionSeptembre.setFormation(formationScrJavaScript);

		//************************************************
		//DEUXIEME TENTATIVE FORMATIONDAO (Cascade personnalisé)
		//
		//connaitre le nombre de session à partir de l'objet formation en memoire 
		System.out.println("Nombre de sessions dans la formation Scrum : " + formationScrJavaScript.getSessions().size());

		//Connaitre l'ID de la formation 
		System.out.println("id de la formation " + formationScrJavaScript.getId());


		//Recuperation de la formation correspondante en base de données
		Formation formationBDD = GenericDAO.findById(Formation.class, formationScrJavaScript.getId());


		//Connaitre le nombre de session à partir de l'objet formation provenant 
		//de la base de données
		System.out.println("Nombre de sessions dans la formation Scrum provenant de la base de données : "
				+ formationBDD.getSessions().size());


	}

}
