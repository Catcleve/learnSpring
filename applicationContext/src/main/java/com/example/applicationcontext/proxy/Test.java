package com.example.applicationcontext.proxy;

import com.example.applicationcontext.proxy.handler.MyInvocationHandler;
import com.example.applicationcontext.proxy.service.UserService;
import com.example.applicationcontext.proxy.service.UserServiceImpl;

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
