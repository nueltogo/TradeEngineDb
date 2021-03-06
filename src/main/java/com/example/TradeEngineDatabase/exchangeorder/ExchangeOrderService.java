package com.example.TradeEngineDatabase.exchangeorder;

import com.example.TradeEngineDatabase.clientorder.ClientOrder;
import com.example.TradeEngineDatabase.clientorder.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExchangeOrderService {
    private final ExchangeOrderRepository exchangeOrderRepository;
    private final ClientOrderRepository clientOrderRepository;

    @Autowired
    public ExchangeOrderService(ExchangeOrderRepository exchangeOrderRepository,
                                ClientOrderRepository clientOrderRepository){
        this.exchangeOrderRepository = exchangeOrderRepository;
        this.clientOrderRepository = clientOrderRepository;
    }

    public void addNewExchangeOrder(ExchangeOrder exchangeOrder) {
        System.out.println(exchangeOrder);
        Long clientOrderid = exchangeOrder.getClientOrderId();
        ClientOrder clientOrder = clientOrderRepository.getOne(clientOrderid);
        exchangeOrder.setClientorder(clientOrder);
        clientOrder.setOrders(exchangeOrder);
        Optional<ExchangeOrder> exchangeOrderOptional = exchangeOrderRepository.findByExchangeOrderId(exchangeOrder.getExchangeOrderId());
        if(exchangeOrderOptional.isPresent()){
            throw new IllegalStateException("Id already taken.");
        }
        exchangeOrderRepository.save(exchangeOrder);
    }

    public List<ExchangeOrder> getExchangeOrders(){
        return exchangeOrderRepository.findAll();
    }

    public ExchangeOrder getExchangeOrder(ExchangeOrder exchangeOrder){
        System.out.println(exchangeOrder.getExchangeOrderId());
        Optional<ExchangeOrder> exchangeOrderOptional = exchangeOrderRepository.findByExchangeOrderId(exchangeOrder.getExchangeOrderId());
        if(exchangeOrderOptional.isPresent()){
            return exchangeOrderOptional.get();
        }
        throw new IllegalStateException("Exchange Order with id "+exchangeOrder.getExchangeOrderId()+" does not exist.");
    }

    public List<ExchangeOrder> getByClientOrder(long clientOrderId){
        Optional<List<ExchangeOrder>> exchangeOrders = exchangeOrderRepository.findByClientorder_ClientOrderId(clientOrderId);
        if(exchangeOrders.isPresent()){
            return exchangeOrders.get();
        }
        throw new IllegalStateException("Exchange Order with client order id "+clientOrderId+" does not exist.");
    }

    public List<ExchangeOrder> getByStatus(String status){
        Optional <List<ExchangeOrder>> exchangeOrders = exchangeOrderRepository.findByStatus(status);
        if(exchangeOrders.isPresent()){
            return exchangeOrders.get();
        }
        throw new IllegalStateException("Exchange Order with status "+status+" does not exist.");
    }

    public void deleteExchangeOrder(String exchangeOrderId) {
        Optional<ExchangeOrder> exchangeOrderOptional = exchangeOrderRepository.findByExchangeOrderId(exchangeOrderId);
        if(!exchangeOrderOptional.isPresent()){
            throw new IllegalStateException("ExchangeOrder with id: "+exchangeOrderId+" does not exist.");
        }
        exchangeOrderRepository.deleteByExchangeOrderId(exchangeOrderId);
    }

    public Boolean checkStatus(String exchangeOrderId, int exchange){
        String baseURl;
        final String privateKey = "6b055a2f-c488-4386-83b8-e9f30c773d35";

        switch (exchange) {
            case 1 -> baseURl = "https://exchange.matraining.com/"+privateKey+"/order/"+exchangeOrderId;
            case 2 -> baseURl = "https://exchange2.matraining.com/"+privateKey+"/order/"+exchangeOrderId;
            default -> throw new IllegalStateException("exchange does not exist");
        }

        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.getForObject(baseURl, ExchangeStatus.class);
            return false;
        }catch (Exception e){
            return true;
        }
    }

    @Transactional
    public void updateExchangeOrder(String exchangeOrderId, Double price, Integer quantity) {
        ExchangeOrder exchangeOrder = exchangeOrderRepository.findByExchangeOrderId(exchangeOrderId).orElseThrow(() -> new IllegalStateException("ExchangeOrder with id " + exchangeOrderId + " does not exist."));

        if(price != null && !Objects.equals(exchangeOrder.getPrice(),price)){
            exchangeOrder.setPrice(price);
        }

        if(quantity !=null && !Objects.equals(exchangeOrder.getQuantity(), quantity)){
            Optional<ExchangeOrder> clientOrderOptional = exchangeOrderRepository.findByExchangeOrderId(exchangeOrderId);
            exchangeOrder.setQuantity(quantity);
        }

    }

    @Transactional
    public String exchangeOrderCompleted (String exchangeOrderId, String Status){
        ExchangeOrder exchangeOrder = exchangeOrderRepository.findByExchangeOrderId(exchangeOrderId).orElseThrow(() -> new IllegalStateException("ClientOrder with id " + exchangeOrderId + " does not exist."));

        exchangeOrder.setStatus(Status);
        return "COMPLETED";
    }
}
