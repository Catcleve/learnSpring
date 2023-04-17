package com.example.applicationcontext.jdkproxy;

import com.example.applicationcontext.jdkproxy.handler.MyInvocationHandler;
import com.example.applicationcontext.jdkproxy.service.UserService;
import com.example.applicationcontext.jdkproxy.service.UserServiceImpl;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test(){
        UserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) handler.getProxy();
        System.out.println(Arrays.toString(proxy.getClass().getInterfaces()));
        proxy.test();
    }

}
