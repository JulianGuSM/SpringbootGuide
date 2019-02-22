package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author : Julian
 * @date : 2019/2/22 14:42
 * 我们需要配置Spring来开启WebSocket和STOMP消息传递
 *
 * WebSocketConfiguration用了@Configuration来表明这是一个Spring configuration类
 * 还使用了@EnableWebSocketMessageBroker，正如它的名字一样，它开启了WebSocket消息处理
 * 由一个消息代理支持
 *
 * configureMessageBroker()方法实现了在WebSocketMessageBroker中定义的默认方法来
 * 配置消息代理
 * 它首先调用enableSimpleBroker()来启用一个简单的基于内存的消息代理，将问候消息传回
 * 前缀为"/topic"的客户端
 *
 * 它还为绑定到@MessageMapping方法的消息制定了"/app"前缀
 * 这个前缀将用于定义所有的消息映射
 * 比如，"/app/hello"是GreetingController.greeting()方法映射到句柄的端点
 *
 * registerStompEndpoints()方法注册了一个"/gs-guide-websocket"  endpoint，启用
 * SockJS后备选项，以便在WebSocket不可用时可以使用备用传输
 *
 * SockJS客户端尝试链接到"/gs-guide-websocket"并使用最佳传输（websocket,xhr-streaming,xhr-polling等）
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
