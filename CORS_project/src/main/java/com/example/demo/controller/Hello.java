package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Julian
 * @date : 2019/2/21 9:55
 */

@Controller
public class Hello {
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }
}
