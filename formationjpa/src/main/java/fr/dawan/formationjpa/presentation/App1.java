package fr.dawan.formationjpa.presentation;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

public class App1 {

	public static void main(String[] args) {
		
		/*
		 * Creation d'une formation
		 */
		Formation formation = new Formation();
		formation.setCode("FOR-DEV001");
		formation.setDuree(5);
		formation.setNom("JPA/Hibernate");
		formation.setPrix(2000);
		
		GenericDAO.create(formation);
		
		
		
	}

}
