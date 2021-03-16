package com.example.TradeEngineDatabase.product;

import javax.persistence.*;
import java.time.LocalDate;

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
    private long portfolioId;
    private int quantity;
    private LocalDate createdAt;

    public Product() {
    }

    public Product(String ticker, long portfolioId, int quantity, LocalDate createdAt) {
        this.ticker = ticker;
        this.portfolioId = portfolioId;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    public Product(long productId, String ticker, long portfolioId, int quantity, LocalDate createdAt) {
        this.productId = productId;
        this.ticker = ticker;
        this.portfolioId = portfolioId;
        this.quantity = quantity;
        this.createdAt = createdAt;
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

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", ticker='" + ticker + '\'' +
                ", portfolioId='" + portfolioId + '\'' +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                '}';
    }
}
