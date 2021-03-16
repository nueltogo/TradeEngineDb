package com.example.TradeEngineDatabase.client;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private long clientId;
    private String name;
    private String email;
    private String password;
    private double balance;
    private LocalDate createdAt;

    public Client() {
    }

    public Client(String name, String email, String password, double balance, LocalDate createdAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public Client(long clientId, String name, String email, String password, double balance, LocalDate createdAt) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.createdAt = createdAt;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
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
