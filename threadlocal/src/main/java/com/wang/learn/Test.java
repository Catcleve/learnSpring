package com.wang.learn;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    /**
     * 线程池的创建及各种参数
     */
    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,
            20,
            3,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100),
            new ThreadFactory() {
                private final AtomicInteger threadNum = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("Thread--" + threadNum.incrementAndGet());
                    return thread;
                }
            });

    static {
        //设置为没有活动线程时关闭线程池
        poolExecutor.allowCoreThreadTimeOut(true);
    }


    public static void main(String[] args) throws InterruptedException {

        MyThreadLocal local = new MyThreadLocal();
        User user = local.get();
        System.out.println("user = " + user);
        local.put(new User());
        System.out.println(local.get());
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            poolExecutor.execute(() -> {
                User localUser = local.get();
                localUser.setPassword("密码--" + finalI);
                System.out.println(local.get());
            });
        }

        //这里测试线程池的关闭
        Thread.sleep(4000);

        //关闭后再次启用
        poolExecutor.execute(() -> {
            System.out.println("重新使用线程池");
        });
    }

}
