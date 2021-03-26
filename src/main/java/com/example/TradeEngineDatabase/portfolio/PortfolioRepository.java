package com.example.TradeEngineDatabase.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    @Query("SELECT s FROM Portfolio s WHERE s.id = ?1")
    Optional<Portfolio> findPortfolioById(Long portfolioId);

    Optional<Portfolio> findByClient_ClientIdAndName(long client, String name);

    Optional<List<Portfolio>> findByClient_ClientId(long clientId);
}
