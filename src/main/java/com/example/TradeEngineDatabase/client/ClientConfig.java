//package com.example.TradeEngineDatabase.client;
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
//public class ClientConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(ClientRepository repository){
//        return args -> {
//            Client nunana = new Client(
//                    "Nunana",
//                    "Nunana@gmail.com",
//                    "what is app",
//                    100.50,
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//            Client togo = new Client(
//                    "Togo",
//                    "Togo@gmail.com",
//                    "what is app",
//                    100.50,
//                    LocalDate.of(1996, JANUARY, 8)
//            );
//
//            repository.saveAll(
//                    List.of(nunana,togo)
//            );
//
//        };
//    };
//}
