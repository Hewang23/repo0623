package com.atguigu.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Hewang
 * @create 2020-05-04 16:47
 * @title
 */
@Repeatable(MyAnnotations.class)
@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String value() default "hello";
}
