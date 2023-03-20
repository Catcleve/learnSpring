package com.wang.learn;

public class MyThreadLocal {

    /**
     * 这里要改成 static final 变成类变量，免得出现内存溢出现象
     */
    public static final ThreadLocal<User> threadLocal = ThreadLocal.withInitial(() -> {
        User user = new User();
        user.setUsername(Thread.currentThread().getName());
        return user;
    });

    public User get(){
        return threadLocal.get();
    }

    public void put(User user){
        threadLocal.set(user);
    }
}
