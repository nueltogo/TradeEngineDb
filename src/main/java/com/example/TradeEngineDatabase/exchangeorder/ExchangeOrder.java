package com.example.TradeEngineDatabase.exchangeorder;

import com.example.TradeEngineDatabase.clientorder.ClientOrder;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "exchangeOrderId",
        scope     = String.class)
public class ExchangeOrder {
    @Id
    @SequenceGenerator(
            name = "exchangeOrder_sequence",
            sequenceName = "exchangeOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exchangeOrder_sequence"
    )
    private long id;
    @Column(name = "exchange_Order_Id")
    private String exchangeOrderId;
    private String product;
    private Integer quantity;
    private Double price;
    private String side;
    private Integer exchange;
    private String status;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long clientOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
    @JsonIdentityReference(alwaysAsId = true)
    private ClientOrder clientorder;

    private LocalDateTime createdAt = LocalDateTime.now();

    public ExchangeOrder() {
    }

    public ExchangeOrder(String exchangeOrderId) {
        this.exchangeOrderId = exchangeOrderId;
    }

    public ExchangeOrder(String exchangeOrderId, String product, Integer quantity, Double price, String side, Integer exchange, String status, long clientOrderId) {
        this.exchangeOrderId = exchangeOrderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.exchange = exchange;
        this.status = status;
        this.clientOrderId = clientOrderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getClientOrderId() {
        if(this.clientOrderId==0) {
            return this.clientorder.getClientOrderId();
        }
        else{
            return this.clientOrderId;
        }
    }

    public void setClientOrderId(long clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public ClientOrder getClientorder() {
        return clientorder;
    }

    public void setClientorder(ClientOrder clientorder) {
        this.clientorder = clientorder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
                ", clientOrderId=" + this.getClientOrderId() +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
