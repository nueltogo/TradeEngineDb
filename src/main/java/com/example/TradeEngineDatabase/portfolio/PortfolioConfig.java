//package com.example.TradeEngineDatabase.portfolio;
//
//import com.example.TradeEngineDatabase.client.Client;
//import com.example.TradeEngineDatabase.client.ClientRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static java.time.Month.JANUARY;
//@Configuration
//public class PortfolioConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(PortfolioRepository repository){
//        return args -> {
//            Portfolio TECH = new Portfolio(
//                    "Tech",
//                    2
//            );
//            Portfolio TECH2 = new Portfolio(
//                    "Tech",
//                    1
//            );
//
//            repository.saveAll(
//                    List.of(TECH,TECH2)
//            );
//
//        };
//    };
//}
