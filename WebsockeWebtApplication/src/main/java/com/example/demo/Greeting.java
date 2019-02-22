package com.example.demo;

/**
 * @author : Julian
 * @date : 2019/2/22 14:06
 *
 * 一旦接受到消息并提取name属性后，服务器将通过创建一个greeting并且在客户端订阅的
 * 单独队列上发布该greeting来处理它，greeting也是一个JSON对象，大概长这样：
 * {
 *     "content": "Hello, Fred!"
 * }
 * 为了模拟greeting，你要添加一个Greeting类，带有content属性和对于的getContent方法
 */
public class Greeting {
    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
