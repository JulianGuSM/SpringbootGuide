package com.example.demo;

/**
 * @author : Julian
 * @date : 2019/2/21 8:23
 *
 * 服务器将会解决GET请求为hello页面，可以在查询字符串中带有一个name参数。
 * GET请求应该返回200表示ok的响应状态码，其中JSON位于hello的正文中，它应该
 * 看起来像这样：
 * {
 *     "id": 1,
 *     "content": "Hello World"
 * }
 *
 * id是hello的唯一标识符，content是hello的文本表示
 *
 *
 */
public class Hello {
    private final long id;
    private final String content;

    public Hello() {
        this.content = "";
        this.id = -1;
    }

    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
