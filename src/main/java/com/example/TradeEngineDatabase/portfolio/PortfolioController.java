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

    @GetMapping("/all")
    public List<Portfolio> getPortfolios() {
        return portfolioService.getPortfolios();
    }

//    @PostMapping("/get")
//    public Portfolio getPortfolio(@RequestBody Portfolio portfolio) throws IllegalStateException {
//        return portfolioService.getPortfolio(portfolio.getName(),portfolio.getClientId());
//    }

    @PostMapping("/new")
    public void addNewPortfolio(@RequestBody Portfolio portfolio) throws IllegalStateException {
        portfolioService.addNewPortfolio(portfolio);
    }

    @DeleteMapping("/delete/{portfolioId}")
    public void deleteClient(@PathVariable("portfolioId") Long portfolioId) throws IllegalStateException {
        portfolioService.deletePortfolio(portfolioId);
    }

}
