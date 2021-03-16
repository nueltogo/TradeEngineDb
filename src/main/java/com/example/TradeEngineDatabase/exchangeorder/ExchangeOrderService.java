package com.example.TradeEngineDatabase.exchangeorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExchangeOrderService {
    private final ExchangeOrderRepository exchangeOrderRepository;

    @Autowired
    public ExchangeOrderService(ExchangeOrderRepository exchangeOrderRepository){
        this.exchangeOrderRepository = exchangeOrderRepository;
    }

    public void addNewExchangeOrder(ExchangeOrder exchangeOrder) {
        Optional<ExchangeOrder> exchangeOrderOptional = exchangeOrderRepository.findExchangeOrderById(exchangeOrder.getClientOrderId());
        if(exchangeOrderOptional.isPresent()){
            throw new IllegalStateException("Id already taken.");
        }
        exchangeOrderRepository.save(exchangeOrder);
    }

    public List<ExchangeOrder> getExchangeOrders(){
        return exchangeOrderRepository.findAll();
    }

    public void deleteExchangeOrder(Long exchangeOrderId) {
        boolean exists = exchangeOrderRepository.existsById(exchangeOrderId);
        if(!exists){
            throw new IllegalStateException("ExchangeOrder with id: "+exchangeOrderId+" does not exist.");
        }
        exchangeOrderRepository.deleteById(exchangeOrderId);
    }

    @Transactional
    public void updateExchangeOrder(Long exchangeOrderId, Double price, Integer quantity) {
        ExchangeOrder exchangeOrder = exchangeOrderRepository.findExchangeOrderById(exchangeOrderId).orElseThrow(() -> new IllegalStateException("ExchangeOrder with id " + exchangeOrderId + " does not exist."));

        if(price != null && !Objects.equals(exchangeOrder.getPrice(),price)){
            exchangeOrder.setPrice(price);
        }

        if(quantity !=null && !Objects.equals(exchangeOrder.getQuantity(), quantity)){
            Optional<ExchangeOrder> clientOrderOptional = exchangeOrderRepository.findExchangeOrderById(exchangeOrderId);
            exchangeOrder.setQuantity(quantity);
        }

    }
}
