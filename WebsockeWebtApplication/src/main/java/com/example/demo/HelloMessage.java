package com.example.demo;

/**
 * @author : Julian
 * @date : 2019/2/22 14:03
 *
 * 为了模拟带有名字的消息，要创建一个HelloMessage类，具有一个name属性和一个getName方法
 */
public class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
