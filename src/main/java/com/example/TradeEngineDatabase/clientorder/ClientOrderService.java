package com.example.TradeEngineDatabase.clientorder;


import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.client.ClientRepository;
import com.example.TradeEngineDatabase.portfolio.Portfolio;
import com.example.TradeEngineDatabase.portfolio.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientOrderService {
    private final ClientOrderRepository clientOrderRepository;
    private final ClientRepository clientRepository;
    private final PortfolioRepository portfolioRepository;

    @Autowired
    public ClientOrderService(ClientOrderRepository clientOrderRepository,
                              ClientRepository clientRepository,
                              PortfolioRepository portfolioRepository) {
        this.clientOrderRepository = clientOrderRepository;
        this.clientRepository = clientRepository;
        this.portfolioRepository = portfolioRepository;
    }

    public ClientOrder addNewClientOrder(ClientOrder clientOrder) {
        long clientId = clientOrder.getClientId();
        Client client = clientRepository.getOne(clientId);
        long porfolioId = clientOrder.getPortfolioId();
        Portfolio portfolio = portfolioRepository.getOne(porfolioId);
        clientOrder.setClient(client);
        client.setOrders(clientOrder);
        clientOrder.setPortfolio(portfolio);
        portfolio.setClientOrders(clientOrder);
        Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findClientOrderById(clientOrder.getClientOrderId());
        if (clientOrderOptional.isPresent()) {
            throw new IllegalStateException("Id already taken.");
        }
        return clientOrderRepository.saveAndFlush(clientOrder);
    }

    public List<ClientOrder> getClientOrders() {
        return clientOrderRepository.findAll();
    }

    public ClientOrder getClientOrder(ClientOrder clientOrder) {
        Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findClientOrderById(clientOrder.getClientOrderId());
        if (clientOrderOptional.isPresent()) {
            return clientOrderOptional.get();
        }
        throw new IllegalStateException("Client Order with id " + clientOrder.getClientOrderId() + " does not exist");
    }

    public List<ClientOrder> getByClient(long clientId) {
        Optional<List<ClientOrder>> clientOrderOptional = clientOrderRepository.findByClient_ClientId(clientId);
        if (clientOrderOptional.isPresent()) {
            return clientOrderOptional.get();
        }
        throw new IllegalStateException("Client Order with  client id " + clientId + " does not exist");
    }

    public List<ClientOrder> getByPortfolio(long portfolioId) {
        Optional<List<ClientOrder>> clientOrderOptional = clientOrderRepository.findByPortfolio_PortfolioId(portfolioId);
        if (clientOrderOptional.isPresent()) {
            return clientOrderOptional.get();
        }
        throw new IllegalStateException("Client Order with  client id " + portfolioId + " does not exist");
    }

    public List<ClientOrder> getByStatus(String status) {
        Optional<List<ClientOrder>> clientOrderOptional = clientOrderRepository.findByStatus(status);
        if (clientOrderOptional.isPresent()) {
            return clientOrderOptional.get();
        }
        throw new IllegalStateException("Client Order with  status " + status + " does not exist");
    }

    public List<ClientOrder> getByStatusAndClientId(long clientid, String status) {
        Optional<List<ClientOrder>> clientOrderOptional = clientOrderRepository.findByClient_ClientIdAndStatus(clientid, status);
        if (clientOrderOptional.isPresent()) {
            return clientOrderOptional.get();
        }
        throw new IllegalStateException("Client Order with  status " + status + " does not exist");
    }

    public void deleteClientOrder(Long clientOrderId) {
        boolean exists = clientOrderRepository.existsById(clientOrderId);
        if (!exists) {
            throw new IllegalStateException("ClientOrder with id: " + clientOrderId + " does not exist.");
        }
        clientOrderRepository.deleteById(clientOrderId);
    }

    @Transactional
    public void updateClientOrder(Long clientOrderId, Double price, Integer quantity) {
        ClientOrder clientOrder = clientOrderRepository.findClientOrderById(clientOrderId).orElseThrow(() -> new IllegalStateException("ClientOrder with id " + clientOrderId + " does not exist."));

        if (price != null && !Objects.equals(clientOrder.getPrice(), price)) {
            clientOrder.setPrice(price);
        }

        if (quantity != null && !Objects.equals(clientOrder.getQuantity(), quantity)) {
            Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findClientOrderById(clientOrderId);
            clientOrder.setQuantity(quantity);
        }

    }

    @Transactional
    public String cancelClientOrder (Long clientOrderId){
        ClientOrder clientOrder = clientOrderRepository.findClientOrderById(clientOrderId).orElseThrow(() -> new IllegalStateException("ClientOrder with id " + clientOrderId + " does not exist."));

        if (clientOrder.getStatus().equals("PENDING")) {
            clientOrder.setStatus("CANCELLED");
            return "CANCELLED";
        }
        else{
            return "UNABLE TO CANCEL ORDER NOT PENDING";
        }
    }
}



