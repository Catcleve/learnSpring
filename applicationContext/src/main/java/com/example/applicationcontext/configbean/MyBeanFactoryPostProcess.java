package com.example.applicationcontext.configbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringValueResolver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcess(String... replace){
        this.replaceWords.addAll(Arrays.asList(replace));
    }


    private final Set<String> replaceWords = new HashSet<>();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        for (String name : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            StringValueResolver valueResolver = strVal -> {
                if (isObscene(strVal)) {
                    return "*******";
                } else {
                    return strVal;
                }
            };
            new BeanDefinitionVisitor(valueResolver).visitBeanDefinition(beanDefinition);
            PropertyValue password = beanDefinition.getPropertyValues().getPropertyValue("password");
            if (password != null && replaceWords.contains(password.getName())) {
                password.setConvertedValue("******");
            }
        }

    }

    public boolean isObscene(String value) {
        if (CollectionUtils.isEmpty(replaceWords)) {
            return false;
        } else {
            return replaceWords.contains(value);
        }
    }

}
