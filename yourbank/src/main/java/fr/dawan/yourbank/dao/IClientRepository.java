package fr.dawan.yourbank.dao;

import java.util.List;

import fr.dawan.yourbank.entities.Client;

public interface IClientRepository {
	
	void saveClient(Client client);
	void updateClient(Client client);
	List<Client> getAllClient();
	Client getClient(long code);
	void deleteClient(long code);
	List<Client> findClientsByKey(String name);
	
}
