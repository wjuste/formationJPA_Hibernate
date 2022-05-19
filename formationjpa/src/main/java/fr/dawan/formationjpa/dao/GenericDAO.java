package fr.dawan.formationjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.dawan.formationjpa.entities.DbObject;

public class GenericDAO {

	public static <T extends DbObject> void create (T entity) {
		
		if(entity.getId() == 0) {
			EntityManager entityManager  = createEntityManager();
			EntityTransaction transaction =  entityManager.getTransaction();
			
			try {
				//Debut de la transaction 
				transaction.begin();
				
				//On insére une entité 
				entityManager.persist(entity);
				
				
				//On commit tout ce qui a été fait dans la transaction 
				transaction.commit();
			} catch (Exception e) {
				//En cas d'erreur, on effectue un rollback
				transaction.rollback();
				e.printStackTrace();
			} finally {
				entityManager.close();
				//factory.close();
			}
				
		}	
	}

	public static <T extends DbObject> T findById(Class<T> clazz, long id) {
		EntityManager entityManager = createEntityManager();
		
		T entity = null;
		
		try {
			//On charge la formation depuis la BDDn selon Id
			entity = entityManager.find(clazz, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
		return entity;
		
	}
	
	public static <T extends DbObject> void update(T entity) {
		if(entity.getId() > 0) {
			EntityManager entityManager = createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			
			try {
				//Début de la transaction
				transaction.begin();
				
				//On met à jour l'entité 
				entityManager.merge(entity);
				
				//On commit ce qui a été fait dans la transaction 
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				entityManager.close();
			}
		}
	}
 
	public static <T extends DbObject> void delete(Class<T> clazz, long id) {
		EntityManager entityManager = createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			T entity = entityManager.find(clazz, id);
			entityManager.remove(entity);  //etat Remove
			transaction.commit();   //supprimé
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
	}
	//findAll(Formation.class)
	public static <T extends DbObject> List<T> findAll(Class<T> clazz) {
		
		List<T> resultat = null;
		EntityManager em = createEntityManager();
		
		//SELECT * FROM tableEntity ===> (SQL)
		//SELECT entity FROM Entity entity ===> (JPQL : Java Persistence Query Language)
		
		//Creation de la requête 
		String sql = "SELECT entity FROM " + clazz.getName() + " entity";
		TypedQuery<T> query =  em.createQuery(sql, clazz);
		
		resultat = query.getResultList();
		
		return resultat;
	}
	
	public static<T extends DbObject> List<T> findAll(Class<T> clazz, int begin, int nbResult) {
		List<T> resultat = null;
		EntityManager em = createEntityManager();

		//Creation de la raquête 
		String sql = "SELECT entity FROM " + clazz.getName() + " entity";
		TypedQuery<T> query =  em.createQuery(sql, clazz);
		
		resultat = query.setFirstResult(begin)   //On commence à ce numero (begin) - au Nième résultat 
					.setMaxResults(nbResult)    //On charge le nbResultat
					.getResultList();  //On recupère
		return resultat;
	}
	
	
	public static EntityManager createEntityManager() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("formationJPA");
		EntityManager entityManager  = factory.createEntityManager();
		return entityManager;
	}


}
