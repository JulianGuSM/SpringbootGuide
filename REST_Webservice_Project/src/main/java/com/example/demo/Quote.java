package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author : Julian
 * @date : 2019/2/20 15:24
 *
 * 正如你所看见的，这是一个简单的java类，带有一系列的属性和相对应的get&set方法
 * 它使用Jackson JSON 处理库中的@JsonIgnoreProperties进行注释来表示应忽略在此类型中未绑定的任何属性
 *
 * 为了能够让你直接绑定你的数据到你的自定义类型，你需要指定变量名和API中的JSON文档中规定的名称完全相同
 * 万一JSON doc中的变量名称和键不匹配，需要使用@JsonProperty批注指定JSON文档的确切键
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" + "type='" + type + '\'' + ",value=" + value + "}";
    }
}
