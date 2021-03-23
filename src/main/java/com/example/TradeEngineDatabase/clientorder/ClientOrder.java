package com.example.TradeEngineDatabase.clientorder;

import com.example.TradeEngineDatabase.client.Client;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private long portfolioId;
//    private long clientId;
    private String validationStatus;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientID")
    private Client client;

    private LocalDateTime createdAt = LocalDateTime.now();

    public ClientOrder() {
    }

    public ClientOrder(long clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public ClientOrder(String product, double price, int quantity, String side, int portfolioId, int clientId, String validationStatus, String status) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.portfolioId = portfolioId;
//        this.clientId = clientId;
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

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

//    public long getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(int clientId) {
//        this.clientId = clientId;
//    }

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
                ", portfolioId=" + portfolioId +
//                ", clientId=" + clientId +
                ", validationStatus='" + validationStatus + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
