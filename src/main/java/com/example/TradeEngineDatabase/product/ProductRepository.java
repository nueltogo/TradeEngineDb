package com.example.TradeEngineDatabase.product;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT s FROM Product s WHERE s.id = ?1")
    Optional<Product> findProductById(Long productId);
}
