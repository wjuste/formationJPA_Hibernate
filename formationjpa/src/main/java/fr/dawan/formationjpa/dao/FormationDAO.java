package fr.dawan.formationjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.dawan.formationjpa.entities.Formation;
import fr.dawan.formationjpa.entities.SessionFormation;

public class FormationDAO {
	
	public static void createFormation(Formation formation) {
		
		EntityManager em = GenericDAO.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//debut de la transaction 
			tx.begin();
			
			//Insertion de la formation 
			em.persist(formation);
			System.out.println("Insertion de " + formation);
			
			//Pour chaque session de la formation 
			for (SessionFormation session : formation.getSessions()) {
				
				em.persist(session);
				System.out.println("Insertion de " + session);

				//Dans la session, insertion du formateur 
				if(session.getFormateur() != null) {
					em.persist(session.getFormateur());
				}
			}
			
			//Validation de la formation 
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			// TODO: handle exception
		} finally {
			em.close();
		}
	}
	
}
