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

    @GetMapping("/all")
    public List<ClientOrder> getClientOrders() {
        return clientOrderService.getClientOrders();
    }

    @PostMapping("/get")
    public ClientOrder getClientOrder(@RequestBody ClientOrder clientOrder){
        return clientOrderService.getClientOrder(clientOrder);
    }

    @PostMapping("/new")
    public void registerNewClientOrder(@RequestBody ClientOrder clientOrder) {
        clientOrderService.addNewClientOrder(clientOrder);
    }

    @DeleteMapping("/delete/{clientOrderId}")
    public void deleteClientOrder(@PathVariable("clientOrderId") Long clientOrderId) {
        clientOrderService.deleteClientOrder(clientOrderId);
    }

    @PutMapping("/update/{clientOrderId}")
    public void updateClientOrder(
            @PathVariable("clientOrderId") Long clientOrderId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Integer quantity
    ) {
        clientOrderService.updateClientOrder(clientOrderId, price, quantity);
    }
}
