package com.example.TradeEngineDatabase.exchangeorder;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/exchangeorder")
public class ExchangeOrderController {
    private final ExchangeOrderService exchangeOrderService;

    @Autowired
    public ExchangeOrderController(ExchangeOrderService exchangeOrderService) {
        this.exchangeOrderService = exchangeOrderService;
    }

    @GetMapping
    public List<ExchangeOrder> getExchangeOrders() {
        return exchangeOrderService.getExchangeOrders();
    }

    @PostMapping
    public void addExchangeOrder(@RequestBody ExchangeOrder exchangeOrder) {
        exchangeOrderService.addNewExchangeOrder(exchangeOrder);
    }

    @DeleteMapping(path = "{exchangeOrderId}")
    public void deleteClient(@PathVariable("exchangeOrderId") Long exchangeOrderId) {
        exchangeOrderService.deleteExchangeOrder(exchangeOrderId);
    }


    @PutMapping(path = "{exchangeOrderId}")
    public void updateExchangeOrder(
            @PathVariable("exchangeOrderId") Long exchangeOrderId,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) int quantity
    ) {
        exchangeOrderService.updateExchangeOrder(exchangeOrderId, price, quantity);
    }
}
