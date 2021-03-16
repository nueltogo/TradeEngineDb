//package com.example.TradeEngineDatabase.product;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static java.time.Month.JANUARY;
//
//@Configuration
//public class ProductConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(ProductRepository repository){
//        return args -> {
//            Product GOOGL = new Product(
//                    "GOOGL",
//                    2,
//                    20,
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//            Product MSFT = new Product(
//                    "MSFT",
//                    2,
//                    20,
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//
//            repository.saveAll(
//                    List.of(GOOGL,MSFT)
//            );
//
//        };
//    };
//}
