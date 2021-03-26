package com.example.TradeEngineDatabase.portfolio;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.clientorder.ClientOrder;
import com.example.TradeEngineDatabase.product.Product;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "portfolioId",
        scope     = Long.class)
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
    @Column(name = "portfolio_Id")
    private long portfolioId;
    private String name;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
    @JsonIdentityReference(alwaysAsId = true)
    private Client client;

    // client can place orders to make portforlio
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Product> products = new ArrayList<>();

    @OneToMany(targetEntity = ClientOrder.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId = true)
    private List<ClientOrder> clientOrders = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();


    public Portfolio() {
    }

    public Portfolio(String name) {
        this.name = name;
    }

    public Portfolio(String name, long clientId) {
        this.name = name;
        this.clientId = clientId;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        products.add(product);
    }

    public List<ClientOrder> getClientOrders() {
        return clientOrders;
    }

    public void setClientOrders(ClientOrder clientOrder) {
        clientOrders.add(clientOrder);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Porftfolio{" +
                "portfolioId=" + portfolioId +
                ", name=" + name +
                ", clientId=" + client.getClientId() +
                '}';
    }

}



