package fr.dawan.yourbank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.dawan.yourbank.entities.Client;

public class ClientRepositoryImpl implements IClientRepository{

	@Override
	public void saveClient(Client client) {
		if(client.getCode() == 0) {
			EntityManager em = createEntityManager();
			EntityTransaction transaction =  em.getTransaction();
			try {
				//début de la transaction 
				transaction.begin();
				
				em.persist(client); 
				
				//On commit tout ce qui a fait dans la transaction
				transaction.commit();
				
			} catch (Exception e) {
				//En cas d'erreur, on effectue un rollback
				transaction.rollback();
				e.printStackTrace();
			}finally {
				em.close();
			}
		}
	}

	@Override
	public void updateClient(Client client) {
		if(client.getCode() > 0) {
			EntityManager em = createEntityManager();
			EntityTransaction transaction = em.getTransaction();
			
			try {
				transaction.begin();
				em.merge(client);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}finally {
				em.close();
			}
			
		}
		
	}

	@Override
	public List<Client> getAllClient() {
		List<Client> clients = null;
		EntityManager em = createEntityManager();
		
		//Création de la requête 
		TypedQuery<Client> query =   em.createQuery("SELECT c FROM Client c", Client.class);
		clients = query.getResultList();
		
		em.close();
		
		return clients;

	}

	@Override
	public Client getClient(long code) {
		EntityManager em = createEntityManager();
		Client client = null;
		try {
			client = em.find(Client.class, code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return client;
	}

	@Override
	public void deleteClient(long code) {
		EntityManager em = createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			Client client = em.find(Client.class, code);
			em.remove(client);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Client> findClientsByKey(String name) {
		List<Client> clients = null;
		
		EntityManager em = createEntityManager();
		
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.nom LIKE"
				+ ":leNom", Client.class);
		query.setParameter("leNom", "%" + name + "%");
		
		clients = query.getResultList();
		
		return clients;
	}
	
	//findClientsByMail
	//TO-DO
	
	
	private EntityManager createEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("yourbank");
		EntityManager entityManager =  factory.createEntityManager();
		return entityManager;
	}

}
