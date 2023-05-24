package com.example.applicationcontext.configbean;

import com.example.applicationcontext.bean.TestBean;
import com.example.applicationcontext.bean.TestConfigurationBean;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true)
//如果这里设置为 false ，那么testConfigurationBean()和testConfigurationBean1()方法中的
// testBean属性将会是两个不同的bean
// 如果为true，那么会创建 MyConfig类的代理类 从而使testBean()方法返回的bean为单例池中的bean
public class MyConfig {



    /**
     * 自定义编辑器配置
     * #@Bean注解，当方法参数为bean时，可以直接从容器中拿出bean来填充
     *
     * @param datePropertyEditor 日期属性编辑器
     * @return {@link CustomEditorConfigurer}
     */
    @Bean
    public static CustomEditorConfigurer customEditorConfigurer(PropertyEditorRegistrar datePropertyEditor){
        CustomEditorConfigurer editorConfigurer = new CustomEditorConfigurer();
        editorConfigurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{
                datePropertyEditor
        });
        return editorConfigurer;
    }

    @Bean
    public BeanFactoryPostProcessor myBeanFactoryPostProcess(@Value("#{'${bean.factory.replaceFiles}'.split(',')}") String[] replace){
        return new MyBeanFactoryPostProcess(replace);
    }

    //@Bean
    public BeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public TestConfigurationBean testConfigurationBean(){
        return new TestConfigurationBean(testBean());
    }

    @Bean
    public TestConfigurationBean testConfigurationBean1(){
        return new TestConfigurationBean(testBean());
    }

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }

}
