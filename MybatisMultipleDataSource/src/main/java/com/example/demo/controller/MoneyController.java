package com.example.demo.controller;

import com.example.demo.beans.Money;
import com.example.demo.db2.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Julian
 * @date : 2019/4/3 16:47
 */
@RestController
@RequestMapping("/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @RequestMapping("/query")
    public Money queryMoney(){
        return moneyService.selectMoneyById(1);
    }
}
