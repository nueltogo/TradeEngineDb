//package com.example.TradeEngineDatabase.portfolio;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PortfolioService {
//    private final PortfolioRepository portfolioRepository;
//
//    @Autowired
//    public PortfolioService(PortfolioRepository portfolioRepository) {
//        this.portfolioRepository = portfolioRepository;
//    }
//
//    public void addNewPortfolio(Portfolio portfolio) {
//        Optional<Portfolio> portfolioOptional = portfolioRepository.findPortfolioById(portfolio.getPortfolioId());
//        if(portfolioOptional.isPresent()){
//            throw new IllegalStateException("Id already taken.");
//        }
//        portfolioRepository.save(portfolio);
//    }
//
//    public List<Portfolio> getPortfolios(){
//        return portfolioRepository.findAll();
//    }
//
//    public Portfolio getPortfolio(String name, long clientId) {
//        Optional<Portfolio> portfolioOptional = portfolioRepository.findPortfolioByClientIdAndName(name,clientId);
//        if(portfolioOptional.isPresent()){
//            return  portfolioOptional.get();
//        }
//        throw new IllegalStateException("Portfolio does not exist");
//    }
//
//    public void deletePortfolio(Long portfolioId) {
//        boolean exists = portfolioRepository.existsById(portfolioId);
//        if(!exists){
//            throw new IllegalStateException("Portfolio with id: "+portfolioId+" does not exist.");
//        }
//        portfolioRepository.deleteById(portfolioId);
//    }
//
//
//}
