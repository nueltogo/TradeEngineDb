package com.example.TradeEngineDatabase.exchangeorder;

import java.util.List;

public class ExchangeStatus {
    private int quantity;
    private String side;
    private List<Execution> executionsList;
    private int cumulativeQuantity;

    public ExchangeStatus() {
    }

    public ExchangeStatus(int quantity, String side, List<Execution> executionsList, int cumulativeQuantity) {
        this.quantity = quantity;
        this.side = side;
        this.executionsList = executionsList;
        this.cumulativeQuantity = cumulativeQuantity;
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

    public List<Execution> getExecutionsList() {
        return executionsList;
    }

    public void setExecutionsList(List<Execution> executionsList) {
        this.executionsList = executionsList;
    }

    public int getCumulativeQuantity() {
        return cumulativeQuantity;
    }

    public void setCumulativeQuantity(int cumulativeQuantity) {
        this.cumulativeQuantity = cumulativeQuantity;
    }
}
