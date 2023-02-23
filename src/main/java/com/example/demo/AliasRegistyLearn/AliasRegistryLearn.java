package com.example.demo.AliasRegistyLearn;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author maonengneng
 */
public class AliasRegistryLearn {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerAlias("bean1","aaa");
        factory.registerAlias("aaa","bean1");
        factory.registerAlias("bean1","aab");
        factory.registerAlias("bean1","aac");
    }

}
