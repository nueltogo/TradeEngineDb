package com.example.TradeEngineDatabase.portfolio;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, ClientRepository clientRepository) {
        this.portfolioRepository = portfolioRepository;
        this.clientRepository = clientRepository;
    }

    public Portfolio addNewPortfolio(Portfolio portfolio) {
        Long id = portfolio.getClientId();
        Client client = clientRepository.getOne(id);
        portfolio.setClient(client);
        client.setPortfolios(portfolio);
        Optional<Portfolio> portfolioOptional = portfolioRepository.findPortfolioById(portfolio.getPortfolioId());
        if(portfolioOptional.isPresent()){
            throw new IllegalStateException("Id already taken.");
        }
        Portfolio portfolio1 = portfolioRepository.save(portfolio);
        portfolioRepository.flush();
        return portfolio1;
    }

    public List<Portfolio> getPortfolios(){
        return portfolioRepository.findAll();
    }

    public Portfolio getPortfolio(String name, long clientId) {
        Optional<Portfolio> portfolioOptional = portfolioRepository.findByClient_ClientIdAndName(clientId, name);
        if(portfolioOptional.isPresent()){
            return  portfolioOptional.get();
        }
        throw new IllegalStateException("Portfolio does not exist");
    }

    public List<Portfolio> getPortfolioById(long clientId){
        Optional<List<Portfolio>> portfolioOptional = portfolioRepository.findByClient_ClientId(clientId);
        if(portfolioOptional.isPresent()){
            return  portfolioOptional.get();
        }
        throw new IllegalStateException("id does not exist");
    }

    public void deletePortfolio(Long portfolioId) {
        boolean exists = portfolioRepository.existsById(portfolioId);
        if(!exists){
            throw new IllegalStateException("Portfolio with id: "+portfolioId+" does not exist.");
        }
        portfolioRepository.deleteById(portfolioId);
    }


}
