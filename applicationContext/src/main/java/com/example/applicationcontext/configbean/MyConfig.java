package com.example.applicationcontext.configbean;

import com.example.applicationcontext.convert.DatePropertyEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}
