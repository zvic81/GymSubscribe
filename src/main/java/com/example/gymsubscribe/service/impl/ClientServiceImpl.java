package com.example.gymsubscribe.service.impl;

import com.example.gymsubscribe.model.Client;
import com.example.gymsubscribe.repository.ClientRepo;
import com.example.gymsubscribe.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client findById(Long clientID) { return clientRepo.findById(clientID).orElse(null); }
}
