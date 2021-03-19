package com.example.TradeEngineDatabase.exchangeorder;

import com.example.TradeEngineDatabase.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeOrderRepository extends JpaRepository<ExchangeOrder, Long> {
    @Query("SELECT e FROM ExchangeOrder e WHERE e.exchangeOrderId = ?1")
    Optional<ExchangeOrder> findExchangeOrderById(String exchangeOrderId);
}
