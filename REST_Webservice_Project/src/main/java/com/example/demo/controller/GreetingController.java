package com.example.demo.controller;

import com.example.demo.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : Julian
 * @date : 2019/2/20 13:39
 * 使用@RestControl注释确保HTTP请求/greeting映射到greeting（）方法
 * 这个例子未指定GET、PUT、POST等等，因为@RequestMapping默认映射所有的
 * HTTP操作。使用@RequestMapping(method=GET)缩小此映射
 *
 * 注释@RequestParam将查询字符串参数名称的值绑定到greeting()方法的name参数中
 * 如果请求中不存在name参数，则使用“World”默认值
 *
 * 方法体的实现基于计数器的下一个值创建并返回具有id和content属性的新Greeting对象
 * 并使用问候语模板格式化给定名称
 *
 * 传统MVC 控制器和RESTful web service控制器的一个关键区别就是创建HTTP response主体的方式
 * 不依靠视图技术（View Technology）来执行将问候数据的服务器端呈现为HTML
 * 这个RESTful Web服务控制只是填充并返回一个Greeting对象
 * 该对象数据将会作为JSON被直接写入HTTP响应
 *
 * 本程序使用了Spring4 的 @RestController 这一新注解，它将Class标志为一个controller
 * 其中每个方法返回一个域对象而不是视图，这是@Controller和@ResponseBody汇总在一起的简写。
 *
 * Greeting对象必须转换为JSON，多亏有Spring的HTTP消息转换的支持，不必手动来做转换的工作，因为Jackson2已经在类路径下了
 * Spring的MappingJackson2HttpMessageConverter自动将Greeting实例转换为JSON
 *
 * 使用CrossOrigin注释能够为这个特定的方法开启跨域请求
 * 默认，它允许所有的源，所有的请求头，@RequestMapping注释中特定的HTTP方法和30分钟的maxAge
 * 你可以通过修改注释中的属性
 * （origins,methods,allowedHeaders,exposeHeaders,allowCredentials or maxAge）
 * 来自定义它的行为
 * 在本例中，我们只允许http：//localhost：8080发送跨域请求
 */
@RestController
public class GreetingController {

    public static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
