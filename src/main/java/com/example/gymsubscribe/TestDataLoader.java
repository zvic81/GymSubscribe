package com.example.gymsubscribe;

import com.example.gymsubscribe.model.Client;
import com.example.gymsubscribe.model.Subscribe;
import com.example.gymsubscribe.repository.ClientRepo;
import com.example.gymsubscribe.repository.SubscribeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {
    private final SubscribeRepo subscribeRepo;
    private final ClientRepo clientRepo;

    @Override
    public void run(String... args) throws Exception {
        if (clientRepo.findAll().isEmpty()) {
            Client client = new Client();
            client.setFirstName("Ivan");
            client.setSecondName("Petrov");
            client.setDateOfBirth(LocalDate.now().plusMonths(1));
            clientRepo.save(client);
            Client client2 = new Client();
            client2.setFirstName("Jakob");
            client2.setSecondName("Veinstein");
            client2.setDateOfBirth(LocalDate.now().plusMonths(3));
            clientRepo.save(client2);

            Subscribe subscribe1 = new Subscribe();
            subscribe1.setStartDate(LocalDate.now());
            subscribe1.setEndDate(LocalDate.now().plusMonths(1));
            subscribe1.setPrice(50.0);
            subscribe1.setClient(client);
            subscribeRepo.save(subscribe1);

            Subscribe subscribe2 = new Subscribe();
            subscribe2.setStartDate(LocalDate.now());
            subscribe2.setEndDate(LocalDate.now().plusMonths(3));
            subscribe2.setPrice(100.0);
            subscribe2.setClient(client2);
            subscribeRepo.save(subscribe2);
        }
    }
}
