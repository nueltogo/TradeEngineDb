package com.example.TradeEngineDatabase.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT s FROM Client s WHERE s.id = ?1")
    Optional<Client> findClientById(Long clientId);

    @Query("SELECT s FROM Client s WHERE s.email = :email AND s.password = :password")
    Optional<Client> findClientByEmailAndPass(String email,String password);
}

