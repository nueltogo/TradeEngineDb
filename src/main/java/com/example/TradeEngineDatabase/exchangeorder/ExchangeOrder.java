package com.example.TradeEngineDatabase.exchangeorder;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Timestamp createdAt;

    public ExchangeOrder() {
    }

    public ExchangeOrder(String exchangeOrderId, String product, double price, int quantity, long clientOrderId, int exchange, String status) {
        this.exchangeOrderId = exchangeOrderId;
        Product = product;
        this.price = price;
        this.quantity = quantity;
        this.clientOrderId = clientOrderId;
        this.exchange = exchange;
        this.status = status;
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

    public void setCreatedAt() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
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

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }


    @Override
    public String toString() {
        return "ExchangeOrder{" +
                "exchangeOrderId='" + exchangeOrderId + '\'' +
                ", Product='" + Product + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", clientOrderId=" + clientOrderId +
                ", exchange=" + exchange +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
