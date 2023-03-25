package com.example.applicationcontext.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestBeanFactoryProcessor {

    @Value("张三")
    private String username;
    @Value("${test.password}")
    private String password;

}
