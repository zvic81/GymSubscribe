package com.example.gymsubscribe.service;

import com.example.gymsubscribe.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAllClients();

    Client saveClient(Client client);

    Client updateClient(Client client);

    Client findById(Long clientID);
}
