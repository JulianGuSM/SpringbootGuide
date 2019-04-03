package com.example.demo.service;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Julian
 * @date : 2019/4/3 10:17
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User selectUserByName(String name){
        return userDao.findUserByName(name);
    }

    public List<User> selectAllUsers(){
        return userDao.findAllUser();
    }

    public void insertUsers(){
        userDao.insertUser("Julian", 22, 1000.0);
        userDao.insertUser("Jenny", 18, 20000.0);
    }

    public void deleteUser(int id){
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务
     * 由于添加@Transactional,如果转账中途出了意外，两个用户的账户余额都不会改变
     */
    @Transactional(rollbackFor = Exception.class)
    public void changeMoney(){
        userDao.updateUser("Julian", 22, 2000.0, 3);
        //模拟转账过程中可能发生的意外状况
        int temp = 1 / 0;
        userDao.updateUser("Jenny", 18, 19000.0, 4);
    }
}
