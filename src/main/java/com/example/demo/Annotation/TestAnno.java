package com.example.demo.Annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * 测试注解
 *
 * @author maonengneng
 * @date 2023/02/25
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnno {

    String value();

}
