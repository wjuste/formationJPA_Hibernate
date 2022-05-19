package fr.dawan.formationjpa.presentation;

import java.util.List;

import org.hibernate.Session;

import fr.dawan.formationjpa.dao.GenericDAO;
import fr.dawan.formationjpa.entities.SessionFormation;

public class App7 {

	public static void main(String[] args) {
		
//		List<SessionFormation> sessions = GenericDAO.findAll(SessionFormation.class);
//		System.out.println("Toutes les SessionFormation");
//		for (SessionFormation sessionFormation : sessions) {
//			System.out.println(sessions);
//		}
//		
		List<SessionFormation> sessions2 = GenericDAO.findAll(SessionFormation.class, 1, 5);
		for (SessionFormation sessionFormation : sessions2) {
			System.out.println(sessionFormation);
		}
	}

}
