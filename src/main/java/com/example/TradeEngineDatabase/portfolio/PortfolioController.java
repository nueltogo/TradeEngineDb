package com.example.TradeEngineDatabase.portfolio;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.client.ClientService;
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

    @GetMapping
    public List<Portfolio> getPortfolios() {
        return portfolioService.getPortfolios();
    }

    @PostMapping
    public void addNewPortfolio(@RequestBody Portfolio portfolio) {
        portfolioService.addNewPortfolio(portfolio);
    }

    @DeleteMapping(path = "{portfolioId}")
    public void deleteClient(@PathVariable("portfolioId") Long portfolioId) {
        portfolioService.deletePortfolio(portfolioId);
    }

}
