package com.example.applicationcontext;

import com.example.applicationcontext.event.TestEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SpringBootApplication
public class ApplicationContextApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationContextApplication.class, args);
        TestEvent testEvent = new TestEvent(new Object());
        testEvent.setMessage("发布事件");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        testEvent.setTime(LocalDateTime.now().format(formatter));
        run.publishEvent(testEvent);
    }

}
