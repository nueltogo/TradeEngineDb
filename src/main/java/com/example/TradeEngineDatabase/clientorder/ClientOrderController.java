package com.example.TradeEngineDatabase.clientorder;

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

    @GetMapping("/clientid/{id}")
    public List<ClientOrder> getByClient(@PathVariable("id") long id) {
        return clientOrderService.getByClient(id);
    }

    @GetMapping("/portfolioid/{id}")
    public List<ClientOrder> getByPortfolio(@PathVariable("id") long id) {
        return clientOrderService.getByPortfolio(id);
    }

    @GetMapping("/status/{status}")
    public List<ClientOrder> getByPortfolio(@PathVariable("status") String status) {
        return clientOrderService.getByStatus(status);
    }

    @GetMapping("/status/{clientId}/{status}")
    public List<ClientOrder> getByPortfolio(@PathVariable("status") String status,
                                            @PathVariable("clientId") long clientId) {
        return clientOrderService.getByStatusAndClientId(clientId,status);
    }

    @PostMapping("/get")
    public ClientOrder getClientOrder(@RequestBody ClientOrder clientOrder) throws IllegalStateException {
        return clientOrderService.getClientOrder(clientOrder);
    }

    @PostMapping("/new")
    public long registerNewClientOrder(@RequestBody ClientOrder clientOrder) throws IllegalStateException {
        return clientOrderService.addNewClientOrder(clientOrder);
    }

    @DeleteMapping("/delete/{clientOrderId}")
    public void deleteClientOrder(@PathVariable("clientOrderId") Long clientOrderId) throws IllegalStateException {
        clientOrderService.deleteClientOrder(clientOrderId);
    }

    @PutMapping("/update/{clientOrderId}")
    public void updateClientOrder(
            @PathVariable("clientOrderId") Long clientOrderId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Integer quantity
    ) throws IllegalStateException {
        clientOrderService.updateClientOrder(clientOrderId, price, quantity);
    }

    @GetMapping("/cancel/{clientOrderId}")
    public String cancelClientOrder(@PathVariable("clientOrderId") Long clientOrderId) throws IllegalStateException {
        return clientOrderService.cancelClientOrder(clientOrderId);
    }
}
