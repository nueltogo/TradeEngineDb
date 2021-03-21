package com.example.TradeEngineDatabase.exchangeorder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class ExchangeOrder {
    @Id
    private String exchangeOrderId;
    private String product;
    private Integer quantity;
    private Double price;
    private String side;
    private Integer exchange;
    private long clientOrderId;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();

    public ExchangeOrder() {
    }

    public ExchangeOrder(String exchangeOrderId) {
        this.exchangeOrderId = exchangeOrderId;
    }

    public ExchangeOrder(String exchangeOrderId, String product, Integer quantity, Double price, String side, Integer exchange, long clientOrderId, String status) {
        this.exchangeOrderId = exchangeOrderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.exchange = exchange;
        this.clientOrderId = clientOrderId;
        this.status = status;
    }

    public String getExchangeOrderId() {
        return exchangeOrderId;
    }

    public void setExchangeOrderId(String exchangeOrderId) {
        this.exchangeOrderId = exchangeOrderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Integer getExchange() {
        return exchange;
    }

    public void setExchange(Integer exchange) {
        this.exchange = exchange;
    }

    public long getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(long clientOrderId) {
        this.clientOrderId = clientOrderId;
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
        return "ExchangeOrder{" +
                "exchangeOrderId='" + exchangeOrderId + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", side='" + side + '\'' +
                ", exchange=" + exchange +
                ", clientOrderId=" + clientOrderId +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
