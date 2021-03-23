package com.example.TradeEngineDatabase.client;
import com.example.TradeEngineDatabase.clientorder.*;

import com.example.TradeEngineDatabase.portfolio.Portfolio;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Client {
    @Id
/*    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )*/
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            //generator = "client_sequence"
    )
    @Column()
    private long clientId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private double balance;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy="client",cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    @OneToMany(mappedBy="client",cascade = CascadeType.ALL)
    private List<ClientOrder> orders;

    public Client() {
    }

    public Client(long clientId) {
        this.clientId = clientId;
    }

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Client(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public Client(long clientId, String name, String email, String password, double balance) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}
