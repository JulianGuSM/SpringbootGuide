package com.example.demo.controller;

import com.example.demo.Hello;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : Julian
 * @date : 2019/2/21 8:35
 */

@RestController
public class HelloController {

    public static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin()
    @GetMapping("/hello")
    public Hello hello(@RequestParam(required = false, defaultValue = "World") String name){
        System.out.println("=====in greeting======");
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }
}
