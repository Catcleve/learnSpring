package com.spring.study.model;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String seyHello(String name) {
        System.out.println("HelloServiceImpl.seyHello");
        return "Hello " + name;
    }
}
