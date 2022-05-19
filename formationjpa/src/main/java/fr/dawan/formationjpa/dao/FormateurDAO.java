package fr.dawan.formationjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.formationjpa.entities.Formateur;

public class FormateurDAO {
	
	public static List<Formateur> findByNameNativeSQL(String name) {
		List<Formateur> formateurs = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		//SELECT * FROM trainer WHERE t_lastname like '%ie%'
		String sql = "SELECT * FROM trainer WHERE t_lastname LIKE '%" + name + "%'";
		Query query =  em.createNativeQuery(sql, Formateur.class);
		formateurs = query.getResultList();
		em.close();
		return formateurs;
	}
	
	public static List<Formateur> findByNameJPQLPositionalParameter(String name) {
		List<Formateur> formateurs = null;
		EntityManager em = GenericDAO.createEntityManager();
		
		String jpql = "SELECT f FROM Formateur f WHERE f.nom like ?1 ORDER BY f.prenom";
		Query query = em.createQuery(jpql, Formateur.class);
		query.setParameter(1, "%" + name + "%");
		formateurs = query.getResultList();
		em.close();
		return formateurs;
	}

//	public static List<Formateur> findByNameJPQLNamedParameter(String name) {
//		
//	}
	
	
}
