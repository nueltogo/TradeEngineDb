package com.example.TradeEngineDatabase.clientorder;

import com.example.TradeEngineDatabase.client.Client;
import com.example.TradeEngineDatabase.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/clientorder")
public class ClientOrderController {
    private final ClientOrderService clientOrderService;

    @Autowired
    public ClientOrderController(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @GetMapping
    public List<ClientOrder> getClientOrders() {
        return clientOrderService.getClientOrders();
    }

    @PostMapping
    public void registerNewClientOrder(@RequestBody ClientOrder clientOrder) {
        clientOrderService.addNewClientOrder(clientOrder);
    }

    @DeleteMapping(path = "{clientOrderId}")
    public void deleteClientOrder(@PathVariable("clientOrderId") Long clientOrderId) {
        clientOrderService.deleteClientOrder(clientOrderId);
    }

    @PutMapping(path = "{clientOrderId}")
    public void updateClientOrder(
            @PathVariable("clientOrderId") Long clientOrderId,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) int quantity
    ) {
        clientOrderService.updateClientOrder(clientOrderId, price, quantity);
    }
}
