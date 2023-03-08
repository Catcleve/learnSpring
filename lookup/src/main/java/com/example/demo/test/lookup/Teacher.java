package com.example.demo.test.lookup;

import org.springframework.stereotype.Component;

@Component
public class Teacher extends User{

    @Override
    public void showMe() {
        System.out.println("我是教师");
    }
}
