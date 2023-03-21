package com.example.applicationcontext.configbean;

import com.example.applicationcontext.convert.DatePropertyEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer(){
        CustomEditorConfigurer editorConfigurer = new CustomEditorConfigurer();
        editorConfigurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{
                new DatePropertyEditor()
        });
        return editorConfigurer;
    }
}
