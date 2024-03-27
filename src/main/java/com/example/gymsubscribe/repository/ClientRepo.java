package com.example.gymsubscribe.repository;

import com.example.gymsubscribe.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
