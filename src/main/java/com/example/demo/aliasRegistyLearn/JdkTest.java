package com.example.demo.aliasRegistyLearn;

import org.junit.Test;

/**
 * 测试一些jdk特性
 * @author maonengneng
 * @date 2023/02/27
 */
public class JdkTest {

    /**
     * 默认缓存 -127到128的整形
     * 如果配置了 -XX:AutoBoxCacheMax=(范围) 则会缓存配置的数值
     * 最小为-127 最大为配置的值 不能小于128
     * 测试整数
     */
    @Test
    public void testInteger() {

        Integer integer1 = Integer.valueOf(11);
        Integer integer2 = Integer.valueOf(11);
        Integer integer3 = Integer.valueOf(228);
        Integer integer4 = Integer.valueOf(228);

        System.out.println(integer1 == integer2);
        System.out.println(integer3 == integer4);
    }


}
