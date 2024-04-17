package com.example.gymsubscribe.service;
import java.util.List;
import com.example.gymsubscribe.model.Client;

public interface ClientService {
    List<Client> findAllClients();
    Client saveClient(Client client);
    Client updateClient(Client client);

    Client findById(Long clientID);

    List<Client> getAllClients();
}
