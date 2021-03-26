package com.example.TradeEngineDatabase.clientorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
    @Query("SELECT s FROM ClientOrder s WHERE s.id = ?1")
    Optional<ClientOrder> findClientOrderById(Long clientOrderId);

    Optional<List<ClientOrder>> findByClient_ClientId(long clientId);

    Optional<List<ClientOrder>> findByPortfolio_PortfolioId(long portfolioId);

    Optional<List<ClientOrder>> findByStatus(String status);

    Optional<List<ClientOrder>> findByClient_ClientIdAndStatus(long clientId, String Status);
}
