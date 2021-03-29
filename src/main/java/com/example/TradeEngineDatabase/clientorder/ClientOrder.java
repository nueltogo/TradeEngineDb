package com.example.TradeEngineDatabase.clientorder;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.exchangeorder.ExchangeOrder;
import com.example.TradeEngineDatabase.portfolio.Portfolio;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "clientOrderId",
        scope     = Long.class)
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
    @Column(name = "client_Order_Id")
    private long clientOrderId;
    private String product;
    private double price;
    private int quantity;
    private String side;
    private String validationStatus;
    private String status;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long clientId;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long portfolioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
    @JsonIdentityReference(alwaysAsId = true)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
    @JsonIdentityReference(alwaysAsId = true)
    private Client client;

    @OneToMany(targetEntity = ExchangeOrder.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "client_Order_Id")
    private List<ExchangeOrder> orders = new ArrayList<>();

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

    public ClientOrder(String product, double price, int quantity, String side, String validationStatus, String status, long clientId, long portfolioId) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.validationStatus = validationStatus;
        this.status = status;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
    }

    public long getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(long clientOrderId) {
        this.clientOrderId = clientOrderId;
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

    public long getClientId() {
        if(this.clientId==0) {
            return this.getClient().getClientId();
        }
        else{
            return this.clientId;
        }
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ExchangeOrder> getOrders() {
        return orders;
    }

    public void setOrders(ExchangeOrder order) {
        orders.add(order);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
