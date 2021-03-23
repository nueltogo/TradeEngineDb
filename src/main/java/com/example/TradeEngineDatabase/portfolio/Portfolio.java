package com.example.TradeEngineDatabase.portfolio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Portfolio {
    @Id
    @SequenceGenerator(
            name = "portfolio_sequence",
            sequenceName = "portfolio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "portfolio_sequence"
    )
    private long portfolioId;
    private String name;
    private long clientId;
    private LocalDateTime createdAt = LocalDateTime.now();


    public Portfolio() {
    }

    public Portfolio(String name, int clientId) {
        this.name = name;
        this.clientId = clientId;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Porftfolio{" +
                "portfolioId=" + portfolioId +
                ", name=" + name +
                ", clientId=" + clientId +
                '}';
    }
}
