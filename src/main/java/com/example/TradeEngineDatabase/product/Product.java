package com.example.TradeEngineDatabase.product;

import com.example.TradeEngineDatabase.portfolio.Portfolio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private long productId;
    private String ticker;
//    private long portfolioId;
    private int quantity;
    private double lastTradedPrice;
    private String lastTradedSide;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioID")
    private Portfolio portfolio;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Product() {
    }

    public Product(long productId) {
        this.productId = productId;
    }

    public Product(String ticker, long portfolioId, int quantity, double lastTradedPrice, String lastTradedSide) {
        this.ticker = ticker;
//        this.portfolioId = portfolioId;
        this.quantity = quantity;
        this.lastTradedPrice = lastTradedPrice;
        this.lastTradedSide = lastTradedSide;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

//    public long getPortfolioId() {
//        return portfolioId;
//    }
//
//    public void setPortfolioId(long portfolioId) {
//        this.portfolioId = portfolioId;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public String getLastTradedSide() {
        return lastTradedSide;
    }

    public void setLastTradedSide(String lastTradedSide) {
        this.lastTradedSide = lastTradedSide;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", ticker='" + ticker + '\'' +
//                ", portfolioId=" + portfolioId +
                ", quantity=" + quantity +
                ", lastTradedPrice=" + lastTradedPrice +
                ", lastTradedSide='" + lastTradedSide + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
