//package com.example.TradeEngineDatabase.clientorder;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static java.time.Month.JANUARY;
//@Configuration
//public class ClientOrderConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(ClientOrderRepository repository){
//        return args -> {
//            ClientOrder orderOne = new ClientOrder(
//                    "AAPL",
//                    3.00,
//                    200,
//                    "SELL",
//                    2,
//                    5,
//                    "VALIDATED",
//                    "PENDING",
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//            ClientOrder orderTwo = new ClientOrder(
//                    "AMZ",
//                    3.00,
//                    200,
//                    "BUY",
//                    2,
//                    5,
//                    "VALIDATED",
//                    "PENDING",
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//
//            repository.saveAll(
//                    List.of(orderOne,orderTwo)
//            );
//
//        };
//    };
//}
