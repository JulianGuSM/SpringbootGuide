package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Julian
 * @date : 2019/2/20 14:46
 * Scheduled注释定义了一个特定方法何时运行
 * 注意：这个示例使用了fixedRate，它定义了方法的调用周期
 * 还有其他的选项，比如fixedDelay，它定义了延时多长时间开始第一次运行
 * 你还可以使用@Scheduled(cron = "...")表达式来进行更复杂的任务调度
 */
@Component
public class ScheduledTask {
    public static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
