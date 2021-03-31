package com.example.TradeEngineDatabase.exchangeorder;

import com.example.TradeEngineDatabase.client.ClientService;
import com.example.TradeEngineDatabase.clientorder.ClientOrder;
import com.example.TradeEngineDatabase.clientorder.ClientOrderService;
import com.example.TradeEngineDatabase.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/exchangeorder")
public class ExchangeOrderController {
    private final ExchangeOrderService exchangeOrderService;
    private final ClientOrderService clientOrderService;
    private final ProductService productService;
    private final ClientService clientService;

    @Autowired
    public ExchangeOrderController(ExchangeOrderService exchangeOrderService,
                                   ClientOrderService clientOrderService,
                                   ProductService productService,
                                   ClientService clientService) {
        this.exchangeOrderService = exchangeOrderService;
        this.clientOrderService = clientOrderService;
        this.productService = productService;
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<ExchangeOrder> getExchangeOrders() throws IllegalStateException {
        return exchangeOrderService.getExchangeOrders();
    }

    @GetMapping("/clientorderid/{id}")
    public List<ExchangeOrder> getByClientOrder(@PathVariable("id") long id) throws IllegalStateException {
        return exchangeOrderService.getByClientOrder(id);
    }

    @GetMapping("/status/{status}")
    public List<ExchangeOrder> getByStatus(@PathVariable("status") String status) throws IllegalStateException {
        return exchangeOrderService.getByStatus(status);
    }

    @PostMapping("/get")
    public ExchangeOrder getExchangeOrder(@RequestBody ExchangeOrder exchangeOrder) throws IllegalStateException {
        return exchangeOrderService.getExchangeOrder(exchangeOrder);
    }

    @PostMapping("/new")
    public void addExchangeOrder(@RequestBody ExchangeOrder exchangeOrder) throws IllegalStateException {
        System.out.println(exchangeOrder);
        System.out.println("here");
        exchangeOrderService.addNewExchangeOrder(exchangeOrder);
    }

    @DeleteMapping("/delete/{exchangeOrderId}")
    public void deleteClient(@PathVariable("exchangeOrderId") String exchangeOrderId) throws IllegalStateException {
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


    @Scheduled(fixedRate = 10000)
    public void updateClient(){
        System.out.println("Scheduled task has begun.");
        List<ExchangeOrder> orderList = exchangeOrderService.getByStatus("PENDING");
        List<ExchangeOrder> statusList = orderList.stream()
                .filter(x -> exchangeOrderService.checkStatus(x.getExchangeOrderId(),x.getExchange()))
                .collect(Collectors.toList());
        System.out.println("begin");
        System.out.println(statusList);
        statusList.forEach(x->exchangeOrderService.exchangeOrderCompleted(x.getExchangeOrderId(),"UPDATING"));
        List<ExchangeOrder> orderList1 = exchangeOrderService.getByStatus("UPDATING");
        List<ExchangeOrder> exorderlist = exchangeOrderService.getByStatus("UPDATING");
        System.out.println(exorderlist);
        exorderlist.forEach(x->exchangeOrderService.exchangeOrderCompleted(x.getExchangeOrderId(), "COMPLETED"));
        System.out.println(orderList1);
        orderList1.forEach(x->clientOrderService.ClientOrderCompleted(x.getClientOrderId(),"UPDATING"));
        List<ClientOrder> orderList2 = clientOrderService.getByStatus("UPDATING");
        List<ClientOrder> orderList3 = clientOrderService.getByStatus("UPDATING");
        List<ClientOrder> orderList4 = clientOrderService.getByStatus("UPDATING");
        List<ClientOrder> orderList5 = clientOrderService.getByStatus("UPDATING");
        System.out.println(orderList2);
        orderList2.stream().filter(x-> x.getSide().equals("BUY")).forEach(x->productService.updatePortfolio(x.getPortfolioId(),x.getProduct(),x.getQuantity(),x.getPrice(),x.getSide()));
        orderList3.stream().filter(x-> x.getSide().equals("SELL")).forEach(x->productService.updatePortfolio(x.getPortfolioId(),x.getProduct(),-(x.getQuantity()),x.getPrice(),x.getSide()));
        orderList4.stream().filter(x-> x.getSide().equals("BUY")).forEach(x->clientService.updateBAlClient(x.getClientId(),-(x.getPrice()*x.getQuantity())));
        orderList5.stream().filter(x-> x.getSide().equals("SELL")).forEach(x->clientService.updateBAlClient(x.getClientId(),(x.getPrice()*x.getQuantity())));
        List<ClientOrder> orderList6 = clientOrderService.getByStatus("UPDATING");
        orderList6.forEach(x->clientOrderService.ClientOrderCompleted(x.getClientOrderId(),"COMPLETED"));
    }
}
