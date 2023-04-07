package com.example.applicationcontext.aop.advisor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJTest {

    @Pointcut("execution(* com.example.applicationcontext.aop.service.*.*.test(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("before原方法");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("after原方法");
    }

    //@Around("test()")
    public Object aroundTest(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("aroundBefore原方法");
            joinPoint.proceed();
            System.out.println("aroundAfter原方法");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}
