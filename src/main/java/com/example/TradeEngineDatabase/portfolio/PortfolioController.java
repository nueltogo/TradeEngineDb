package com.example.TradeEngineDatabase.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/all")
    public List<Portfolio> getPortfolios() {
        return portfolioService.getPortfolios();
    }

    @PostMapping("/get")
    public Portfolio getPortfolio(@RequestBody Portfolio portfolio) throws IllegalStateException {
        return portfolioService.getPortfolio(portfolio.getName(),portfolio.getClientId());
    }

    @GetMapping("/id/{id}")
    public Portfolio getPortfolioId(@PathVariable("id") long id){
        return portfolioService.getPortfolioByPortId(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Portfolio> getPortfolioById(@PathVariable("clientId") long clientId) throws IllegalStateException {
        return portfolioService.getPortfolioById(clientId);
    }

    @PostMapping("/new")
    public Portfolio addNewPortfolio(@RequestBody Portfolio portfolio) throws IllegalStateException {
        return portfolioService.addNewPortfolio(portfolio);
    }

    @DeleteMapping("/delete/{portfolioId}")
    public void deleteClient(@PathVariable("portfolioId") Long portfolioId) throws IllegalStateException {
        portfolioService.deletePortfolio(portfolioId);
    }

}
