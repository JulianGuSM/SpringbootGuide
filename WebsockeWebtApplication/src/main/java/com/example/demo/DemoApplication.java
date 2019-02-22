package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This application aims at building a websocket application
 * the application sends messages back and forth,between server and browser
 * WebSocket is a very thin,lightweight layer above TCP
 * it makes it very suitable to use "subprotocols" to embed message
 * we will use STOMP messaging with Spring to create an interactive web application
 * we will build a server that will accept a message carrying a user's name
 * In response, it will push a greeting into a queue that the client is subscribed to
 * @author Julian
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
