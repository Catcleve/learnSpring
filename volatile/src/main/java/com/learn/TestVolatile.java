package com.learn;

import java.util.concurrent.*;

public class TestVolatile {

    private static volatile boolean aBoolean = true;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            while (aBoolean) {
                try {
                    Thread.sleep(10);
                    System.out.println("执行任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(() -> {
            aBoolean = false;
        });
    }

}
