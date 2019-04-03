package com.example.demo.db1.service;

import com.example.demo.beans.User;
import com.example.demo.db1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Julian
 * @date : 2019/4/3 16:35
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User selectUserByName(String name){
        return userDao.findUserByName(name);
    }
}
