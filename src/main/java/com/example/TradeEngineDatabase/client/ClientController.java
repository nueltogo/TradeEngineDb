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

    @GetMapping("/all")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping("/login")
    public Client getClient(@RequestBody Client client) throws IllegalStateException {
        return clientService.getClient(client);
    }

    @PostMapping("/id")
    public Client getClientId(@RequestBody Client client) throws IllegalStateException {
        return clientService.getClientId(client);
    }

    @PostMapping("/register")
    public void registerNewClient(@RequestBody Client client) throws IllegalStateException {
        clientService.addNewClient(client);
    }

    @DeleteMapping("/unregister/{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId) throws IllegalStateException {
        clientService.deleteClient(clientId);
    }

    @PutMapping("/update/{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long clientId,
            @RequestParam(value="name",required = false) String name,
            @RequestParam(value="password",required = false) String password,
            @RequestParam() Double balance
    ) throws IllegalStateException {
        System.out.println(balance);
        clientService.updateClient(clientId, name, password, balance);
    }
}
