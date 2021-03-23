package com.example.TradeEngineDatabase.client;

import com.example.TradeEngineDatabase.portfolio.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PortfolioRepository portfolioRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, PortfolioRepository portfolioRepository) {
        this.clientRepository = clientRepository;
        this.portfolioRepository = portfolioRepository;
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("Email already taken.");
        }
        clientRepository.save(client);
        portfolioRepository.save(client.getPortfolios().get(0));
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByEmailAndPass(client.getEmail(), client.getPassword());
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }
        throw new IllegalStateException("Invalid Credentials");
    }

    public Client getClientId(Client client){
        Optional<Client> clientOptional = clientRepository.findClientById(client.getClientId());
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }
        throw new IllegalStateException("Client with id "+client.getClientId()+" does not exist");
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
        Client client = clientRepository.findClientById(clientId).orElseThrow(() -> new IllegalStateException("Student with id " + clientId + " does not exist."));

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
