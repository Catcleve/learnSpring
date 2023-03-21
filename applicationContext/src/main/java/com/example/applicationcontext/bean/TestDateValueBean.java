package com.example.applicationcontext.bean;


import com.example.applicationcontext.convert.DatePropertyEditor;
import lombok.Data;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.support.ResourceEditorRegistrar;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 测试日期自动注入
 *
 * spring中默认的类型转换解析器加载位置：
 * 1、{@link ResourceEditorRegistrar#registerCustomEditors(PropertyEditorRegistry)}
 * 此方法会在初始化bean时调用 {@link AbstractAutowireCapableBeanFactory#doCreateBean(String, RootBeanDefinition, Object[])}
 * 2、{@link PropertyEditorRegistrySupport#createDefaultEditors()}会在获取转换器时创建默认的很多个转换器
 *
 *
 *
 * @author maonengneng
 * @date 2023/03/21
 */
@Data
@Component
public class TestDateValueBean {

    /**
     * 日期
     * 这里如果使用 @Value("2023-03-15") 直接注入 会报错
     * Failed to convert value of type 'java.lang.String' to required type 'java.util.Date'
     * 意思是 string 转为 date类型失败
     * 解决方法：1，使用自定义属性编辑器 {@link DatePropertyEditor}
     * 2、使用注解 @DateTimeFormat(pattern = "yyyy-MM-dd")
     *
     * 使用配置类优先级比注解高，当同时存在时，优先使用配置类
     *
     */
    @Value("2023-03-15")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String longTest;

}
