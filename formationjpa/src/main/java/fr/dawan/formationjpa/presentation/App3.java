package fr.dawan.formationjpa.presentation;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

public class App3 {

	public static void main(String[] args) {
		
		Formation formation = new Formation();
		formation.setCode("FOR_DEV002");
		formation.setDuree(5);
		formation.setNom("Spring MVC");
		formation.setPrix(2532);
		
		GenericDAO.create(formation);
		
		
		//On supprime la formation dont l'id est égale à 1
		GenericDAO.delete(Formation.class, 1);
		
		Formation formation2 = GenericDAO.findById(Formation.class, 1);
		
		//On verifie que la formation dont l'id = 1 a été effacée en base
		System.out.println(formation2 == null);
	}

}
