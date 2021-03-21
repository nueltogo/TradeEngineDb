package com.example.TradeEngineDatabase.portfolio;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.exchangeorder.ExchangeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    @Query("SELECT s FROM Portfolio s WHERE s.id = ?1")
    Optional<Portfolio> findPortfolioById(Long portfolioId);

    @Query("SELECT s FROM Portfolio s WHERE s.name = :name AND s.clientId = :clientId")
    Optional<Portfolio> findPortfolioByClientIdAndName(String name, int clientId);
}
