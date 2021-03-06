package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.interfaces.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return (args -> {
           //save a couple of customers
            repository.save(new Customer("Jack", "FFF"));
            repository.save(new Customer("AAA", "BBB"));
            repository.save(new Customer("CCC", "DDD"));
            repository.save(new Customer("EEE", "GGG"));
            repository.save(new Customer("HHH", "III"));

            //fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer c :repository.findAll() ) {
                log.info(c.toString());
            }
            log.info("");
            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('III'):");
            log.info("--------------------------------------------");
            repository.findByLastName("III").forEach(bauer -> {
                log.info(bauer.toString());
            });
        });
    }

}
