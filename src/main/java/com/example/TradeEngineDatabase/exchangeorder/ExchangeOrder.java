package com.example.TradeEngineDatabase.exchangeorder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
@Table
public class ExchangeOrder {
    @Id
    private String exchangeOrderId;
    private String Product;
    private double price;
    private int quantity;
    private long clientOrderId;
    private int exchange;
    private String status;
    private LocalDate createdAt;

    public ExchangeOrder() {
    }

    public ExchangeOrder(String exchangeOrderId, String product, double price, int quantity, long clientOrderId, int exchange, String status, LocalDate createdAt) {
        this.exchangeOrderId = exchangeOrderId;
        Product = product;
        this.price = price;
        this.quantity = quantity;
        this.clientOrderId = clientOrderId;
        this.exchange = exchange;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getExchangeOrderId() {
        return exchangeOrderId;
    }

    public void setExchangeOrderId(String exchangeOrderId) {
        this.exchangeOrderId = exchangeOrderId;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
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

    public long getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(long clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ExchangeOrder{" +
                "exchangeOrderId=" + exchangeOrderId +
                ", Product='" + Product + '\'' +
                ", clientOrderId=" + clientOrderId +
                ", exchange=" + exchange +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
