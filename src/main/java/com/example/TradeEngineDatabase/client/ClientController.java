package com.example.TradeEngineDatabase.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping(path = "getclient")
    public Client getClient(@RequestBody Client client){
        return clientService.getClient(client);
    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId) {
        clientService.deleteClient(clientId);
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long clientId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) Double balance
    ) {
        clientService.updateClient(clientId, name, password, balance);
    }
}
