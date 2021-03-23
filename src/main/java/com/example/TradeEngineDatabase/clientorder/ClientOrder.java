package com.example.TradeEngineDatabase.clientorder;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.exchangeorder.ExchangeOrder;
import com.example.TradeEngineDatabase.portfolio.Portfolio;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class ClientOrder {
    @Id
    @SequenceGenerator(
            name = "clientOrder_sequence",
            sequenceName = "clientOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clientOrder_sequence"
    )
    private long clientOrderId;
    private String product;
    private double price;
    private int quantity;
    private String side;
    private String validationStatus;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExchangeOrder> orders;

    private LocalDateTime createdAt = LocalDateTime.now();

    public ClientOrder() {
    }

    public ClientOrder(long clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public ClientOrder(String product, double price, int quantity, String side, String validationStatus, String status) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.validationStatus = validationStatus;
        this.status = status;
    }


    public long getClientOrderId() {
        return clientOrderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    @Override
    public String toString() {
        return "ClientOrder{" +
                "clientOrderId=" + clientOrderId +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", side='" + side + '\'' +
                ", portfolioId=" + portfolio.getPortfolioId() +
                ", clientId=" + client.getClientId() +
                ", validationStatus='" + validationStatus + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
