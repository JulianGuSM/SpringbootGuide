package com.example.demo.controller;

import com.example.demo.beans.User;
import com.example.demo.db1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Julian
 * @date : 2019/4/3 16:43
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryUser")
    public User queryUser(){
        return userService.selectUserByName("Julian");
    }
}
