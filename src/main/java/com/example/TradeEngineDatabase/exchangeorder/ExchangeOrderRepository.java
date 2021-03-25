package com.example.TradeEngineDatabase.exchangeorder;

import com.example.TradeEngineDatabase.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeOrderRepository extends JpaRepository<ExchangeOrder, Long> {

    Optional<ExchangeOrder> findByExchangeOrderId(String exchangeOrderId);

    Optional<List<ExchangeOrder>> findByClientorder_ClientOrderId(long clientOrderId);

    void deleteByExchangeOrderId(String exchangeOrderId);
}
