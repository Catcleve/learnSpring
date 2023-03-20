package com.example.demo.listen;

import org.springframework.beans.factory.parsing.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 自己的监听类
 * 没发现咋用
 *
 * @author maonengneng
 * @date 2023/03/06
 */
@Component
public class MyListen implements ReaderEventListener {

    @Override
    public void defaultsRegistered(DefaultsDefinition defaultsDefinition) {

    }

    @Override
    public void componentRegistered(ComponentDefinition componentDefinition) {
        Arrays.stream(componentDefinition.getBeanDefinitions()).forEach(c ->{
            System.out.println("className = " + c.getBeanClassName());
        });
    }

    @Override
    public void aliasRegistered(AliasDefinition aliasDefinition) {

    }

    @Override
    public void importProcessed(ImportDefinition importDefinition) {

    }
}
