package com.example.applicationcontext.configbean;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
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

}
