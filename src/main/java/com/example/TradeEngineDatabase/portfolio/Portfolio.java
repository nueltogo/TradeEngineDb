package com.example.TradeEngineDatabase.portfolio;

import javax.persistence.*;

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
    private int clientId;



    public Portfolio() {
    }

    public Portfolio(String name, int clientId) {
        this.name = name;
        this.clientId = clientId;
    }

    public Portfolio(long portfolioId, String name, int clientId) {
        this.portfolioId = portfolioId;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
