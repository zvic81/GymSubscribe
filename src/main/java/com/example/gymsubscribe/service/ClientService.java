package com.example.gymsubscribe.service;
import java.util.List;
import com.example.gymsubscribe.model.Client;

public interface ClientService {
    List<Client> findAll();
    Client saveClient(Client client);
    Client updateClient(Client client);

    Client findById(Long clientID);
}
