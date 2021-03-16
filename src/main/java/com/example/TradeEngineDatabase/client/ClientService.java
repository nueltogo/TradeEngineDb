package com.example.TradeEngineDatabase.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientById(client.getClientId());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("Id already taken.");
        }
        clientRepository.save(client);
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if(!exists){
            throw new IllegalStateException("Student with id: "+clientId+" does not exist.");
        }
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public void updateClient(Long clientId, String name, String password, Double balance) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalStateException("Student with id " + clientId + " does not exist."));

        if(name != null && name.length() > 0 && !Objects.equals(client.getName(),name)){
            client.setName(name);
        }

        if(password !=null && password.length() > 0 && !Objects.equals(client.getPassword(), password)){
            Optional<Client> clientOptional = clientRepository.findClientById(clientId);
            client.setPassword(password);
        }

        if(balance != null && !Objects.equals(client.getBalance(),balance)){
            client.setBalance(balance);
        }

    }
}