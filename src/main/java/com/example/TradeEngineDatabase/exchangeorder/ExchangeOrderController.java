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
    public List<ExchangeOrder> getExchangeOrders() {
        return exchangeOrderService.getExchangeOrders();
    }

    @PostMapping("/get")
    public ExchangeOrder getExchangeOrder(@RequestBody ExchangeOrder exchangeOrder){
        return exchangeOrderService.getExchangeOrder(exchangeOrder);
    }

    @PostMapping("/new")
    public void addExchangeOrder(@RequestBody ExchangeOrder exchangeOrder) {
        exchangeOrderService.addNewExchangeOrder(exchangeOrder);
    }

    @DeleteMapping("/delete/{exchangeOrderId}")
    public void deleteClient(@PathVariable("exchangeOrderId") Long exchangeOrderId) {
        exchangeOrderService.deleteExchangeOrder(exchangeOrderId);
    }


    @PutMapping("/update/{exchangeOrderId}")
    public void updateExchangeOrder(
            @PathVariable("exchangeOrderId") String exchangeOrderId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Integer quantity
    ) {
        exchangeOrderService.updateExchangeOrder(exchangeOrderId, price, quantity);
    }
}
