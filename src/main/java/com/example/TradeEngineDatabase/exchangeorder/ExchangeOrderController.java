package com.example.TradeEngineDatabase.exchangeorder;

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

    @GetMapping("/all")
    public List<ExchangeOrder> getExchangeOrders() throws IllegalStateException {
        return exchangeOrderService.getExchangeOrders();
    }

    @PostMapping("/get")
    public ExchangeOrder getExchangeOrder(@RequestBody ExchangeOrder exchangeOrder) throws IllegalStateException {
        return exchangeOrderService.getExchangeOrder(exchangeOrder);
    }

    @PostMapping("/new")
    public void addExchangeOrder(@RequestBody ExchangeOrder exchangeOrder) throws IllegalStateException {
        exchangeOrderService.addNewExchangeOrder(exchangeOrder);
    }

    @DeleteMapping("/delete/{exchangeOrderId}")
    public void deleteClient(@PathVariable("exchangeOrderId") Long exchangeOrderId) throws IllegalStateException {
        exchangeOrderService.deleteExchangeOrder(exchangeOrderId);
    }


    @PutMapping("/update/{exchangeOrderId}")
    public void updateExchangeOrder(
            @PathVariable("exchangeOrderId") String exchangeOrderId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Integer quantity
    ) throws IllegalStateException {
        exchangeOrderService.updateExchangeOrder(exchangeOrderId, price, quantity);
    }
}
