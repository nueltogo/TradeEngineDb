package com.example.TradeEngineDatabase.product;

import com.example.TradeEngineDatabase.portfolio.Portfolio;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "productId",
        scope     = Long.class)
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
    @Column(name = "product_Id")
    private long productId;
    private String ticker;
    private int quantity;
    private double lastTradedPrice;
    private String lastTradedSide;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long portfolioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_Id")
    @JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
    @JsonIdentityReference(alwaysAsId = true)
    private Portfolio portfolio;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Product() {
    }

    public Product(long productId) {
        this.productId = productId;
    }

    public Product(String ticker, int quantity, double lastTradedPrice, String lastTradedSide) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.lastTradedPrice = lastTradedPrice;
        this.lastTradedSide = lastTradedSide;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

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

    public long getPortfolioId() {
        if(this.portfolioId==0) {
            return this.portfolio.getPortfolioId();
        }
        else{
            return this.portfolioId;
        }
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", ticker='" + ticker + '\'' +
                ", portfolioId=" + portfolio.getPortfolioId() +
                ", quantity=" + quantity +
                ", lastTradedPrice=" + lastTradedPrice +
                ", lastTradedSide='" + lastTradedSide + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
