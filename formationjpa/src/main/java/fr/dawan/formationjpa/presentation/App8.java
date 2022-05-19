package fr.dawan.formationjpa.presentation;

import java.util.UUID;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formateur;
import fr.dawan.formationjpa.entities.Formation;

public class App8 {

	public static void main(String[] args) {
		
		Formateur formateur1 = new Formateur();
		formateur1.setEstInterne(true);
		formateur1.setMatricule(UUID.randomUUID().toString());
		formateur1.setNom("Trop");
		formateur1.setPrenom("Cool");
		
		Formateur formateur2 = new Formateur();
		formateur2.setEstInterne(true);
		formateur2.setMatricule(UUID.randomUUID().toString());
		formateur2.setNom("Vaga");
		formateur2.setPrenom("Cham");
		
		Formateur formateur3 = new Formateur();
		formateur3.setEstInterne(true);
		formateur3.setMatricule(UUID.randomUUID().toString());
		formateur3.setNom("Jean");
		formateur3.setPrenom("Coco");
		
		Formation formationWeb = new Formation();
		formationWeb.setCode("FOR-DEV008");
		formationWeb.setDuree(3);
		formationWeb.setNom("Webmaster - Web");
		formationWeb.setPrix(1120);
		
		Formation formationSpringBoot = new Formation();
		formationSpringBoot.setCode("FOR-DEV009");
		formationSpringBoot.setDuree(5);
		formationSpringBoot.setNom("Spring Boot");
		formationSpringBoot.setPrix(2500);
		
		//Associer des formations a des formateurs 
		//et/ou associer des formateur  a des formations
		formateur2.addCompentences(formationSpringBoot);
		formateur2.addCompentences(formationWeb);
		
		//Appel des méthodes create pour persister les formateurs
		GenericDAO.create(formateur1);
		GenericDAO.create(formateur2);
		GenericDAO.create(formateur3);
		
	}

}
