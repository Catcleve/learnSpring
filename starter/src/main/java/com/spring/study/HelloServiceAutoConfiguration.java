package com.spring.study;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 自动配置类 注意看有一个配置文件的图标
 * 这个包就是一个单纯的starter以供别的包引入，不用同包名
 *
 * @author maonengneng
 * @date 2023/05/21
 */
@AutoConfiguration
@ComponentScan({"com.spring.study.model"})
public class HelloServiceAutoConfiguration {
}
