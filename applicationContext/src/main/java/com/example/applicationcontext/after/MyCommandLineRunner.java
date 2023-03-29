package com.example.applicationcontext.after;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * spring启动完成后回调
 * 此方法回调位于{@link org.springframework.boot.SpringApplication#callRunners(ApplicationContext, ApplicationArguments)}
 *
 *
 * @author maonengneng
 * @date 2023/03/29
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    /**
     * 运行
     *
     * @param args 启动项目时输入的参数
     */
    @Override
    public void run(String... args) {
        System.out.println("CommandLineRunner--execute");
        System.out.println("args = " + Arrays.toString(args));
    }
}
