package fr.dawan.formationjpa.presentation;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.Formation;

public class App2 {

	public static void main(String[] args) {
		
		Formation formation = GenericDAO.findById(Formation.class, 1);
		formation.setPrix(899.95);
		formation.setDuree(3);
		
		GenericDAO.update(formation);
	}

}
