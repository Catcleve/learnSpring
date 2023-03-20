package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 测试自动装备
 *
 * @author maonengneng
 * @date 2023/02/27
 * @see Profile 使用此注解可以配合配置文件加载指定的bean，
 * 没有此注解的bean会被所有环境加载。
 * 如果配置文件没有指定环境 但是使用了此注解指定了环境，则加载不到此beanTestAutoWirBean
 */

@Component("123")
public class TestAutoWirBean {

    private TestBean testBean;
}
