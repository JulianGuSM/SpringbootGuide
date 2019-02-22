package com.example.demo.controller;

import com.example.demo.Greeting;
import com.example.demo.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * @author : Julian
 * @date : 2019/2/22 14:07
 *
 * 这个控制器接受hello message并且发送greeting message
 *
 * 在Spring中使用STOMP消息传递方法，STOMP消息可以路由到@Control类
 * 例如GreetingController被映射要处理目标地址"/hello"
 *
 * MessageMapping注释保证了如果消息被发送到“/hello”，那么greeting()方法会被调用
 * 消息的有效负载绑定在HelloMessage对象，该对象传递给greeting()
 *
 * 在内部，该方法的实现通过使线程休眠1秒中来模拟处理延迟
 * 这是为了掩饰客户端发送消息后，只要需要异步处理消息，服务器就可以使用
 * 客户端可以继续它需要做的任何工作而无须等待响应
 *
 * 在1秒的延迟后，greeting()方法创建了一个Greeting对象并返回
 * 返回值将广播给@SendTo注释中所指定的"/topic/greetings"的所有订阅者
 * 注意，输入消息中的名称已经被清理，因为在这种情况下，它将被回显并在客户端的浏览器DOM中重现
 *
 */
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception{
        Thread.sleep(1000);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()));
    }
}
