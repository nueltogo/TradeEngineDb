//package com.example.TradeEngineDatabase.clientorder;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class ClientOrderService {
//    private final ClientOrderRepository clientOrderRepository;
//
//    @Autowired
//    public ClientOrderService(ClientOrderRepository clientOrderRepository) {
//        this.clientOrderRepository = clientOrderRepository;
//    }
//
//    public void addNewClientOrder(ClientOrder clientOrder) {
//        Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findClientOrderById(clientOrder.getClientOrderId());
//        if(clientOrderOptional.isPresent()){
//            throw new IllegalStateException("Id already taken.");
//        }
//        clientOrderRepository.save(clientOrder);
//    }
//
//    public List<ClientOrder> getClientOrders(){
//        return clientOrderRepository.findAll();
//    }
//
//    public ClientOrder getClientOrder(ClientOrder clientOrder){
//        Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findClientOrderById(clientOrder.getClientOrderId());
//        if(clientOrderOptional.isPresent()){
//            return clientOrderOptional.get();
//        }
//        throw new IllegalStateException("Client Order with id "+clientOrder.getClientOrderId()+" does not exist");
//    }
//
//    public void deleteClientOrder(Long clientOrderId) {
//        boolean exists = clientOrderRepository.existsById(clientOrderId);
//        if(!exists){
//            throw new IllegalStateException("ClientOrder with id: "+clientOrderId+" does not exist.");
//        }
//        clientOrderRepository.deleteById(clientOrderId);
//    }
//
//    @Transactional
//    public void updateClientOrder(Long clientOrderId, Double price, Integer quantity) {
//        ClientOrder clientOrder = clientOrderRepository.findClientOrderById(clientOrderId).orElseThrow(() -> new IllegalStateException("ClientOrder with id " + clientOrderId + " does not exist."));
//
//        if(price != null && !Objects.equals(clientOrder.getPrice(),price)){
//            clientOrder.setPrice(price);
//        }
//
//        if(quantity !=null && !Objects.equals(clientOrder.getQuantity(), quantity)){
//            Optional<ClientOrder> clientOrderOptional = clientOrderRepository.findClientOrderById(clientOrderId);
//            clientOrder.setQuantity(quantity);
//        }
//
//    }
//}
