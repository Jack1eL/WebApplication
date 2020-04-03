package com.ljackie.root.annotation;

import java.lang.annotation.*;

/**
 * @PackageName: com.ljackie.root.annotation
 * @Description: new instance annotation
 * @Author: ljackie
 * @Date: 2020/3/31 11:47 上午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BeanFactory {
    String value() default "";
}
