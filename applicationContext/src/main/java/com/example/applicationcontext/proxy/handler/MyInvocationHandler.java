package com.example.applicationcontext.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK自带动态代理
 *
 * @author maonengneng
 * @date 2023/04/13
 */
public class MyInvocationHandler implements InvocationHandler {

    private final Object target;

    public MyInvocationHandler(Object object) {
        super();
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("---------增强");
        Object invoke = method.invoke(target, args);
        System.out.println("---------增强");
        return invoke;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }

    private void selfMethod() {
        System.out.println("自己的方法");
    }

}
