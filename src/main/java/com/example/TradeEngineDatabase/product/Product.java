package com.example.TradeEngineDatabase.product;

import com.example.TradeEngineDatabase.portfolio.Portfolio;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Product {
    @Id
/*    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )*/
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            //generator = "product_sequence"
    )
    private long productId;
    @NotNull
    private String ticker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioID")
    private Portfolio portfolio;

    @Column(nullable = false)
    private int quantity;
    @Column()
    private double lastTradedPrice;
    @Column()
    private String lastTradedSide;
    @Column()
    private LocalDateTime createdAt = LocalDateTime.now();



    public Product() {
    }

    public Product(long productId) {
        this.productId = productId;
    }

    public Product(String ticker, Portfolio portfolio, int quantity, double lastTradedPrice, String lastTradedSide) {
        this.ticker = ticker;
        this.portfolio = portfolio;
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

    public Portfolio getPortfolioId() {
        return portfolio;
    }

    public void setPortfolioId(Portfolio portfolioId) {
        this.portfolio = portfolioId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", ticker='" + ticker + '\'' +
                ", portfolioId=" + portfolio +
                ", quantity=" + quantity +
                ", lastTradedPrice=" + lastTradedPrice +
                ", lastTradedSide='" + lastTradedSide + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
