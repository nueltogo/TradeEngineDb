package com.example.TradeEngineDatabase.product;

import com.example.TradeEngineDatabase.clientorder.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT s FROM Product s WHERE s.id = ?1")
    Optional<Product> findProductById(Long productId);

    Optional<List<Product>> findByPortfolio_PortfolioId(long portfolioId);

    Optional<Product> findByPortfolio_PortfolioIdAndTicker(long portfolioId, String ticker);
}
