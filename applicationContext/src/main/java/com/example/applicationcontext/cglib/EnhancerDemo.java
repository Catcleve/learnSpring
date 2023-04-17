package com.example.applicationcontext.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB增强程序演示
 *
 * @author maonengneng
 * @date 2023/04/17
 */
public class EnhancerDemo {
    public static void main(String[] args) {
        //CGLIB使用演示
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MyMethodInterceptor());
        EnhancerDemo demo = (EnhancerDemo) enhancer.create();
        demo.test();
        System.out.println(demo);
    }

    /**
     *
     */
    public void test() {
        System.out.println("EnhancerDemo.test()");
    }


    /**
     *
     * @author maonengneng
     * @date 2023/04/17
     */
    public static class MyMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before invoke" + method);
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after invoke" + method);
            return result;
        }
    }
}
