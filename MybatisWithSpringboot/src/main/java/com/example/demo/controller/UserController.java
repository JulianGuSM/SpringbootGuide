package com.example.demo.controller;

import com.example.demo.beans.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Julian
 * @date : 2019/4/3 10:44
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

    @RequestMapping("/queryAllUsers")
    public List<User> queryAllUsers(){
        return userService.selectAllUsers();
    }

    @RequestMapping("/insertUsers")
    public String insertUsers(){
        userService.insertUsers();
        return "insert success";
    }

    @RequestMapping("/changeMoney")
    public List<User> changeMoney(){
        userService.changeMoney();
        return userService.selectAllUsers();
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(){
        userService.deleteUser(1);
        return "delete success";
    }
}
