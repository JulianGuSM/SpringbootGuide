package com.example.demo.db2.service;

import com.example.demo.beans.Money;
import com.example.demo.db2.dao.MoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Julian
 * @date : 2019/4/3 16:37
 */
@Service
public class MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    public Money selectMoneyById(int id){
        return moneyDao.findMoneyById(id);
    }
}
