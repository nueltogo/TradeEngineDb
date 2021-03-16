//package com.example.TradeEngineDatabase.exchangeorder;
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
//public class ExchangeOrderConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(ExchangeOrderRepository repository){
//        return args -> {
//            ExchangeOrder exOne = new ExchangeOrder(
//                    "KNLO250",
//                    "TSLA",
//                    2.2,
//                    100,
//                    5,
//                    1,
//                    "Pending",
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//            ExchangeOrder exTwo = new ExchangeOrder(
//                    "KNLO256",
//                    "IBM",
//                    2.5,
//                    150,
//                    8,
//                    2,
//                    "Pending",
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//
//            repository.saveAll(
//                    List.of(exOne,exTwo)
//            );
//
//        };
//    };
//}
