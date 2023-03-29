package com.example.applicationcontext.listener;

import com.example.applicationcontext.event.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        Object source = event.getSource();
        System.out.println(event.getMessage());
        System.out.println(event.getTime());
    }
}
